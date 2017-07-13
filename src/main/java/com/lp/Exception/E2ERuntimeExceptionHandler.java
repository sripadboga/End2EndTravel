package com.lp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST,reason="Due to bad request")
public class E2ERuntimeExceptionHandler extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public E2ERuntimeExceptionHandler() {
        super();
    }
    public E2ERuntimeExceptionHandler(String s) {
        super(s);
    }
    public E2ERuntimeExceptionHandler(String s, Throwable throwable) {
        super(s, throwable);
    }
    public E2ERuntimeExceptionHandler(Throwable throwable) {
        super(throwable);
    }

}
