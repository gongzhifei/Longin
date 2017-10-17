package com.gzf.validation;

import com.gzf.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * MyConstraint 绑定的注解名称， Object 作用在什么类型的变量或者方法上
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint,Object> {

    @Autowired
    private HelloService helloService;

    @Override
    public void initialize(MyConstraint constraintAnnotation) {
        System.out.println("Init myValidator");
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        String result = helloService.say("康康");
        System.out.println(result+value);
        return false;
    }
}
