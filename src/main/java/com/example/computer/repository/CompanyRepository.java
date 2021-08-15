package com.example.computer.repository;

import com.example.computer.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CompanyRepository extends JpaRepository<Company,Integer> {

}
