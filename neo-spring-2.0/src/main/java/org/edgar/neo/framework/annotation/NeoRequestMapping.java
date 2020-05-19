package org.edgar.neo.framework.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NeoRequestMapping {
    String value() default "";
}
