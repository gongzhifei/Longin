package com.gzf.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerExceptionHandler extends Throwable {

	@ExceptionHandler(UserNotExitsException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handleUserNotExistException(UserNotExitsException ex){
        Map<String,Object> result = new HashMap<>();
		result.put("id",ex.getId());
		result.put("message",ex.getMessage());
		return result;
    }

    @ExceptionHandler(ServiceException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,Object> handleServiceException(ServiceException ex){
		Map<String,Object> result = new HashMap<>();
		result.put("className",ex.getClassName());
		result.put("message",ex.getMessage());
		return result;
	}

}
