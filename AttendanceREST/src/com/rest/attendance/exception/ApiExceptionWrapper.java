/**
 *
 */
package com.rest.attendance.exception;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Base exception wrapper.
 * 
 * @author d.gajic, dj.ivkovic
 */
@XmlRootElement(name = "error")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class ApiExceptionWrapper {
	@XmlElement
	private String errorType;
	@XmlElement
	private String errorStatus;
	@XmlElement
	private String errorMessage;
	@XmlElement(name = "errors")
	private List<APIError> errors;

	public ApiExceptionWrapper() {
	}

	public ApiExceptionWrapper(String type, String message) {
		this.errorType = type;
		this.errorMessage = message;
	}

	public ApiExceptionWrapper(String type, String message, String status) {
		this.errorType = type;
		this.errorMessage = message;
		this.errorStatus = status;
	}

	public ApiExceptionWrapper(String type, String message, String status, List<APIError> errors) {
		this.errorType = type;
		this.errorMessage = message;
		this.errorStatus = status;
		this.errors = errors;
	}

	public ApiExceptionWrapper(String type, String message, String status, APIError apiError) {
		this.errorType = type;
		this.errorMessage = message;
		this.errorStatus = status;
		errors = new ArrayList<APIError>();
		errors.add(apiError);
	}

	public String getType() {
		return errorType;
	}

	public void setType(String type) {
		this.errorType = type;
	}

	public String getMessage() {
		return errorMessage;
	}

	public void setMessage(String message) {
		this.errorMessage = message;
	}
}
