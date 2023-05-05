package com.marketingapp.service;


import java.util.List;

import com.marketingapp.entities.Lead;


public interface LeadService {
	public void saveReg(Lead lead);

	public List <Lead> findAllLeads();

	public void deleteLeadById(long id);

	public Lead findLeadById(long id);
	

}
