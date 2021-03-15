package com.mayuri.demo.moneycontrol.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="negative_words")
public class NegativeWordsModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="ID")
	private Long id;
	
	@Column(name="NEGATIVE_WORDS")
	private String negative_words;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNegative_words() {
		return negative_words;
	}
	public void setNegative_words(String negative_words) {
		this.negative_words = negative_words;
	}
	
	@Override
	public String toString() {
		return "NegativeWordsModel [id=" + id + ", negative_words=" + negative_words + "]";
	}
	
}
