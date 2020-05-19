package org.edgar.neo.framework.aop.support;

import org.edgar.neo.framework.aop.aspect.NeoAdvice;
import org.edgar.neo.framework.aop.config.NeoAopConfig;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NeoAdvisedSupport {

    private NeoAopConfig config;
    private Object target;
    private Class targetClass;
    private Pattern pointCutClassPattern;

    private Map<Method, Map<String, NeoAdvice>> methodCache;

    public NeoAdvisedSupport(NeoAopConfig config) {
        this.config = config;
    }

    // 解析配置文件的方法
    private void parse() {
        // 把Spring的Express变成Java能够识别的正则表达式
        String pointCut = config.getPointCut()
                .replaceAll("\\.", "\\\\.")
                .replaceAll("\\\\.\\*", ".*")
                .replaceAll("\\(", "\\\\(")
                .replaceAll("\\)", "\\\\)");

        // 保存专门匹配Class的正则
        String pointCutForClassRegex = pointCut.substring(0, pointCut.lastIndexOf("\\(") - 4);
        pointCutClassPattern = Pattern.compile("class " + pointCutForClassRegex.substring(pointCutForClassRegex.lastIndexOf(" ") + 1));

        //方法对应的织入通知
        methodCache = new HashMap<Method, Map<String, NeoAdvice>>();

        //保存专门匹配方法的正则
        Pattern pointCutPattern = Pattern.compile(pointCut);

        try {
            // 获取织入的切面方法
            Class<?> aspectClass = Class.forName(this.config.getAspectClass());
            HashMap<String, Method> aspectMethods = new HashMap<String, Method>();
            for (Method method : aspectClass.getMethods()) {
                aspectMethods.put(method.getName(), method);
            }

            // 匹配目标对象的目标方法，绑定通知切面方法
            for (Method method : this.targetClass.getMethods()) {
                String methodString = method.toString();
                if (methodString.contains("throws")) {
                    methodString = methodString.substring(0, methodString.lastIndexOf("throws")).trim();
                }

                //正则匹配方法是否需要通知
                Matcher matcher = pointCutPattern.matcher(methodString);
                if (matcher.matches()) {
                    HashMap<String, NeoAdvice> advices = new HashMap<String, NeoAdvice>();


                    if (!(null == config.getAspectBefore() || "".equals(config.getAspectBefore()))) {
                        advices.put("before", new NeoAdvice(aspectClass.newInstance(), aspectMethods.get(config.getAspectBefore())));
                    }
                    if (!(null == config.getAspectAfter() || "".equals(config.getAspectAfter()))) {
                        advices.put("after", new NeoAdvice(aspectClass.newInstance(), aspectMethods.get(config.getAspectAfter())));
                    }
                    if (!(null == config.getAspectAfterThrow() || "".equals(config.getAspectAfterThrow()))) {
                        NeoAdvice advice = new NeoAdvice(aspectClass.newInstance(), aspectMethods.get(config.getAspectAfterThrow()));
                        advice.setThrowName(config.getAspectAfterThrowingName());
                        advices.put("afterThrow", advice);
                    }

                    //跟目标代理类的业务方法和Advices建立一对多个关联关系，以便在Porxy类中获得
                    methodCache.put(method, advices);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Class getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(Class targetClass) {
        this.targetClass = targetClass;
        parse();
    }

    //给ApplicationContext Ioc中的对象初始化时调用，决定要不要生成代理类的逻辑
    public boolean pointCutMatch() {
        return pointCutClassPattern.matcher(this.targetClass.toString()).matches();
    }

    //根据一个目标代理类的方法，获得其对应的通知
    public Map<String, NeoAdvice> getAdvices(Method method, Object o) throws NoSuchMethodException {
        Map<String, NeoAdvice> cache = methodCache.get(method);
        if (cache == null) {
            Method m = targetClass.getMethod(method.getName(), method.getParameterTypes());
            cache = methodCache.get(m);
            this.methodCache.put(m, cache);
        }
        return cache;
    }
}
