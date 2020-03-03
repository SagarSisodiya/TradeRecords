package com.example.TradeRec.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import com.example.TradeRec.dto.CustomerRequestDto;
import com.example.TradeRec.dto.CustomerResponseDto;
import com.example.TradeRec.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

  @Autowired
  private CustomerService customerService;
  
  @GetMapping
  public List<CustomerResponseDto> getAllCustomers(){
     return customerService.getAllCustomers();
  }
  
  @GetMapping("/getCustomer")
  public CustomerResponseDto getCustomerById(@RequestParam("id") int id) {
    return customerService.getCustomerById(id);
  }
  
  @PostMapping("/addCustomer")
  public void addCustomer(CustomerRequestDto customerRequestDto) {
    
    customerService.addCustomer(customerRequestDto);
  }
  
  @PostMapping("/addUpdatedCustomer")
  public void addUpdatedCustomer(CustomerRequestDto customerRequestDto) {
    
    customerService.addCustomer(customerRequestDto);
  }
  
  @DeleteMapping("/{id}")
  public void removeCustomer(@RequestParam int id ) {
    customerService.removeCustomer(id);
  }
  
  @GetMapping("/updateCustomer")
  public RedirectView updateCustomer(@RequestParam("id") int id,RedirectAttributes ra) {
    CustomerResponseDto customerResponseDto = customerService.getCustomerById(id);
    ra.addFlashAttribute("customerResponseDto", customerResponseDto);
    return new RedirectView("/view/customerUpdate");
  }
}
