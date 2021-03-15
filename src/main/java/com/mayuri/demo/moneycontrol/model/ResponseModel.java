package com.mayuri.demo.moneycontrol.model;

import java.util.Map;

public class ResponseModel {

	private String responseCode;
	private String responseStatus;
	private Map data;
	private String error;
	
	
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}
	public Map getData() {
		return data;
	}
	public void setData(Map data) {
		this.data = data;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	
	@Override
	public String toString() {
		return "ResponseModel [responseCode=" + responseCode + ", responseStatus=" + responseStatus + ", data=" + data
				+ ", error=" + error + "]";
	}
	
		
}
