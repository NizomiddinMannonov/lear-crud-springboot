package com.example.computer.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ColorDto {

    private Integer id;

    private String name;

    public ColorDto(String name) {
        this.name = name;
    }
}
