package com.mayuri.demo.moneycontrol.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mayuri.demo.moneycontrol.model.NegativeWordsModel;

public interface NegativeWordsDao extends JpaRepository<NegativeWordsModel, Long>{
	
	@Query(nativeQuery = true, value = "select NEGATIVE_WORDS from negative_words")
	List<Object[]> findByNegativeWords();

}
