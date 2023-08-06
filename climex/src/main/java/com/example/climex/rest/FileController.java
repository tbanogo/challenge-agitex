package com.example.climex.rest;

import com.example.climex.business.servicesimpl.CsvFileService;
import com.example.climex.business.servicesimpl.JsonFileService;
import com.example.climex.business.servicesimpl.TextFileService;
import com.example.climex.business.servicesimpl.XmlFileService;
import com.example.climex.utils.beans.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file/upload")
@RequiredArgsConstructor
@Slf4j
public class FileController {

    private final TextFileService textFileService;
    private final CsvFileService csvFileService;
    private final JsonFileService jsonFileService;
    private final XmlFileService xmlFileService;

    @PostMapping("/text")
    public ResponseEntity<ApiResponse> getTextFileData(@RequestParam(name = "file") MultipartFile file) {
        log.info("/////////////:::::::::::::::: text ::::::::::::://////////");
        ApiResponse response = new ApiResponse();
        try{
            response.setSuccess(true);
            response.setMessage("Success");
            response.setData(textFileService.readFile(file));
        }catch (Exception e){
            response.setSuccess(false);
            response.setMessage(e.getMessage());
            response.setData(null);
        }

        return ResponseEntity.ok(response);
    }

    @PostMapping("/csv")
    public ResponseEntity<ApiResponse> getCsvFileData(@RequestParam(name = "file") MultipartFile file) {
        log.info("/////////////:::::::::::::::: csv ::::::::::::://////////");
        ApiResponse response = new ApiResponse();
        try{
            response.setSuccess(true);
            response.setMessage("Success");
            response.setData(csvFileService.readFile(file));
        }catch (Exception e){
            response.setSuccess(false);
            response.setMessage(e.getMessage());
            response.setData(null);
        }

        return ResponseEntity.ok(response);
    }

    @PostMapping("/xml")
    public ResponseEntity<ApiResponse> getXmlFileData(@RequestParam(name = "file") MultipartFile file) {
        log.info("/////////////:::::::::::::::: xml ::::::::::::://////////");
        ApiResponse response = new ApiResponse();
        try{
            response.setSuccess(true);
            response.setMessage("Success");
            response.setData(xmlFileService.readFile(file));
        }catch (Exception e){
            response.setSuccess(false);
            response.setMessage(e.getMessage());
            response.setData(null);
        }

        return ResponseEntity.ok(response);
    }

    @PostMapping("/json")
    public ResponseEntity<ApiResponse> getJsonFileData(@RequestParam(name = "file") MultipartFile file) {
        log.info("/////////////:::::::::::::::: json ::::::::::::://////////");
        ApiResponse response = new ApiResponse();
        try{
            response.setSuccess(true);
            response.setMessage("Success");
            response.setData(jsonFileService.readFile(file));
        }catch (Exception e){
            response.setSuccess(false);
            response.setMessage(e.getMessage());
            response.setData(null);
        }

        return ResponseEntity.ok(response);
    }


}
