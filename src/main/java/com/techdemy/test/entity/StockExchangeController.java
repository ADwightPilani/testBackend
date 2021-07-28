package com.techdemy.test.entity;

import java.io.IOException;
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
public class StockExchangeController {
	@Autowired
	StockExchangeRepository stkrep;
	
	@RequestMapping(value = "/createexchange", method = RequestMethod.POST)
	public  ResponseEntity<Object> addstockexchange(@RequestBody StockExchange stockexchange) throws ClassNotFoundException, IOException {
		StockExchange se= stkrep.save(stockexchange);

	    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(se.getId())
	            .toUri();
	    
	    return ResponseEntity.created(location).build();
	}
	
	@RequestMapping(value="/getAllExchanges", method = RequestMethod.GET)
	public List<Object[]> getAllExchanges(){
		return stkrep.findAllExchanges();
	};
}
