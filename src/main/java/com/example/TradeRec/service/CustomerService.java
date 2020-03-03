package com.example.TradeRec.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.TradeRec.dto.CustomerRequestDto;
import com.example.TradeRec.dto.CustomerResponseDto;
import com.example.TradeRec.entity.Customer;
import com.example.TradeRec.repository.CustomerRepository;

@Service
public class CustomerService {

  @Autowired
  private CustomerRepository customerRespository;

  public List<CustomerResponseDto> getAllCustomers() {
    List<Customer> customerList = customerRespository.findAll();
    List<CustomerResponseDto> customerResponseDtos = new ArrayList<CustomerResponseDto>();
    customerList.forEach(t->{
     CustomerResponseDto customerResposneDto = new CustomerResponseDto();
     customerResposneDto.setId(t.getId());
     customerResposneDto.setAddress(t.getCustomerAddress());
     customerResposneDto.setContact(t.getContact());
     customerResposneDto.setCustomerName(t.getCustomerName());
     customerResponseDtos.add(customerResposneDto);
    });
    
    return customerResponseDtos;
  }

  public void addCustomer(CustomerRequestDto customerRequestDto) {
    Customer customer = new Customer();
    customer.setId(customerRequestDto.getId());
    customer.setCustomerName(customerRequestDto.getCustomerName());
    customer.setContact(customerRequestDto.getContact());
    customer.setCustomerAddress(customerRequestDto.getAddress());
    customerRespository.save(customer);
    
  }

  public void removeCustomer(int id) {
    customerRespository.deleteById(id);
  }

  public CustomerResponseDto getCustomerById(int id) {
    Customer customer = customerRespository.getOne(id);
    CustomerResponseDto customerResponseDto = new CustomerResponseDto();
    customerResponseDto.setId(customer.getId());
    customerResponseDto.setAddress(customer.getCustomerAddress());
    customerResponseDto.setContact(customer.getContact());
    customerResponseDto.setCustomerName(customer.getCustomerName());
    return customerResponseDto;
  }
}
