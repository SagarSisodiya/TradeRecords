package com.example.TradeRec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TradeRec.entity.Lead;
import com.example.TradeRec.entity.Product;
import com.example.TradeRec.repository.LeadRepository;

@Service
public class LeadService {

	@Autowired
	private LeadRepository leadRepository;
	
	public void saveLead(Lead lead) {
		leadRepository.save(lead);
	}

	public List<Lead> getLeads() {
		return leadRepository.findAll();
	}
}
