package com.example.apiWithSpringAndPostgres.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apiWithSpringAndPostgres.models.PaisModel;

public interface IPaisRepository extends JpaRepository<PaisModel, Long>{
    
}
