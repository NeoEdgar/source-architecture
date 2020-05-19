package org.edgar.neo.framework.beans.support;

import org.edgar.neo.framework.beans.config.NeoBeanDefinition;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class NeoBeanDefinitionReader {

    //配置文件对象
    private Properties contextConfig = new Properties();

    //保存扫描的结果, 文件全类名 className
    private List<String> registryBeanClasses = new ArrayList<String>();

    public NeoBeanDefinitionReader(String... configLocations) {
        //根据 configLocations 路径 load 配置文件
        doLoadConfig(configLocations[0]);

        //扫描配置文件中的配置的相关的类
        doScanner(contextConfig.getProperty("scanPackage"));
    }

    public Properties getConfig(){
        return this.contextConfig;
    }

    /**
     * 解析配置文件，封装成BeanDefinition
     *
     * @return
     */
    public List<NeoBeanDefinition> loadBeanDefinitions() {
        ArrayList<NeoBeanDefinition> beanDefinitions = new ArrayList<NeoBeanDefinition>();
        for (String className : registryBeanClasses) {
            Class<?> beanClass = null;
            try {
                beanClass = Class.forName(className);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            //接口不能实例化
            if (beanClass.isInterface()) {
                continue;
            }
            //保存类对应的ClassName（全类名）

            //1、默认是类名首字母小写
            beanDefinitions.add(doCreateBeanDefinition(toLowerFirstCase(beanClass.getSimpleName()), beanClass.getName()));

            //2、自定义 //解读注解的value

            //3、接口注入
            for (Class<?> i : beanClass.getInterfaces()) {
                beanDefinitions.add(doCreateBeanDefinition(i.getName(), beanClass.getName()));
            }

        }
        return beanDefinitions;
    }


    private NeoBeanDefinition doCreateBeanDefinition(String beanName, String beanClassName) {
        NeoBeanDefinition beanDefinition = new NeoBeanDefinition();
        beanDefinition.setFactoryBeanName(beanName);
        beanDefinition.setBeanClassName(beanClassName);
        return beanDefinition;
    }

    private void doScanner(String scanPackage) {
        //jar 、 war 、zip 、rar
        URL url = this.getClass().getClassLoader().getResource("/" + scanPackage.replaceAll("\\.", "/"));
        File classPath = new File(url.getFile());

        //当成是一个ClassPath文件夹
        for (File file : classPath.listFiles()) {
            if (file.isDirectory()) {
                doScanner(scanPackage + "." + file.getName());
            } else {
                if (!file.getName().endsWith(".class")) {
                    continue;
                }
                //全类名 = 包名.类名
                String className = (scanPackage + "." + file.getName().replace(".class", ""));
                //Class.forName(className);
                registryBeanClasses.add(className);
            }
        }
    }

    private void doLoadConfig(String configLocation) {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(configLocation.replaceAll("classpath", ""));
        try {
            contextConfig.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is == null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //首字母变小写
    private String toLowerFirstCase(String simpleName) {
        char[] chars = simpleName.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }


}
