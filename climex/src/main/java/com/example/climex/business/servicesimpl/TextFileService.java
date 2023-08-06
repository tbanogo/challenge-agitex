package com.example.climex.business.servicesimpl;

import com.example.climex.business.services.CustomerService;
import com.example.climex.business.services.FileService;
import com.example.climex.dao.repositories.CustomerRepository;
import com.example.climex.utils.dtos.CustomerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TextFileService implements FileService {

    private final CustomerRepository customerRepository;
    private final CustomerService customerService;

    @Override
    public boolean readFile(MultipartFile file) {
        List<CustomerDto> customerDtos = new ArrayList<CustomerDto>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                CustomerDto customerDto = null;
                if (data.length == 5) {
                    String nom = data[0].trim();
                    String prenom = data[1].trim();
                    int age = Integer.parseInt(data[2].trim());
                    String profession = data[3].trim();
                    double salaire = Double.parseDouble(data[4].trim());

                    customerDto = new CustomerDto(nom, prenom, age, profession, salaire);
                    customerDtos.add(customerDto);
                }else {
                    return false;
                }
            }

            customerRepository.saveAll(customerService.convertListDtoToListEntity(customerDtos));

            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}
