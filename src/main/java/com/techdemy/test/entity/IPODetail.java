package com.techdemy.test.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "IPO")
public class IPODetail {
	public IPODetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(nullable = false)
	private Double pricePerShare;

	@Column(nullable = false)
	private Long totalNumberOfShares;
	
	@Column(nullable = false)
	private String companyname;
	
	@Column(nullable = false)
	private String stockexchangename;
	
	@Column(nullable = false)
	private String companycode;

	@Column(nullable = false)
	private String remarks;
	@Column(nullable = false)
	private LocalDateTime openDateTime;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Company company;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private StockExchange stockexchange;


//	@ManyToMany
//	private List<StockExchange> stockExchanges = new ArrayList<>();
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Double getPricePerShare() {
		return pricePerShare;
	}

	public void setPricePerShare(Double pricePerShare) {
		this.pricePerShare = pricePerShare;
	}

	public Long getTotalNumberOfShares() {
		return totalNumberOfShares;
	}

	public void setTotalNumberOfShares(Long totalNumberOfShares) {
		this.totalNumberOfShares = totalNumberOfShares;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public LocalDateTime getOpenDateTime() {
		return openDateTime;
	}

	public void setOpenDateTime(LocalDateTime openDateTime) {
		this.openDateTime = openDateTime;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

//	public List<StockExchange> getStockExchanges() {
//		return stockExchanges;
//	}
//
//	public void setStockExchanges(List<StockExchange> stockExchanges) {
//		this.stockExchanges = stockExchanges;
//	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	
	
	public IPODetail(double pricePerShare, Long totalNumberOfShares, LocalDateTime openDateTime) {
		super();
		this.pricePerShare = pricePerShare;
		this.totalNumberOfShares = totalNumberOfShares;
		this.openDateTime = openDateTime;
	}
	
	public String getStockexchangename() {
		return stockexchangename;
	}

	public void setStockexchangename(String stockexchangename) {
		this.stockexchangename = stockexchangename;
	}

	public StockExchange getStockExchange() {
		return stockexchange;
	}

	public void setStockExchange(StockExchange stockExchange) {
		this.stockexchange = stockExchange;
	}
	
	public String getCompanycode() {
		return companycode;
	}

	public void setCompanycode(String companycode) {
		this.companycode = companycode;
	}

	public StockExchange getStockexchange() {
		return stockexchange;
	}

	public void setStockexchange(StockExchange stockexchange) {
		this.stockexchange = stockexchange;
	}
}
