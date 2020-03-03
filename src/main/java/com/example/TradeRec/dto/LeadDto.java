package com.example.TradeRec.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeadDto {
	
	private String leadName;
	private String customerId;
	private String partnerId;
	private String firstName;
	private String lastName;
}
