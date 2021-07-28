package com.techdemy.test.entity;
import java.net.URI;
import java.util.List;
import java.util.Map;
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
public class SectorController {
	@Autowired
	CompanyRepository cmprep;
	@Autowired
	SectorRepository secrep;
	EntityManager em;

	@RequestMapping(value = "/addsector", method = RequestMethod.POST)
	public ResponseEntity<Object> createsector(@RequestBody Sector s) {
		
		secrep.save(s);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(s.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@RequestMapping(value = "/deletesector", method = RequestMethod.POST)
	public ResponseEntity<Object> deletesector(@RequestBody Map<String, String> text) {
		secrep.deleteById(Long.parseLong(text.get("id")));
		return ResponseEntity.accepted().build();
	}
	
	
	@RequestMapping(value="/getAllSectors", method = RequestMethod.GET)
	public List<Object[]> getAllCompanies(){
		return secrep.getAllSectors();
	};

}
