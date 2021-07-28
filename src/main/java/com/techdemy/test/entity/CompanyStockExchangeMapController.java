package com.techdemy.test.entity;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public class CompanyStockExchangeMapController {
	@Autowired
	CompanyRepository cmprep;
	@Autowired
	SectorRepository secrep;
	@Autowired
	StockExchangeRepository stkrep;
	@Autowired
	CompanyStockExchangeMapRepository stkcmpmaprep;
	EntityManager em;
	
	@RequestMapping(value="/getAllMaps", method = RequestMethod.GET)
	public List<Object[]> getAllMaps(){
		List<Object[]> results=stkcmpmaprep.findAllMaps();
//		for(int i=0; i<results.size(); i++) {
//			System.out.println(results.get(i));
//		}
		return results;
	};
	
	@RequestMapping(value = "/mapcompanycode", method = RequestMethod.POST)
	public String mapcode(@RequestBody Map<String, String> text) {
		System.out.println("params100" + text.get("companyname"));
		Query query = em.createNamedQuery("Company.findByname");
		query.setParameter("name", text.get("companyname"));
		Company c = (Company) query.getSingleResult();

		StockExchange e = stkrep.findByName(text.get("exchangename"));
		CompanyStockExchangeMap cse = new CompanyStockExchangeMap();
		cse.setCompany(c);
		cse.setStockexchange(e);
		cse.setCompanyCode(text.get("companycode"));
		stkcmpmaprep.save(cse);
		List<CompanyStockExchangeMap> temp = c.getCompstockmap();
		if(!temp.contains(cse)) {
			System.out.println("Adding now as not present before");
			temp.add(cse);
			c.setCompstockmap(temp);
			cmprep.save(c);
		}
		temp = e.getCompstockmap();
		if(!temp.contains(cse)) {
			System.out.println("Adding now as not present before");
			temp.add(cse);
			e.setCompstockmap(temp);
			stkrep.save(e);
		}
		return c.getName();
		// return companyname;
	}
}
