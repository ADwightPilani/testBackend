package com.techdemy.test.entity;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Map;

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
public class StockPriceController {
	@Autowired
	StockPriceRepository stkpricerepo;
	@Autowired
	StockExchangeRepository stkrep;
	@Autowired
	CompanyStockExchangeMapRepository stkcmpmaprep;
	@Autowired
	CompanyRepository cmprep;

//	@RequestMapping(value = "/addstockprices", method = RequestMethod.POST)
//	public ResponseEntity<Object> stockpriceapi(@RequestBody StockPrice stockprice)
//			throws ClassNotFoundException, IOException {
//		StockExchange ex = stkrep.findByName(stockprice.getExchangename());
//		if(ex==null) {
//			return ResponseEntity.badRequest().build();
//		}
//		stockprice.setStockexchange(ex);
//		List<CompanyStockExchangeMap> exmap = stkcmpmaprep.findByStockexchangeAndCompanyCode(ex,
//				stockprice.getCompanycode());
//		System.out.println("code "+stockprice.getCompanycode()+" exchange "+stockprice.getExchangename()+" price: "+stockprice.getShareprice());
//		if (exmap.isEmpty()) {
//			System.out.print("problemo in stockpriceapi");
//			return ResponseEntity.badRequest().build();
//		}
//		CompanyStockExchangeMap csmap = exmap.get(0);
//		Company c = csmap.getCompany();
//		stockprice.setCompany(c);
//		stockprice.setCompstockmap(csmap);
//		StockPrice stkprice = stkpricerepo.save(stockprice);
//		List<StockPrice> prices = csmap.getStockprices();
//		prices.add(stkprice);
//		csmap.setStockprices(prices);
//		stkcmpmaprep.save(csmap);
//		// make sure your entity class properties of price are in lower case and match
//		// the json,to avoid errors
//		System.out.println("added stockprice for companycode: "+stkprice.getCompanycode()+" for exchange "+stkprice.getExchangename());
//
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(stkprice.getId())
//				.toUri();
//
//		return ResponseEntity.created(location).build();
//	}

	@RequestMapping(value = "/getstockprices", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<StockPrice> getstockprice() throws ClassNotFoundException, IOException {
		List<StockPrice> stkprice = stkpricerepo.findAll();
		// make sure your entity class properties of user are in lower case and match
		// the json,to avoid errors
		return stkprice;
	}
	
	@RequestMapping(value = "/getspfcb", method = RequestMethod.POST, headers = "Accept=application/json")
	public List<Object[]> getstockpricesforcompanybetween(@RequestBody Map<String, String> text) throws ClassNotFoundException, IOException {
		Company C = cmprep.findByName(text.get("companyName")); 
		List<Object[]> stkprices = stkpricerepo.getAllForCompany(C.getId(), text.get("sdate"), text.get("edate"));
		// make sure your entity class properties of user are in lower case and match
		// the json,to avoid errors
		return stkprices;
	}
	
	@RequestMapping(value = "/getavg", method = RequestMethod.POST, headers = "Accept=application/json")
	public List<Object[]> getavg(@RequestBody Map<String, String> text) throws ClassNotFoundException, IOException {
		Company C = cmprep.findByName(text.get("companyName")); 
		List<Object[]> stkprices = stkpricerepo.getAvgCompany(C.getId(), text.get("sdate"), text.get("edate"));
		// make sure your entity class properties of user are in lower case and match
		// the json,to avoid errors
		return stkprices;
	}
	
	@RequestMapping(value = "/getspfsb", method = RequestMethod.POST, headers = "Accept=application/json")
	public List<Object[]> getstockpricesforsectorbetween(@RequestBody Map<String, String> text) throws ClassNotFoundException, IOException {
//		Company C = cmprep.findByName(text.get("companyName")); 
		return stkpricerepo.getAllForSector(text.get("sectorname"), text.get("sdate"), text.get("edate"));
		// make sure your entity class properties of user are in lower case and match
		// the json,to avoid errors
//		return stkprices;
	}
	
	@RequestMapping(value = "/getavgsec", method = RequestMethod.POST, headers = "Accept=application/json")
	public List<Object[]> getavgsec(@RequestBody Map<String, String> text) throws ClassNotFoundException, IOException {
//		Company C = cmprep.findByName(text.get("companyName")); 
		return stkpricerepo.getAvgSector(text.get("sectorname"), text.get("sdate"), text.get("edate"));
		// make sure your entity class properties of user are in lower case and match
		// the json,to avoid errors
//		return stkprices;
	}
	
	@RequestMapping(value = "/getallstocks", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Object[]> getavgsec() throws ClassNotFoundException, IOException {
//		Company C = cmprep.findByName(text.get("companyName")); 
		return stkpricerepo.getAllStocks();
		// make sure your entity class properties of user are in lower case and match
		// the json,to avoid errors
//		return stkprices;
	}
	
}
