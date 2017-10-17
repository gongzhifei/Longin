package com.gzf.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 */
@Target({ElementType.METHOD,ElementType.FIELD})     //注解定义在哪里
@Retention(RetentionPolicy.RUNTIME)    //运行时注解
@Constraint(validatedBy = MyConstraintValidator.class)//执行哪里的代码
public @interface MyConstraint {
    String message() default "{失败}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
