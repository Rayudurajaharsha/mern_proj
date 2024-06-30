package com.ehome.responses;

public class CustomResponse {
	
	private boolean status;
	private int code;
	private String message;
	
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public CustomResponse(boolean status, int code, String message) {
		super();
		this.status = status;
		this.code = code;
		this.message = message;
	}

}
