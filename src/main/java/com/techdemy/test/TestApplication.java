package com.techdemy.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.techdemy.test.entity.*;

@SpringBootApplication
public class TestApplication implements CommandLineRunner{
	
	@Autowired
	private SectorRepository secrep;
	
	@Autowired
	private CompanyRepository cmprep;
	
	@Autowired
	StockExchangeRepository stkrep;
	
	@Autowired
	User1Repository user1rep;
	
	@Autowired
	CompanyStockExchangeMapRepository stkcmpmaprep;
	
	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Sector s1 = new Sector();
		s1.setSectorName("insurance");
		secrep.save(s1);
		
		Sector s2 = new Sector();
		s2.setSectorName("banking");
		secrep.save(s2);
		
		Sector s3 = new Sector();
		s3.setSectorName("automobile");
		secrep.save(s3);
		
		Sector s4 = new Sector();
		s4.setSectorName("textile");
		secrep.save(s4);
		
		Sector s5 = new Sector();
		s5.setSectorName("aviation");
		secrep.save(s5);
		
		Sector s6 = new Sector();
		s6.setSectorName("petrochemical");
		secrep.save(s6);
		
		Sector s7 = new Sector();
		s7.setSectorName("IT");
		secrep.save(s7);
		
		Company c1 = new Company();
		c1.setBoardOfDirectors("Elon, Friends");
		c1.setCeo("Elon Musk");
		c1.setCompanyBrief("Electric Automobile");
		c1.setName("Tesla");
		c1.setSectorname("automobile");
		c1.setSector(s3);
		c1.setTurnover(64000000000D);
		cmprep.save(c1);
		
		Company c2 = new Company();
		c2.setBoardOfDirectors("Tulsi Naidu");
		c2.setCeo("Thierry Delaporte");
		c2.setCompanyBrief("IT Service");
		c2.setName("Wipro");
		c2.setSectorname("it");
		c2.setSector(s7);
		c2.setTurnover(64000000000D);
		cmprep.save(c2);
		
		Company c3 = new Company();
		c3.setBoardOfDirectors("Nita, Anil");
		c3.setCeo("Mukesh Ambani");
		c3.setCompanyBrief("Petroleum");
		c3.setName("Reliance");
		c3.setSectorname("automobile");
		c3.setSector(s6);
		c3.setTurnover(64000000000D);
		cmprep.save(c3);
		
		StockExchange x1 = new StockExchange();
		x1.setName("BSE");
		x1.setBrief("Bombay Stock Exchange");
		x1.setAddress("Dalal Street");
		x1.setRemarks("Asia's oldest stock exchange");
		stkrep.save(x1);
		
		StockExchange x2 = new StockExchange();
		x2.setName("NSE");
		x2.setBrief("National Stock Exchange");
		x2.setAddress("BKC");
		x2.setRemarks("Leading stock exchange of India");
		stkrep.save(x2);
		
		CompanyStockExchangeMap cse1 = new CompanyStockExchangeMap();
		cse1.setCompany(c1);
		cse1.setStockexchange(x2);
		cse1.setCompanyCode("TESLANSE");
		stkcmpmaprep.save(cse1);
		
		CompanyStockExchangeMap cse2 = new CompanyStockExchangeMap();
		cse2.setCompany(c2);
		cse2.setStockexchange(x1);
		cse2.setCompanyCode("WIPRO");
		stkcmpmaprep.save(cse2);
		
		CompanyStockExchangeMap cse3 = new CompanyStockExchangeMap();
		cse3.setCompany(c3);
		cse3.setStockexchange(x1);
		cse3.setCompanyCode("RELBSE");
		stkcmpmaprep.save(cse3);
		
		CompanyStockExchangeMap cse4 = new CompanyStockExchangeMap();
		cse4.setCompany(c3);
		cse4.setStockexchange(x2);
		cse4.setCompanyCode("RELNSE");
		stkcmpmaprep.save(cse4);
		
		User1 u1 = new User1();
		u1.setConfirmed(true);
		u1.setEmail("user@gmail.com");
		u1.setUsername("user");
		u1.setPassword("$2a$10$wDFeSo8UuOAOYAjKQ4szleg3V6oIud77NdnyDBmfHy08EwJjPY5g6");
		u1.setRole("user");
		user1rep.save(u1);
		
		User1 u2 = new User1();
		u2.setConfirmed(true);
		u2.setEmail("admin@gmail.com");
		u2.setUsername("admin");
		u2.setPassword("$2a$10$6xU0VX1XVictuASj3opsjuAmKvVVjswvWZB161Bgum9RPGUf9BqOW");
		u2.setRole("admin");
		user1rep.save(u2);
	}

}
