package com.example.computer.service;

import ch.qos.logback.core.hook.DelayingShutdownHook;
import com.example.computer.entity.Color;
import com.example.computer.entity.Company;
import com.example.computer.payload.ApiResponse;
import com.example.computer.payload.ColorDto;
import com.example.computer.payload.CompanyDto;
import com.example.computer.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    final
    CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    public ApiResponse addCompany(CompanyDto companyDto){
        Company company = new Company();
        company.setName(companyDto.getName());
        company.setLocation(companyDto.getLocation());
        try {
            companyRepository.save(company);
            return new ApiResponse("Company added",true);
        }catch (Exception e){
            return new ApiResponse("Company is not added,Please check",false);
        }
    }

    public ApiResponse editCompany(Integer id,CompanyDto companyDto){
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if (optionalCompany.isPresent()){
            Company company = optionalCompany.get();
            company.setName(companyDto.getName());
            company.setLocation(companyDto.getLocation());
            companyRepository.save(company);
            return new ApiResponse("Company edited",true);

        }
        else {
            return new ApiResponse("Company is not found,Please check",false);
        }
    }

    public CompanyDto getCompany(Integer id){
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if (optionalCompany.isPresent()){
            Company company = optionalCompany.get();
            return new CompanyDto(
                    company.getId(),
                    company.getName(),
                    company.getLocation()
            );
        }
        return new CompanyDto();
    }

    public List<CompanyDto> getCompanies(){
        List<Company> companyList = companyRepository.findAll();
        List<CompanyDto>companyDtoList=new ArrayList<>();
        for (Company company : companyList) {
            CompanyDto companyDto=new CompanyDto(
                    company.getId(),
                    company.getName(),
                    company.getLocation()
            );
            companyDtoList.add(companyDto);
        }
        return companyDtoList;
    }

    public ApiResponse deleteCompany(Integer id){
        try {
            companyRepository.deleteById(id);
            return new ApiResponse("Company deleted",true);
        }catch (Exception e){
            return new ApiResponse("Company is not found",false);
        }
    }
}
