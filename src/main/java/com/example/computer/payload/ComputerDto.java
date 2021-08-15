package com.example.computer.payload;


import com.example.computer.entity.Color;
import com.example.computer.entity.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComputerDto {

    private Integer id;

    private String name;

    private Integer companyId;

    private String madeDate;

    private String price;

    private Integer colorId;

    private String size;

    private String ram;

    private String memory;

    private String description;
}
