package com.example.climex.rest;

import com.example.climex.business.services.CustomerService;
import com.example.climex.dao.entites.Customer;
import com.example.climex.utils.beans.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController{

    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<ApiResponse> getAllCustomers() {
        ApiResponse response = new ApiResponse();
        try{
            response.setSuccess(true);
            response.setMessage("Success");
            response.setData(customerService.getAllCustomers());
        }catch (Exception e){
            response.setSuccess(false);
            response.setMessage(e.getMessage());
            response.setData(null);
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/average-salary")
    public ResponseEntity<ApiResponse> getAverageSalaryByProfession(String profession) {
        ApiResponse response = new ApiResponse();
        try{
            response.setSuccess(true);
            response.setMessage("Success");
            response.setData(
                    customerService.getAverageSalaryByProfession(profession)
            );
        }catch (Exception e){
            response.setSuccess(false);
            response.setMessage(e.getMessage());
            response.setData(null);
        }

        return ResponseEntity.ok(response);
    }
}
