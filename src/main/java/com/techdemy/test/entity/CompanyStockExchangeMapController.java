package com.techdemy.test.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class CompanyStockExchangeMapController {
	@Autowired
	CompanyRepository cmprep;
	@Autowired
	SectorRepository secrep;
	@Autowired
	StockExchangeRepository stkrep;
	@Autowired
	CompanyStockExchangeMapRepository stkcmpmaprep;
	
	@RequestMapping(value="/getAllMaps", method = RequestMethod.GET)
	public List<Object[]> getAllMaps(){
		List<Object[]> results=stkcmpmaprep.findAllMaps();
//		for(int i=0; i<results.size(); i++) {
//			System.out.println(results.get(i));
//		}
		return results;
	};
}
