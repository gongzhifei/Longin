package com.gzf.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.Map;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(UserNotExistException.class)
	@ResponseBody
	@ReponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handleUserNotExistException(UserNotExistException ex){
        Map<String,Object> result = new HashMap<>();
		result.put("id",ex.getId());
		result.put("message",ex.getMeesage());
		return result;
    }

}
