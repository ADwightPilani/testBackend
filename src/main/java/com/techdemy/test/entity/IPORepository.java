package com.techdemy.test.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IPORepository extends JpaRepository<IPODetail, Long> {
	IPODetail findById(long id);

	IPODetail findByCompanyname(String Name);

	// Company findByceo(String ceo);
	@Query(value = "Select * from IPO", nativeQuery = true)
	List<Object[]> findAllIPO();
}
