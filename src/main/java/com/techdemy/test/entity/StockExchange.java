package com.techdemy.test.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "StockExchange")
public class StockExchange {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable = false)
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "stockexchange", cascade = CascadeType.ALL, targetEntity = CompanyStockExchangeMap.class)
	private List<CompanyStockExchangeMap> compstockmap;

	@Column(nullable = false)
	private String brief;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false)
	private String remarks;
	
	public List<CompanyStockExchangeMap> getCompstockmap() {
		return compstockmap;
	}

	public void setCompstockmap(List<CompanyStockExchangeMap> compstockmap) {
		this.compstockmap = compstockmap;
	}
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public void setId(long id) {
		this.id = id;
	}
}
