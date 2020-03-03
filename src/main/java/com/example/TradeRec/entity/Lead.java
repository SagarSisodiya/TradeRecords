package com.example.TradeRec.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Lead {
	
	@Id
	private String customerId;
	
	private String partnerId;
		
	private String firstName;
		
	private String lastName;
		
	private String leadName;
}
