package com.techdemy.test.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Sector")
public class Sector {
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable = false)
	@Type(type = "text")
	private String sectorName;
	
	@OneToMany(mappedBy = "sector",fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Company.class)
	@JsonIgnore
	private List<Company> companies= new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSectorName() {
		return sectorName;
	}

	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}
}
