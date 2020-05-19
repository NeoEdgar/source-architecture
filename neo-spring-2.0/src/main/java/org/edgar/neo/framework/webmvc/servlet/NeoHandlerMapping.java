package org.edgar.neo.framework.webmvc.servlet;

import lombok.Data;

import java.lang.reflect.Method;
import java.util.regex.Pattern;

@Data
public class NeoHandlerMapping {

    private Pattern pattern; //URL
    private Method method; //对应的Method
    private Object controller; //Method对应的实例对象

    public NeoHandlerMapping(Pattern pattern, Method method, Object controller) {
        this.pattern = pattern;
        this.method = method;
        this.controller = controller;
    }


}
