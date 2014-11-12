package com.rest.attendance.exception;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "error")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class APIError {
	@XmlElement
	private Integer code;
	@XmlElement
	private String field;
	@XmlElement
	private String message;
	
	public APIError() {
	}
	
	public APIError(Integer code, String field, String message) {
		this.code = code;
		this.field = field;
		this.message = message;
	}
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
