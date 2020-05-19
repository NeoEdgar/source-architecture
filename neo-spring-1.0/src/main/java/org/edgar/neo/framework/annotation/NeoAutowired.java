package org.edgar.neo.framework.annotation;

import java.lang.annotation.*;

@Target(ElementType.FIELD) //注解对象：字段
@Retention(RetentionPolicy.RUNTIME) //保留注释的各种策略:注解的生命周期
@Documented // javadoc记录,公共API
public @interface NeoAutowired {
    String value() default "";
}
