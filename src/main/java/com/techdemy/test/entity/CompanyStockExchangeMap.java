package com.techdemy.test.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "CompanyStockexchangemap")
public class CompanyStockExchangeMap {

	@Id
	@GeneratedValue
	private long id;

	private String companyCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Company company;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private StockExchange stockexchange;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public StockExchange getStockexchange() {
		return stockexchange;
	}

	public void setStockexchange(StockExchange stockexchange) {
		this.stockexchange = stockexchange;
	}

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "compstockmap", cascade = CascadeType.ALL, targetEntity = StockPrice.class)
//	private List<StockPrice> stockprices;
	
	
}