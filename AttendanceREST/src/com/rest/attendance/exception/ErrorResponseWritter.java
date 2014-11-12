/**
 * 
 */
package com.rest.attendance.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Write customized error message to servlet response.
 * Used mainly to suppress container default HTML messages,
 * instead of which the appropriate formatted (JSON/XML) might be sent. 
 * 
 * @author d.gajic
 */
public interface ErrorResponseWritter<T extends Throwable> {
	
	/**
	 * Writes customized error message, HTTP status code and set headers if needed.
	 * 
	 * @param request
	 * @param response
	 * @param exception
	 * @throws java.io.IOException
	 */
	void write(HttpServletRequest request, HttpServletResponse response, T exception) throws IOException;	
}