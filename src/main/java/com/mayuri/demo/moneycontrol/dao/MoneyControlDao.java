package com.mayuri.demo.moneycontrol.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mayuri.demo.moneycontrol.model.MoneyControlModel;

@Repository
public interface MoneyControlDao extends JpaRepository<MoneyControlModel, Long>{

	public List<MoneyControlModel> findByNickname(String nickname);

}
