package com.techdemy.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "Company")
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String name;


	@Column(nullable = false)
	private Double turnover;

	@Column(nullable = false)
	private String ceo;
	
	@Column(nullable = false)
	private String sectorname;


	@Column(nullable = false)
	@Type(type = "text")
	private String boardOfDirectors;


	@Column(nullable = false)
	@Type(type = "text")
	private String companyBrief;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Double getTurnover() {
		return turnover;
	}


	public void setTurnover(Double turnover) {
		this.turnover = turnover;
	}


	public String getCeo() {
		return ceo;
	}


	public void setCeo(String ceo) {
		this.ceo = ceo;
	}


	public String getSectorname() {
		return sectorname;
	}


	public void setSectorname(String sectorname) {
		this.sectorname = sectorname;
	}


	public String getBoardOfDirectors() {
		return boardOfDirectors;
	}


	public void setBoardOfDirectors(String boardOfDirectors) {
		this.boardOfDirectors = boardOfDirectors;
	}


	public String getCompanyBrief() {
		return companyBrief;
	}


	public void setCompanyBrief(String companyBrief) {
		this.companyBrief = companyBrief;
	}
	
	
}
