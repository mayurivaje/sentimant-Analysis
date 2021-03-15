package com.mayuri.demo.moneycontrol.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MoneyControlLiveModel {

	
	private int TOTAL_MSG_CNT;
	private String nick_name;
	private String full_message;
	
	
	public int getTOTAL_MSG_CNT() {
		return TOTAL_MSG_CNT;
	}
	public void setTOTAL_MSG_CNT(int tOTAL_MSG_CNT) {
		TOTAL_MSG_CNT = tOTAL_MSG_CNT;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public String getFull_message() {
		return full_message;
	}
	public void setFull_message(String full_message) {
		this.full_message = full_message;
	}
	
	
}
