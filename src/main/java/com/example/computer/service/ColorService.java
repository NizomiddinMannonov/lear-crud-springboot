package com.example.computer.service;

import com.example.computer.entity.Color;
import com.example.computer.payload.ApiResponse;
import com.example.computer.payload.ColorDto;
import com.example.computer.repository.ColorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ColorService {

    final
    ColorRepository colorRepository;

    public ColorService(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    public ApiResponse addColor(ColorDto colorDto){
        Color color=new Color();
        color.setName(colorDto.getName());
        try {
            colorRepository.save(color);
            return new ApiResponse("Color saved",true);
        }catch (Exception e){
            return new ApiResponse("Kiritilgan malumotlar toliq emas",false);
        }

    }

    public ApiResponse editColor(Integer id,ColorDto colorDto){
        Optional<Color> colorOptional = colorRepository.findById(id);
        if (colorOptional.isPresent()){
            Color color = colorOptional.get();
            color.setName(colorDto.getName());
            colorRepository.save(color);
            return new ApiResponse("Color edited",true);

        }else {
            return new ApiResponse("Color is not found",false);
        }
    }

    public ColorDto getColor(Integer id){
        Optional<Color> optionalColor = colorRepository.findById(id);
        if (optionalColor.isPresent()){
            Color color = optionalColor.get();
            return new ColorDto(
                    color.getId(),
                    color.getName()
            );
        }
        return new ColorDto();
    }

    public List<ColorDto>getColors(){
        List<Color> colorList = colorRepository.findAll();
        List<ColorDto>colorDtoList=new ArrayList<>();
        for (Color color : colorList) {
            ColorDto colorDto=new ColorDto(
                    color.getId(),
                    color.getName()
            );
            colorDtoList.add(colorDto);
        }
        return colorDtoList;
    }

    public   ApiResponse deleteColor(Integer id){
        try {
            colorRepository.deleteById(id);
            return new ApiResponse("Color deleted",true);
        }catch (Exception e){
            return new ApiResponse("Color is not found",false);
        }
    }


}
