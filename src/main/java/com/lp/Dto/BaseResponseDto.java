package com.lp.Dto;

import java.io.Serializable;

public class BaseResponseDto implements Serializable{

	public BaseResponseDto(String message, String status, Object object) {
		super();
		this.message = message;
		this.status = status;
		this.object = object;
	}
	private static final long serialVersionUID = 1L;
	
	private String message;
	private String status;
	private Object object;
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	@Override
	public String toString() {
		return "BaseResponseTO [message=" + message + ", status=" + status
				+ ", object=" + object + "]";
	}

	

}
