package com.example.computer.controller;

import com.example.computer.payload.ApiResponse;
import com.example.computer.payload.ColorDto;
import com.example.computer.service.ColorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/color")
public class ColorController {

    final
    ColorService colorService;

    public ColorController(ColorService colorService) {
        this.colorService = colorService;
    }

    @PostMapping
    private ApiResponse addColor(@RequestBody ColorDto colorDto){
        return colorService.addColor(colorDto);
    }

    @PutMapping("/{id}")
    private ApiResponse editColor(@PathVariable Integer id,@RequestBody ColorDto colorDto){
        return colorService.editColor(id,colorDto);
    }

    @GetMapping("/{id}")
    private ColorDto getColor(@PathVariable Integer id){
        return colorService.getColor(id);
    }

    @GetMapping
    private List<ColorDto>getColors(){

        return colorService.getColors();
    }

    @DeleteMapping("/{id}")
    private ApiResponse deleteColor(@PathVariable Integer id){
        return colorService.deleteColor(id);
    }


}
