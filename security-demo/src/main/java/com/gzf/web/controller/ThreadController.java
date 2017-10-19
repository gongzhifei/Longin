package com.gzf.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author gongzhifei
 */
@RestController
public class ThreadController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private Boolean IS_FIRST = true;


    @GetMapping("/test")
    public String getTest() {
        String result = "";
        if(IS_FIRST){
            IS_FIRST = false;
            result = "123";
            System.out.println(result);
            return result;
        }else{
            result = "456";
            System.out.println(result);
            return result;
        }
    }

}
