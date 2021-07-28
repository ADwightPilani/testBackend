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
		
		Company c1 = new Company();
		c1.setBoardOfDirectors("Elon, Friends");
		c1.setCeo("Elon");
		c1.setCompanyBrief("Electric Automobile");
		c1.setName("Tesla");
		c1.setSectorname("automobile");
		c1.setSector(s3);
		c1.setTurnover(64000000000D);
		cmprep.save(c1);
		
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
		
		CompanyStockExchangeMap cse = new CompanyStockExchangeMap();
		cse.setCompany(c1);
		cse.setStockexchange(x2);
		cse.setCompanyCode("TESLANSE");
		stkcmpmaprep.save(cse);
	}

}
