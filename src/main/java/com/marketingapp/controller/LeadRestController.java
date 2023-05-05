package com.marketingapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketingapp.dto.LeadDto;
import com.marketingapp.entities.Lead;
import com.marketingapp.repository.LeadRepository;

@RestController
@RequestMapping("/api/leads")
public class LeadRestController {
	
	@Autowired
	private LeadRepository leadRepository;
		
	
	//localhost:8080/api/leads
	
	@GetMapping
	public List<Lead> getAllLead(){
		List<Lead> leads= leadRepository.findAll();
		return leads;
		
	}
 
	//localhost:8080/api/leads
	@PostMapping 
	public void saveLead(@RequestBody Lead lead) {
		leadRepository.save(lead);
		
   }
	
	//localhost:8080/api/leads/{id}"
     	@DeleteMapping("/{id}")
     	public void deleteOneLeadById(@PathVariable ("id") long id) {
		leadRepository.deleteById(id);
	}
	 
     	//localhost:8080/api/leads
     	@PutMapping
     	public void updateOneLead(@RequestBody LeadDto leadDto) {
     		Lead l =new Lead();
     		l.setId(leadDto.getId());
     		l.setFirstName(leadDto.getFirstName());
     		l.setLastName(leadDto.getLastName());
     		l.setEmail(leadDto.getEmail());
     		l.setMobile(leadDto.getMobile());
     		
     		leadRepository.save(l);
     				
     	}
     	//http://localhost:8080/api/leads/{id}
     	@GetMapping("/{id}")
     	public Lead getLeadById (@PathVariable("id") long id ) {
     		Optional<Lead> findById = leadRepository.findById(id);
     		return findById.get();
     		
     		
     		
     	}
     	
}
