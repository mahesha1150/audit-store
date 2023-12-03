package com.metakeep.auditstore.bean;

import java.util.Date;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;


public class AuditBean {
	
	private String userId;
	private Date requestTime;
	private String status;
	private String errorMessage;
	private String httpServletRequest;
	private String httpServletResponse;
	public AuditBean(String userId, Date requestTime, String status, String errorMessage,
			String httpServletRequest, String httpServletResponse) {
		super();
		this.userId = userId;
		this.requestTime = requestTime;
		this.status = status;
		this.errorMessage = errorMessage;
		this.httpServletRequest = httpServletRequest;
		this.httpServletResponse = httpServletResponse;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getHttpServletRequest() {
		return httpServletRequest;
	}
	public void setHttpServletRequest(String httpServletRequest) {
		this.httpServletRequest = httpServletRequest;
	}
	public String getHttpServletResponse() {
		return httpServletResponse;
	}
	public void setHttpServletResponse(String httpServletResponse) {
		this.httpServletResponse = httpServletResponse;
	}
	
}
