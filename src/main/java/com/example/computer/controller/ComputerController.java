package com.example.computer.controller;

import com.example.computer.payload.ApiResponse;
import com.example.computer.payload.ComputerDto;
import com.example.computer.service.ComputerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/computer")
public class ComputerController {

    final
    ComputerService computerService;

    public ComputerController(ComputerService computerService) {
        this.computerService = computerService;
    }

    @PostMapping
    private ApiResponse addComputer(@RequestBody ComputerDto computerDto) {
        return computerService.addComputer(computerDto);
    }


    @PutMapping("/{id}")
    private ApiResponse editComputer(@PathVariable Integer id,@RequestBody ComputerDto computerDto) {
        return computerService.editComputer(id, computerDto);
    }


    @GetMapping("/{id}")
    public ComputerDto getComputer(@PathVariable Integer id) {
        return computerService.getComputer(id);
    }

    @GetMapping
    private List<ComputerDto> getComputerList() {
        return computerService.getComputers();
    }

    @DeleteMapping("/{id}")
    private ApiResponse deleteComputer(@PathVariable Integer id) {
        return computerService.deleteComputer(id);
    }
}
