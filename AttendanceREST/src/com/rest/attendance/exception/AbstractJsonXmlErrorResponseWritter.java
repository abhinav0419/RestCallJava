package com.rest.attendance.exception;

import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AbstractJsonXmlErrorResponseWritter<T extends Throwable> implements
		ErrorResponseWritter<T> {

	@Override
	public void write(HttpServletRequest request, HttpServletResponse response,
			T exception) throws IOException {
		
		response.setStatus(resolveHttpStatusCode(request, exception));	
		
		MediaType mediaType = resolveMediaType(request, exception);
		response.setContentType(mediaType.getType());
		
		writeBody(mediaType, request, exception, response);
	}
	
	protected MediaType resolveMediaType(HttpServletRequest request, T exception) {
		MediaType mediaType = MediaType.APPLICATION_JSON;
		String acceptHeader = request.getHeader("Accept");
		if ("application/xml".equalsIgnoreCase(acceptHeader)) {
			mediaType = MediaType.APPLICATION_XML;
		}
		return mediaType;
	}
	
	protected void writeBody(MediaType mediaType, HttpServletRequest request, T exception, HttpServletResponse response) throws IOException {
		StringBuffer buff = new StringBuffer();
		String type = resolveErrorType(request, exception);
		String message = resolveErrorMessage(request, exception);
		
		if (mediaType == MediaType.APPLICATION_JSON) {
			buff.append("{ \"type\": ")
				.append("\"").append(type).append("\",")
				.append("\"message\": ")
				.append("\"").append(message).append("\" }");
		} else {
			buff.append("<error>").append('\n')
				.append("<type>").append(type).append("</type>").append('\n')
				.append("<message>").append(message).append("</message>").append('\n')
				.append("</error>");
		}
		
		response.getWriter().append(buff.toString());
	}
	
	protected abstract int resolveHttpStatusCode(HttpServletRequest request, T exception);
	
	protected abstract String resolveErrorType(HttpServletRequest request, T exception);
	
	protected abstract String resolveErrorMessage(HttpServletRequest request, T exception);
}
