package com.jt.common.exception;
/**
 * 自定义异常类(继承RuntimeException或Exception)
 * 建议:自己定义的异常继承RuntimeException
 * @author Administrator
 */
public class ServiceException extends RuntimeException {
	private static final long serialVersionUID = 
			                     8029523183323748146L;
	public ServiceException() {
		super();
	}
	public ServiceException(String message) {
		super(message);
	}
	public ServiceException(Throwable cause) {
		super(cause);
	}
     
}
