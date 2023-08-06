package com.example.climex.business.services;

import com.example.climex.utils.dtos.CustomerDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {

    boolean readFile(MultipartFile file);

}
