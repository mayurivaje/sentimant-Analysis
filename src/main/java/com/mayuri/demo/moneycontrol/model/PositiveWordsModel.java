package com.mayuri.demo.moneycontrol.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="positive_words")
public class PositiveWordsModel {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="ID")	
	private Long id;

	@Column(name="POSITIVE_WORDS")
	private String positiveWords;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPositiveWords() {
		return positiveWords;
	}

	public void setPositiveWords(String positiveWords) {
		this.positiveWords = positiveWords;
	}

	

	@Override
	public String toString() {
		return "PositiveNegativeWordsModel [id=" + id + ", positiveWords=" + positiveWords + "]";
	}

}
