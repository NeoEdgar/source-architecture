package org.edgar.neo.framework.aop.aspect;

import lombok.Data;
import java.lang.reflect.Method;

@Data
public class NeoAdvice {

    private Object aspect;
    private Method method;
    private String throwName;

    public NeoAdvice(Object aspect, Method method) {
        this.aspect = aspect;
        this.method = method;
    }
}
