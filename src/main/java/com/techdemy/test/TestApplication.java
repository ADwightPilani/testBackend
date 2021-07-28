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
	
	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Company c1 = new Company();
		c1.setBoardOfDirectors("Elon, Friends");
		c1.setCeo("Elon");
		c1.setCompanyBrief("Electric Automobile");
		c1.setName("Tesla");
		c1.setSectorname("automobile");
		c1.setTurnover(64000000000D);
		cmprep.save(c1);
		
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
	}

}
