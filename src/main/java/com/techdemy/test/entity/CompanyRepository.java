package com.techdemy.test.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CompanyRepository extends JpaRepository<Company,Long>{
	Company findByName(String Name);
	//Company findByceo(String ceo);
    @Query(value = "SELECT c.id as cid,c.name as cname,stk.name as exc,c.company_brief as brief from Company c inner join company_stockexchangemap map on c.id = map.company_id inner join Stock_exchange stk on map.stockexchange_id=stk.id", nativeQuery = true)
    List<Object[]> findjoined();
    
    @Query(value = "Select * from company", nativeQuery = true)
    List<Object[]> findAllCompanies();
    
    @Query(value = "Select * from company c where c.name = :name", nativeQuery = true)
    List<Object[]> findByNameCustom(@Param("name")String name);
}