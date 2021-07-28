package com.techdemy.test.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CompanyStockExchangeMapRepository extends JpaRepository<CompanyStockExchangeMap,Long>{

	List<CompanyStockExchangeMap> findAll();
	
	@Query(value = "Select * from COMPANY_STOCKEXCHANGEMAP", nativeQuery = true)
    List<Object[]> findAllMaps();

}
