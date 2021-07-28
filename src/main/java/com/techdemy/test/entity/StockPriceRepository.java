package com.techdemy.test.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface StockPriceRepository extends JpaRepository<StockPrice,Long> {
	  List<StockPrice> findByExchangenameAndCompanycode(String exchange, String companycode);
	  
	  @Query(value="SELECT TOP 1 * FROM STOCK_PRICE sp  where sp.company_id= :cid ORDER BY sp.date DESC", nativeQuery=true)
	  StockPrice getLatestForCompany(long cid);
	  
	  @Query(value="SELECT\r\n"
	  		+ "  c.id as cid,\r\n"
	  		+ "  c.name as companyName,\r\n"
	  		+ "  c.ceo as cceo,\r\n"
	  		+ "  sp.companycode as ccode,\r\n"
	  		+ "  sp.date as sdate,\r\n"
	  		+ "  sp.exchangename as exchangename\r\n"
	  		+ "FROM\r\n"
	  		+ "  Company c\r\n"
	  		+ "  inner join company_stockexchangemap map on c.id = map.company_id\r\n"
	  		+ "  inner join stock_price sp on map.company_code = sp.companycode\r\n"
	  		+ "  and map.stockexchange_id = sp.stockexchange_id\r\n"
	  		+ "  and map.company_id = sp.company_id\r\n"
	  		+ "where\r\n"
	  		+ "  c.name = :cname\r\n"
	  		+ "ORDER BY\r\n"
	  		+ "  sp.date DESC\r\n"
	  		+ "LIMIT\r\n"
	  		+ "  1",nativeQuery=true)
	  List<Object[]> getLatestForCompany(String cname);
	  
	  @Query(value="SELECT avg(sp.shareprice) as price, sp.date FROM STOCK_PRICE sp  where sp.company_id= :cid and sp.date>= :sdate and sp.date<= :edate GROUP BY date ORDER BY sp.date ASC", nativeQuery=true)
	  List<Object[]> getAllForCompany(long cid, String sdate, String edate);
	  
	  @Query(value="SELECT avg(sp.shareprice) as price, sp.date FROM STOCK_PRICE sp join company c  where sp.company_id= c.id and  c.sectorname= :sname and sp.date>= :sdate and sp.date<= :edate GROUP BY date ORDER BY sp.date ASC", nativeQuery=true)
	  List<Object[]> getAllForSector(String sname, String sdate, String edate);
	  
	  @Query(value="SELECT avg(sp.shareprice) as price FROM STOCK_PRICE sp  where sp.company_id= :cid and sp.date>= :sdate and sp.date<= :edate GROUP BY sp.company_id", nativeQuery=true)
	  List<Object[]> getAvgCompany(long cid, String sdate, String edate);
	  
	  @Query(value="SELECT avg(sp.shareprice) as price FROM STOCK_PRICE sp join company c where sp.company_id= c.id and c.sectorname= :sname and sp.date>= :sdate and sp.date<= :edate GROUP BY c.sectorname", nativeQuery=true)
	  List<Object[]> getAvgSector(String sname, String sdate, String edate);
	  
	  @Query(value="SELECT c.name as companyName,  sp.companycode as ccode,   sp.date as sdate, sp.shareprice as price, sp.exchangename as exchangename FROM  Company c  inner join company_stockexchangemap map on c.id = map.company_id  inner join stock_price sp on map.company_code = sp.companycode  and map.stockexchange_id = sp.stockexchange_id  and map.company_id = sp.company_id ORDER BY  sp.date DESC",nativeQuery=true)
	  List<Object[]> getAllStocks();
	//  @Query(value="select",nativeQuery=true)
	//  List<Object[]> getStockPricesbyCompany(String cname);
	//  
	//  @Query(value="select",nativeQuery=true)
	//  List<Object[]> getStockPricesbyCompanyCode(String code, String exchange);
	//  
	}
