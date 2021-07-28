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

@RestController
@CrossOrigin
public class IPOController {
	@Autowired
	IPORepository iporepo;

	@Autowired
	CompanyRepository cmprep;

	@Autowired
	StockExchangeRepository stkrep;

	@RequestMapping(value = "/addipo", method = RequestMethod.POST)
	public ResponseEntity<Object> ipoapi(@RequestBody IPODetail ipo) throws ClassNotFoundException, IOException {
		Company c = cmprep.findByName(ipo.getCompanyname());
		if (c == null) {
			// something
			System.out.println("company of name doesnt exist: " + ipo.getCompanyname());
			return ResponseEntity.badRequest().build();
		} else {
			ipo.setCompany(c);
		}

		StockExchange se = stkrep.findByName(ipo.getStockexchangename());
		if (se == null) {
			System.out.println("stockexchange of name doesnt exist: " + ipo.getStockexchangename());
			// something
			return ResponseEntity.badRequest().build();
		} else {
			ipo.setStockExchange(se);
		}
		IPODetail ipo1 = iporepo.save(ipo);
		// make sure your entity class properties of price are in lower case and match
		// the json,to avoid errors
		System.out.println(ipo1 + "check this ipo: " + ipo1.getCompanyname());

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ipo1.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@RequestMapping(value = "/editIpo", method = RequestMethod.POST)
	public ResponseEntity<Object> editIpo(@RequestBody IPODetail ipo) {
		IPODetail ipo1 = iporepo.findByCompanyname(ipo.getCompanyname());
		if (ipo1 == null) {
			return ResponseEntity.badRequest().build();
		}

		ipo1.setTotalNumberOfShares(ipo.getTotalNumberOfShares());
		ipo1.setRemarks(ipo.getRemarks());
		ipo1.setPricePerShare(ipo.getPricePerShare());

		iporepo.save(ipo1);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ipo.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@RequestMapping(value = "/getAllIPO", method = RequestMethod.GET)
	public List<Object[]> getAllIPO() {
		return iporepo.findAllIPO();
	};
}