package com.techdemy.test.entity;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin
@RestController
public class CompanyController {
	@Autowired
	CompanyRepository cmprep;
	
	@RequestMapping(value = "/addcompany", method = RequestMethod.POST)
	public ResponseEntity<Object> createcompany(@RequestBody Company cmp){
		cmprep.save(cmp);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cmp.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@RequestMapping(value = "/getCompanies", method = RequestMethod.GET)
	public List<Company> getCompanies() {
		return cmprep.findAll();
	}
	
}
