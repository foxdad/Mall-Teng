package com.lt.user.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author xiaohu
 * @version 1.0
 * @date 2021/2/3 0:05
 */

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {MobileValidate.class})
public @interface MobilePattern {
    String regexp() default "";

    String message() default "手机格式不正确";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
