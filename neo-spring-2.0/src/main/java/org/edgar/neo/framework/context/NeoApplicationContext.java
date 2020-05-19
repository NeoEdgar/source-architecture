package org.edgar.neo.framework.context;

import org.edgar.neo.framework.annotation.NeoAutowired;
import org.edgar.neo.framework.annotation.NeoController;
import org.edgar.neo.framework.annotation.NeoService;
import org.edgar.neo.framework.aop.JDKDynamicAopProxy;
import org.edgar.neo.framework.aop.config.NeoAopConfig;
import org.edgar.neo.framework.aop.support.NeoAdvisedSupport;
import org.edgar.neo.framework.beans.NeoBeanWrapper;
import org.edgar.neo.framework.beans.config.NeoBeanDefinition;
import org.edgar.neo.framework.beans.support.NeoBeanDefinitionReader;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 职责：完成Bean的创建和DI
 */
public class NeoApplicationContext {

    private NeoBeanDefinitionReader reader;

    //未实例化类信息
    private Map<String, NeoBeanDefinition> beanDefinitionMap = new HashMap<String, NeoBeanDefinition>();

    //封装实例容器，原始、代理等
    private Map<String, NeoBeanWrapper> factoryBeanInstanceCache = new HashMap<String, NeoBeanWrapper>();

    //原始实例容器
    private Map<String,Object> factoryBeanObjectCache = new HashMap<String, Object>();

    public NeoApplicationContext(String... configLocations) {
        try {
            //1、加载配置文件
            reader = new NeoBeanDefinitionReader(configLocations);

            //2、解析配置文件，封装成BeanDefinition
            List<NeoBeanDefinition> beanDefinitions = reader.loadBeanDefinitions();

            //3、把BeanDefinition缓存至Map,并去重
            doRegistBeanDefinition(beanDefinitions);

            //4、自动注入
            doAutowired();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doRegistBeanDefinition(List<NeoBeanDefinition> beanDefinitions) throws Exception {
        for (NeoBeanDefinition beanDefinition : beanDefinitions) {
            // simpleName 重复？
            if (this.beanDefinitionMap.containsKey(beanDefinition.getFactoryBeanName())) {
                throw new Exception("The " + beanDefinition.getFactoryBeanName() + "is exists");
            }
            beanDefinitionMap.put(beanDefinition.getFactoryBeanName(), beanDefinition);
            beanDefinitionMap.put(beanDefinition.getBeanClassName(), beanDefinition);
        }

    }

    private void doAutowired() {
        //调用getBean()
        //这一步，所有的Bean并没有真正的实例化，还只是配置阶段
        for (Map.Entry<String, NeoBeanDefinition> beanDefinitionEntry : this.beanDefinitionMap.entrySet()) {
            String beanName = beanDefinitionEntry.getKey();
            getBean(beanName);
        }

    }

    /**
     * 通过beanName名称拿实例
     * Bean的实例化，DI是从而这个方法开始的
     * @param beanName
     */
    public Object getBean(String beanName) {
        //1、先拿到BeanDefinition配置信息
        NeoBeanDefinition beanDefinition = beanDefinitionMap.get(beanName);

        //2、反射实例化 newInstance()
        Object instance = instantiateBean(beanName, beanDefinition);

        //3、封装成一个BeanWrapper
        NeoBeanWrapper beanWrapper = new NeoBeanWrapper(instance);

        //4、保存到IOC容器
        factoryBeanInstanceCache.put(beanName, beanWrapper);

        //5、执行依赖注入
        populateBean(beanName, beanDefinition, beanWrapper);

        return beanWrapper.getWrapperInstance();
    }

    /**
     * 通过Class拿实例
     * @param beanClass
     * @return
     */
    public Object getBean(Class beanClass){
        return getBean(beanClass.getName());
    }

    //autowired自动注入
    private void populateBean(String beanName, NeoBeanDefinition beanDefinition, NeoBeanWrapper beanWrapper) {
        //可能涉及到循环依赖？
        //1、把第一次读取结果为空的BeanDefinition存到第一个缓存
        //2、等第一次循环之后，第二次循环再检查第一次的缓存，再进行赋值

        Object instance = beanWrapper.getWrapperInstance();
        Class<?> clazz = beanWrapper.getWrapperClass();

        //在Spring中@Component
        if(!(clazz.isAnnotationPresent(NeoController.class) || clazz.isAnnotationPresent(NeoService.class))){
            return;
        }

        //把所有的包括private/protected/default/public 修饰字段都取出来
        for (Field field : clazz.getDeclaredFields()) {
            if(!field.isAnnotationPresent(NeoAutowired.class)){ continue; }

            NeoAutowired autowired = field.getAnnotation(NeoAutowired.class);

            //如果用户没有自定义的beanName，就默认根据类型注入
            String autowiredBeanName = autowired.value().trim();
            if("".equals(autowiredBeanName)){
                //field.getType().getName() 获取字段的类型（className）
                autowiredBeanName = field.getType().getName();
            }

            //暴力访问
            field.setAccessible(true);

            try {
                if(this.factoryBeanInstanceCache.get(autowiredBeanName) == null){
                    continue;
                }
                //ioc.get(beanName) 相当于通过接口的全名拿到接口的实现的实例
                field.set(instance,this.factoryBeanInstanceCache.get(autowiredBeanName).getWrapperInstance());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                continue;
            }
        }

    }

    // 创建真正的实例对象
    private Object instantiateBean(String beanName, NeoBeanDefinition beanDefinition) {

        String beanClassName = beanDefinition.getBeanClassName();
        Object instance = null;
        try {
            // 单例判断
            if (this.factoryBeanObjectCache.containsKey(beanName)){
                instance = this.factoryBeanObjectCache.get(beanName);
            }else {
                Class<?> clazz = Class.forName(beanClassName);
                instance = clazz.newInstance();
                if (instance == null){
                    System.out.println("=====instance null" + clazz);
                }

                /**
                 * Aop
                 */
                //======================Aop结束================================
                // 1、加载AOP的配置规则
                NeoAdvisedSupport support = instantionAopConfig(beanDefinition);
                support.setTargetClass(clazz);
                support.setTarget(instance);
                // 2、判断规则，要不要生成代理类，如果要就覆盖原生对象，如果不要就不做任何处理，返回原生对象
                if (support.pointCutMatch()){
                    instance = new JDKDynamicAopProxy(support).getProxy();
                }
                //======================Aop结束================================

                this.factoryBeanObjectCache.put(beanName, instance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }

    private NeoAdvisedSupport instantionAopConfig(NeoBeanDefinition beanDefinition) {
        NeoAopConfig config = new NeoAopConfig();
        config.setPointCut(this.reader.getConfig().getProperty("pointCut"));
        config.setAspectClass(this.reader.getConfig().getProperty("aspectClass"));
        config.setAspectBefore(this.reader.getConfig().getProperty("aspectBefore"));
        config.setAspectAfter(this.reader.getConfig().getProperty("aspectAfter"));
        config.setAspectAfterThrow(this.reader.getConfig().getProperty("aspectAfterThrow"));
        config.setAspectAfterThrowingName(this.reader.getConfig().getProperty("aspectAfterThrowingName"));
        return new NeoAdvisedSupport(config);
    }

    public int getBeanDefinitionCount() {
        return beanDefinitionMap.size();
    }

    public String[] getBeanDefinitionNames() {
        return this.beanDefinitionMap.keySet().toArray(new String[beanDefinitionMap.size()]);
    }

    public Properties getConfig() {
        return this.reader.getConfig();
    }
}
