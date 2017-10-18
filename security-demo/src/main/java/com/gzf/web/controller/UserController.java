package com.gzf.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.gzf.dto.User;
import com.gzf.dto.UserQueryCondition;
import com.gzf.exception.ControllerExceptionHandler;
import com.gzf.exception.ServiceException;
import com.gzf.exception.UserNotExitsException;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author GFZ
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> query(UserQueryCondition condition,@PageableDefault(size = 10,page = 2,sort = "username,asc") Pageable pageable){

        System.out.println(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));
        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getSort());
        System.out.println(pageable.getPageNumber());

        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @GetMapping("/{id:\\d+}")  //可写正则
    @JsonView(User.UserDetailsView.class)
    public User getUserInfo(@PathVariable String id){

//        throw new ServiceException(this.getClass().getName());
        System.out.println("id:"+id);
        System.out.println(Thread.currentThread().getName());
        User user = new User();
        user.setUsername("哈哈神");
        return user;
    }

    @PostMapping
    public User create(@Valid @RequestBody User user){
//        if(errors.hasErrors()){
//            errors.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
//        }
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthDay());
        user.setId("1");
        return user;
    }

    @PutMapping("/{id:\\d+}")
    public User update(@Valid @RequestBody User user, BindingResult errors){
        if(errors.hasErrors()){
            errors.getAllErrors().forEach(error -> {
                FieldError fieldError = (FieldError) error;
                String field = fieldError.getField();
                System.out.println(field+":"+error.getDefaultMessage());
            });

        }
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthDay());
        user.setId("1");
        return user;
    }

    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable String id){
        System.out.println("删除id:"+id);
    }

}
