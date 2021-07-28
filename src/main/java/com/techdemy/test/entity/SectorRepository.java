package com.techdemy.test.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SectorRepository extends JpaRepository<Sector,Long>{
	Sector findBySectorName(String Name);
	
    @Query(value = "Select * from sector", nativeQuery = true)
    List<Object[]> getAllSectors();
}