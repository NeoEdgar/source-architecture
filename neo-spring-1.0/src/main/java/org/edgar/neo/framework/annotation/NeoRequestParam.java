package org.edgar.neo.framework.annotation;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NeoRequestParam {
    String value() default "";
}
