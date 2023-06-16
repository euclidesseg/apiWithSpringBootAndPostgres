package com.example.apiWithSpringAndPostgres.repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.apiWithSpringAndPostgres.models.UsuarioModel;

@Repository
public interface IUsuarioRepository extends JpaRepository<UsuarioModel, Long> {

     // <UsuarioModel, Long> indica el tipo de identidad que se va a manejar en este
    // repositorio
    // Longo se refiere al tipo de datos del identificador unico de mi tabla
    // UsuarioModel

    public abstract ArrayList<UsuarioModel>findByPaisId(long idPais);
    public abstract Optional<ArrayList<UsuarioModel>>findByEstadoId(long idEstado);
}
