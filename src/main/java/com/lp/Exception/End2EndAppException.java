package com.lp.Exception;

public class End2EndAppException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public End2EndAppException(){
		super();
	}
	
	public End2EndAppException(String message) {
		super(message);
	}

	public End2EndAppException(String message, Throwable cause) {
		super(message, cause);
	}

	public End2EndAppException(Throwable cause) {
		super(cause);
	}

}
