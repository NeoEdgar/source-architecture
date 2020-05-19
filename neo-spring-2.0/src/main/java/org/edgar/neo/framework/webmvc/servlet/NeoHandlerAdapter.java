package org.edgar.neo.framework.webmvc.servlet;

import org.edgar.neo.framework.annotation.NeoRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NeoHandlerAdapter {


    public NeoModelAndView handler(HttpServletRequest req, HttpServletResponse resp, NeoHandlerMapping handlerMapping) throws InvocationTargetException, IllegalAccessException {

        //保存形参列表
        //将参数名称和参数的位置，这种关系保存起来
        Map<String, Integer> paramIndexMapping = new HashMap<String, Integer>();

        //通过运行时状态去拿到你的参数
        //理解二维数组（一个参数----多个注解）(没有注解的参数，此处是否有？todo)
        Annotation[][] parameterAnnotations = handlerMapping.getMethod().getParameterAnnotations();
        for (int i = 0; i < parameterAnnotations.length; i++) {
            for (Annotation annotation : parameterAnnotations[i]) {
                if (annotation instanceof NeoRequestParam){
                    String paramName = ((NeoRequestParam) annotation).value();
                    if (!"".equals(paramName.trim())){
                        paramIndexMapping.put(paramName, i);
                    }
                }
            }
        }

        //初始化一下
        Class<?>[] parameterTypes = handlerMapping.getMethod().getParameterTypes();
        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> parameterType = parameterTypes[i];
            if (parameterType == HttpServletRequest.class || parameterType == HttpServletResponse.class){
                paramIndexMapping.put(parameterType.getName(), i);
            }
        }

        //去拼接实参列表
        //http://localhost/web/query?name=Tom&Cat
        Map<String,String[]> params = req.getParameterMap();

        Object [] paramValues = new Object[parameterTypes.length];

        for (Map.Entry<String,String[]> param : params.entrySet()) {
            String value = Arrays.toString(params.get(param.getKey()))
                    .replaceAll("\\[|\\]","")
                    .replaceAll("\\s+",",");

            if(!paramIndexMapping.containsKey(param.getKey())){continue;}

            int index = paramIndexMapping.get(param.getKey());

            //允许自定义的类型转换器Converter
            paramValues[index] = castStringValue(value,parameterTypes[index]);
        }

        if(paramIndexMapping.containsKey(HttpServletRequest.class.getName())){
            int index = paramIndexMapping.get(HttpServletRequest.class.getName());
            paramValues[index] = req;
        }

        if(paramIndexMapping.containsKey(HttpServletResponse.class.getName())){
            int index = paramIndexMapping.get(HttpServletResponse.class.getName());
            paramValues[index] = resp;
        }

        // 执行方法
        Object result = handlerMapping.getMethod().invoke(handlerMapping.getController(), paramValues);

        if(result == null || result instanceof Void){return null;}

        boolean isModelAndView = handlerMapping.getMethod().getReturnType() == NeoModelAndView.class;
        if(isModelAndView){
            return (NeoModelAndView)result;
        }
        return null;
    }

    private Object castStringValue(String value, Class<?> paramType) {
        if(String.class == paramType){
            return value;
        }else if(Integer.class == paramType){
            return Integer.valueOf(value);
        }else if(Double.class == paramType){
            return Double.valueOf(value);
        }else {
            if(value != null){
                return value;
            }
            return null;
        }

    }
}
