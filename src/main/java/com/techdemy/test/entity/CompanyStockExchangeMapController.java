package com.techdemy.test.entity;

import org.springframework.beans.factory.annotation.Autowired;

public class CompanyStockExchangeMapController {
	@Autowired
	CompanyRepository cmprep;
	@Autowired
	SectorRepository secrep;
	@Autowired
	StockExchangeRepository stkrep;
	@Autowired
	CompanyStockExchangeMapRepository stkcmpmaprep;
	
}
