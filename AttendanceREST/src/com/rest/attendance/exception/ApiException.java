/**
 * 
 */
package com.rest.attendance.exception;

import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * This base exception for all API exceptions.
 * 
 * @author d.gajic, dj.ivkovic
 */
public class ApiException extends WebApplicationException {
	private int status;
	private Throwable cause;

    public static final String FAIL_STATUS = "fail";
    public static final String ERROR_STATUS = "error";
    public static final String SUCCESS_STATUS = "success";

	/**
	 * 
	 */
	private static final long serialVersionUID = 13040808321992484L;
	

	/**
	 * Constructor.
	 * 
	 * @param status
	 * @param type
	 * @param message
	 */
	public ApiException(Throwable cause, int status, String type, String message) {

        super(cause,Response.status(status)
                .entity(new ApiExceptionWrapper(type, message))
                .build());
	}
	
	/**
	 * Constructor.
	 * 
	 * @param status
	 * @param message
	 */
	public ApiException(Throwable cause, int status, String message) {
		this(cause, status, "ApiException", message);
	}


    public ApiException(int status, String message, String statusMessage) {
        super(Response.status(status)
                .entity(new ApiExceptionWrapper("ApiException", message, statusMessage))
                .build());
    }
    
    public ApiException(Throwable cause, int status, String type, String message, List<APIError> errors) {
        super(Response.status(status)
                .entity(new ApiExceptionWrapper(type, message, String.valueOf(status), errors))
                .build());
	}
    
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Throwable getCause() {
		return cause;
	}

	public void setCause(Throwable cause) {
		this.cause = cause;
	}

}
