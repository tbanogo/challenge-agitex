package com.example.climex.business.services;

import com.example.climex.dao.entites.Customer;
import com.example.climex.utils.dtos.CustomerDto;
import org.springframework.stereotype.Component;

import java.util.List;

public interface CustomerService {

    List<CustomerDto> getAllCustomers();
    double getAverageSalaryByProfession(String profession);
    CustomerDto convertEntityToDto(Customer customer);
    Customer convertDtoToEntity(CustomerDto customerDto);
    List<Customer> convertListDtoToListEntity(List<CustomerDto> customerDtoList);

}
