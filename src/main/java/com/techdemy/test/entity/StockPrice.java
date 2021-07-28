package com.techdemy.test.entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "StockPrice")
public class StockPrice {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable = false)
	private String exchangename;
	
	@Column(nullable = false)
	private String companycode;
	
	@Column(nullable = false)
	private Date date;
	
	@Column(nullable = false)
	private Time time;
	
	@Column(nullable = false)
	private float shareprice;
	
	@Column(nullable = false)
	private float totalNumberOfShares;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Company company;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private StockExchange stockexchange;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private CompanyStockExchangeMap compstockmap;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getExchangename() {
		return exchangename;
	}

	public void setExchangename(String exchangename) {
		this.exchangename = exchangename;
	}

	public String getCompanycode() {
		return companycode;
	}

	public void setCompanycode(String companycode) {
		this.companycode = companycode;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public float getShareprice() {
		return shareprice;
	}

	public void setShareprice(float shareprice) {
		this.shareprice = shareprice;
	}

	public float getTotalNumberOfShares() {
		return totalNumberOfShares;
	}

	public void setTotalNumberOfShares(float totalNumberOfShares) {
		this.totalNumberOfShares = totalNumberOfShares;
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

	public CompanyStockExchangeMap getCompstockmap() {
		return compstockmap;
	}

	public void setCompstockmap(CompanyStockExchangeMap compstockmap) {
		this.compstockmap = compstockmap;
	}
	
	
}
