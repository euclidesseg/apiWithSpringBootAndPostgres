package com.example.apiWithSpringAndPostgres.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apiWithSpringAndPostgres.models.EstadoModel;

public interface IEstadoRepository extends JpaRepository<EstadoModel, Long>{
    public abstract ArrayList<EstadoModel>findByPaisId(long idPais);
}

// Notas 
/*
 *  Spring utiliza la convención de nomenclatura de métodos de consulta
 *  para inferir la consulta que se debe realizar en la base de datos.
 *  En este caso, el método se llama "findByPaisId", lo que indica que se 
 *  busca un EstadoModel por el id de su país.
 * 
 *  En este caso, PaisId se refiere a la propiedad en la clase EstadoModel
 *  que representa la relación ManyToOne, que se llama pais, 
 *  pero que está mapeada a la columna id_pais en la base de datos mediante la anotación @JoinColumn.
 */