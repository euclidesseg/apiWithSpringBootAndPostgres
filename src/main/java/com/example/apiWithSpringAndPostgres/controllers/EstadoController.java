package com.example.apiWithSpringAndPostgres.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiWithSpringAndPostgres.models.EstadoModel;
import com.example.apiWithSpringAndPostgres.services.EstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoController {
    
    @Autowired
    EstadoService estadosRepository;

    @GetMapping("/query")
    // aceder a la ruta
    // /estados/query?idPais=82
    private ArrayList<EstadoModel> getByPais(@RequestParam("idPais") long idPais){
        return estadosRepository.obtenerPorPais(idPais);
    }
}
