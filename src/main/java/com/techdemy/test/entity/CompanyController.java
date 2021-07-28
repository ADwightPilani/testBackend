package com.techdemy.test.entity;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;

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
	@Autowired
	SectorRepository secrep;
	@Autowired
	StockExchangeRepository stkrep;
	@Autowired
	CompanyStockExchangeMapRepository stkcmpmaprep;
	@Autowired
	StockPriceRepository sprep;
	@Autowired
	User1Repository user1rep;
	@Autowired
	EntityManager em;
	
	@RequestMapping(value = "/company", method = RequestMethod.POST)
	public ResponseEntity<Object> createcompany(@RequestBody Company cmp) {
		System.out.println(cmp.toString());
		
		Sector s = secrep.findBySectorName(cmp.getSectorname());
		if(s==null) {//if no such sectorname exists
			System.out.println("invalid sector");
		}
		else {//if sectorname matches
			cmp.setSector(s);
			cmprep.save(cmp);
			System.out.println("1");
//			cmp.setSectorname("banking");
//			cmprep.save(cmp);
			List<Company> companies= s.getCompanies();
			companies.add(cmp);
			s.setCompanies(companies);
			secrep.save(s);
			//System.out.println(s.toString());
		}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cmp.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@RequestMapping(value = "/editCompany", method = RequestMethod.POST)
	public ResponseEntity<Object> editCompany(@RequestBody Map<String, String> text) {
		Company cmp = cmprep.findByName(text.get("companyname"));
		if(cmp==null) {
			return ResponseEntity.badRequest().build();
		}
		cmp.setTurnover(Double.parseDouble(text.get("turnover")));
		cmp.setCeo(text.get("ceo"));
		cmp.setBoardOfDirectors(text.get("boardOfDirectors"));
		cmp.setCompanyBrief(text.get("brief"));
		cmprep.save(cmp);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cmp.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@RequestMapping(value="/getAllCompanies", method = RequestMethod.GET)
	public List<Object[]> getAllCompanies(){
		return cmprep.findAllCompanies();
	};
	
	
	
	@RequestMapping(value="/getWhatUWant", method = RequestMethod.GET)
	public List<Object[]> getWhatUWant(){
		List<Object[]> results=cmprep.findjoined();
//		System.out.println("Ah shit! Here we go again!");
//		for(int i=0; i<results.size(); i++) {
//			System.out.println(results.get(i));
//		}
		return results;
	};
	
	@RequestMapping(value = "/deleteCompany", method = RequestMethod.POST)
	public ResponseEntity<Object> deleteCompany(@RequestBody Map<String, String> text) {
		cmprep.deleteById(Long.parseLong(text.get("id")));
		return ResponseEntity.accepted().build();
	}
	
	
	@RequestMapping(value="/getCompanyDetails", method = RequestMethod.POST)
	public List<Object[]> getCompanyDetails(@RequestBody Map<String, String> text){
		String givenName = text.get("name");
		System.out.println("Given: "+givenName);
		return sprep.getLatestForCompany(givenName);
//		if (cmp==null) {
//			System.out.println("no company found");
//			return objects;
//		}
//		else System.out.println("company id: "+cmp.getId());
//		
//		StockPrice latest = sprep.getLatestForCompany(cmp.getId());
//		if(latest==null) {
//			System.out.println("No stocks kekw");
//			return objects;
//		}
//		else System.out.println("code: "+latest.getCompanycode()+" listed in "+latest.getExchangename());
//		objects.put("company", cmp);
//		objects.put("stock",latest);
//		return objects;
//		List<Object[]> found = cmprep.findByNameCustom(givenName);
//		if(found.size()==0) {
//			System.out.println("somehow 0 results");
//		}
//		for(int i=0; i<found.size();i++)
//		System.out.println("found "+found.get(i));
//		for(int i=0; i<found.size();i++)
//		System.out.println("found "+found.get(i));
//		StockPrice latest = sprep.getLatestForCompany(found.getId());
//		System.out.println("latest "+latest.toString());
//		Object[] objects = new Object[] {found,latest};
//		return objects;
		//return ResponseEntity.accepted().build();
	};
	
	@RequestMapping(value="/getCompanyDetails1", method = RequestMethod.POST)
	public ResponseEntity<Object> getCompanyDetails1(@RequestBody Map<String, String> text){
		String givenName = text.get("name");
		System.out.println("given "+givenName);
		List<Object[]> found = cmprep.findByNameCustom(givenName);
		if(found.size()==0) {
			System.out.println("somehow 0 results");
		}
		for(int i=0; i<found.size();i++)
		System.out.println("found "+found.get(i).toString());
//		StockPrice latest = sprep.getLatestForCompany(found.getId());
//		System.out.println("latest "+latest.toString());
//		Object[] objects = new Object[] {found,latest};
//		return objects;
		return ResponseEntity.accepted().build();
	};
	
       // show all  records from companystockexchangemap entity
	@RequestMapping(value = "/listall", method = RequestMethod.GET)	
	public String listit() {
		
		String x = "";
		List<CompanyStockExchangeMap> csem = stkcmpmaprep.findAll();
		for (CompanyStockExchangeMap c:csem)  {
		Optional<StockExchange> s =	stkrep.findById(c.getStockexchange().getId()); 
		Optional<Company> cc =cmprep.findById(c.getCompany().getId());
			x= x + "   "+cc.get().getName() + "   "+s.get().getName(); //getcompany code can be added here
		}
		System.out.println("Ah shit"+x);
		return x;
		// return companyname;
	}
	
}
