package com.techdemy.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.techdemy.test.entity.*;

@SpringBootApplication
public class TestApplication implements CommandLineRunner{
	
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
	}

}
