package com.mayuri.demo.moneycontrol.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MONEY_CONTROL_MODEL")
public class MoneyControlModel {
	
	@Id							// Specifies the primary key of an entity	
	@GeneratedValue(strategy = GenerationType.IDENTITY)   // handles database to generate sequence
	@Column(name="ID")   
	private Long id;
	
	@Column(name="FULL_MESSAGE")
	private String fullMessage;  // class states or instances variable
	
	@Column(name="NICK_NAME")
	private String nickname;
	
	@Column(name="TOTAL_MSG_COUNT")
	private int TOTAL_MSG_COUNT;
	
	@Column(name="STATUS")
	private String status;
	
	// class behavior (getters & setters)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFullMessage() {
		return fullMessage;
	}
	public void setFullMessage(String fullMessage) {
		this.fullMessage = fullMessage;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getTOTAL_MSG_COUNT() {
		return TOTAL_MSG_COUNT;
	}
	public void setTOTAL_MSG_COUNT(int tOTAL_MSG_COUNT) {
		TOTAL_MSG_COUNT = tOTAL_MSG_COUNT;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "MoneyControlModel [fullMessage=" + fullMessage + ", nickname=" + nickname + ", TOTAL_MSG_COUNT="
				+ TOTAL_MSG_COUNT + "]";
	}

	
	
}
