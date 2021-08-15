package com.example.computer.service;

import com.example.computer.entity.Color;
import com.example.computer.entity.Company;
import com.example.computer.entity.Computer;
import com.example.computer.payload.ApiResponse;
import com.example.computer.payload.ComputerDto;
import com.example.computer.repository.ColorRepository;
import com.example.computer.repository.CompanyRepository;
import com.example.computer.repository.ComputerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ComputerService {

    final
    ColorRepository colorRepository;
    final
    CompanyRepository companyRepository;
    final
    ComputerRepository computerRepository;

    public ComputerService(CompanyRepository companyRepository, ColorRepository colorRepository, ComputerRepository computerRepository) {
        this.companyRepository = companyRepository;
        this.colorRepository = colorRepository;
        this.computerRepository = computerRepository;
    }

//    Bu method Computer qoshish uchun ishlatamiz

    public ApiResponse addComputer(ComputerDto computerDto) {
        Optional<Company> optionalCompany = companyRepository.findById(computerDto.getCompanyId());
        Optional<Color> optionalColor = colorRepository.findById(computerDto.getColorId());
        if (!optionalCompany.isPresent()) {
            return new ApiResponse("Company is not found", false);
        }
        if (!optionalColor.isPresent()) {
            return new ApiResponse("Color is not found", false);
        }


        Company company = optionalCompany.get();
        Color color = optionalColor.get();

        Computer computer = new Computer();
        computer.setName(computerDto.getName());
        computer.setCompany(company);
        computer.setMadeDate(computerDto.getMadeDate());
        computer.setPrice(computerDto.getPrice());
        computer.setColor(color);
        computer.setSize(computerDto.getSize());
        computer.setRam(computerDto.getRam());
        computer.setMemory(computerDto.getMemory());
        computer.setDescription(computerDto.getDescription());
        try {
            computerRepository.save(computer);
            return new ApiResponse("Computer saved", true);
        } catch (Exception e) {
            return new ApiResponse("Information is not full", false);
        }
    }

    public ApiResponse editComputer(Integer id, ComputerDto computerDto) {
        Optional<Computer> optionalComputer = computerRepository.findById(id);
        Optional<Company> optionalCompany = companyRepository.findById(computerDto.getCompanyId());
        Optional<Color> optionalColor = colorRepository.findById(computerDto.getColorId());
        if (!optionalComputer.isPresent()) {
            return new ApiResponse("Computer is not found", true);
        }
        if (!optionalCompany.isPresent()) {
            return new ApiResponse("Company is not found", false);
        }
        if (!optionalColor.isPresent()) {
            return new ApiResponse("Color is not found", false);
        }


        Company company = optionalCompany.get();

        Color color = optionalColor.get();

        Computer computer = optionalComputer.get();

        computer.setName(computerDto.getName());
        computer.setCompany(company);
        computer.setMadeDate(computerDto.getMadeDate());
        computer.setPrice(computerDto.getPrice());
        computer.setColor(color);
        computer.setSize(computerDto.getSize());
        computer.setRam(computerDto.getRam());
        computer.setMemory(computerDto.getMemory());
        computer.setDescription(computerDto.getDescription());
        try {
            computerRepository.save(computer);
            return new ApiResponse("Computer edited", true);
        } catch (Exception e) {
            return new ApiResponse("Information is not full", false);
        }
    }

    public ComputerDto getComputer(Integer id) {
        Optional<Computer> optionalComputer = computerRepository.findById(id);
        if (optionalComputer.isPresent()) {
            Computer computer = optionalComputer.get();
            return new ComputerDto(
                    computer.getId(),
                    computer.getName(),
                    computer.getCompany().getId(),
                    computer.getMadeDate(),
                    computer.getPrice(),
                    computer.getColor().getId(),
                    computer.getSize(),
                    computer.getRam(),
                    computer.getMemory(),
                    computer.getDescription()
            );
        }
        return new ComputerDto();
    }

    public List<ComputerDto> getComputers() {
        List<Computer> computerList = computerRepository.findAll();
        List<ComputerDto> computerDtoList = new ArrayList<>();
        for (Computer computer : computerList) {
            ComputerDto computerDto = new ComputerDto(
                    computer.getId(),
                    computer.getName(),
                    computer.getCompany().getId(),
                    computer.getMadeDate(),
                    computer.getPrice(),
                    computer.getColor().getId(),
                    computer.getSize(),
                    computer.getRam(),
                    computer.getMemory(),
                    computer.getDescription()
            );
            computerDtoList.add(computerDto);
        }
        return computerDtoList;
    }

    public ApiResponse deleteComputer(Integer id){
        try {
            Optional<Computer> optionalComputer = computerRepository.findById(id);
            return new ApiResponse("Computer deleted",true);
        }catch (Exception e){
            return new ApiResponse("Computer is not found",true);
        }
    }

}
