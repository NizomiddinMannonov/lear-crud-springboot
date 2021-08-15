package com.example.computer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    private Company company;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String madeDate;

    @Column(nullable = false)
    private String price;

    @ManyToOne(optional = false)
    private Color color;

    @Column(nullable = false)
    private String size;

    @Column(nullable = false)
    private String ram;

    @Column(nullable = false)
    private String memory;

    @Column(nullable = false,columnDefinition = "TEXT")
    private String description;


}

// Color,company, alohida """ description,madeDate, qowiladi
