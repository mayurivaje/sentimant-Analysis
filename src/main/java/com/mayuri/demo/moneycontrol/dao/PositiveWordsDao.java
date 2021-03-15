package com.mayuri.demo.moneycontrol.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mayuri.demo.moneycontrol.model.PositiveWordsModel;

public interface PositiveWordsDao extends JpaRepository<PositiveWordsModel, Long> {

	@Query(nativeQuery = true, value = "select POSITIVE_WORDS from positive_words")
	List<Object[]> findByPositiveWords();

}
