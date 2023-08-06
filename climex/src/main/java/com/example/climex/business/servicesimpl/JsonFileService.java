package com.example.climex.business.servicesimpl;

import com.example.climex.business.services.CustomerService;
import com.example.climex.business.services.FileService;
import com.example.climex.dao.repositories.CustomerRepository;
import com.example.climex.utils.dtos.CustomerDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class JsonFileService implements FileService {

    private final CustomerRepository customerRepository;
    private final CustomerService customerService;

    @Override
    public boolean readFile(MultipartFile file) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<CustomerDto> customerDtos = new ArrayList<CustomerDto>();
        customerDtos.clear();

        try{
            InputStream inputStream = file.getInputStream();
            String jsonString = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            List<Map<String, Object>> custs = objectMapper.readValue(jsonString, List.class);

            for (Map<String, Object> e : custs){
                CustomerDto customerDto = new CustomerDto();
                if (
                        e.get("nom").toString() == null ||
                                e.get("prenom").toString() == null ||
                                e.get("age").toString() == null ||
                                e.get("profession").toString() == null ||
                                e.get("salaire").toString() == null
                ){
                    return false;
                }else {
                    customerDto.setNom(e.get("nom").toString());
                    customerDto.setPrenom(e.get("prenom").toString());
                    customerDto.setAge(Integer.parseInt(e.get("age").toString()));
                    customerDto.setProfession(e.get("profession").toString());
                    customerDto.setSalaire(Double.parseDouble(e.get("salaire").toString()));

                    customerDtos.add(customerDto);
                }
            }

            customerRepository.saveAll(customerService.convertListDtoToListEntity(customerDtos));

            return true;
        }catch (IOException i){
            log.info(":::::::::::::::: echec :::::::::::::::");
        }

        return false;
    }
}
