package com.techdemy.test.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StockExchangeRepository extends JpaRepository<StockExchange,Long> {
	  StockExchange findByName(String Name);
	  
	  @Query(value = "Select * from stock_exchange", nativeQuery = true)
	  List<Object[]> findAllExchanges();
}