package com.example.computer.controller;

import com.example.computer.payload.ApiResponse;
import com.example.computer.payload.CompanyDto;
import com.example.computer.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @PostMapping
    private ApiResponse addCompany(@RequestBody CompanyDto companyDto){
        return companyService.addCompany(companyDto);
    }

    @PutMapping("/{id}")
    private ApiResponse editCompany(@PathVariable Integer id,@RequestBody CompanyDto companyDto){
        return companyService.editCompany(id,companyDto);
    }

    @GetMapping("/{id}")
    private CompanyDto getCompany(@PathVariable Integer id){
        return companyService.getCompany(id);
    }

    @GetMapping
    private List<CompanyDto>getCompanies(){
        return companyService.getCompanies();
    }

    @DeleteMapping("/{id}")
    private ApiResponse deleteCompany(@PathVariable Integer id){
        return companyService.deleteCompany(id);
    }
}
