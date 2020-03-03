package com.example.TradeRec.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequestDto {

  private int id;
  
  private String customerName;
  
  private String address;
  
  private int contact;
}
