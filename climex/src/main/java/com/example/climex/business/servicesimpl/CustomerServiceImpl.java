package com.example.climex.business.servicesimpl;

import com.example.climex.business.services.CustomerService;
import com.example.climex.dao.entites.Customer;
import com.example.climex.dao.repositories.CustomerRepository;
import com.example.climex.utils.dtos.CustomerDto;
import org.modelmapper.ModelMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public double getAverageSalaryByProfession(String profession) {
        List<CustomerDto> customers = getAllCustomers();
        long count = 0;
        double totalSalary = 0;

        for (CustomerDto customerDto : customers) {
            if (customerDto.getProfession().equalsIgnoreCase(profession)) {
                totalSalary += customerDto.getSalaire();
                count++;
            }
        }

        return count > 0 ? totalSalary / count : 0;
    }

    @Override
    public CustomerDto convertEntityToDto(Customer customer) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(customer, CustomerDto.class);
    }

    @Override
    public Customer convertDtoToEntity(CustomerDto customerDto) {
        return modelMapper.map(customerDto, Customer.class);
    }

    @Override
    public List<Customer> convertListDtoToListEntity(List<CustomerDto> customerDtoList) {
        List<Customer> customers = new ArrayList<Customer>();
        customerDtoList.forEach((e) -> {
            customers.add(convertDtoToEntity(e));
        });

        return customers;
    }


}
