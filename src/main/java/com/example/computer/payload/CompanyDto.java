package com.example.computer.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {

    private Integer id;

    private String name;

    private String location;

    public CompanyDto(String name, String location) {
        this.name = name;
        this.location = location;
    }
}
