package com.jt.common.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.JsonResult;
/**全局异常处理类*/
@ControllerAdvice
public class GlobalExceptionHandler {
	  /**@ExceptionHandler 声明此方法是一个异常处理方法*/
      @ExceptionHandler(RuntimeException.class)
	  @ResponseBody
      public JsonResult doHandleRuntimeException(
			  RuntimeException e){
    	  e.printStackTrace();
		  return new JsonResult(e);
	  }
}






