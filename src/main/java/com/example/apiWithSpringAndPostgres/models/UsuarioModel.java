package com.example.apiWithSpringAndPostgres.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
/*
 * Con entity decimos que es un modelo real y que cada uno de los campos
 * que añadamos sera una columna en la base de datos
 */
@Table(name = "usuarios")
public class UsuarioModel {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;

    
    private String nombre;
    private String apellido;
    private long edad;
    private String email;
    private long prioridad;

    @ManyToOne
    @JoinColumn(name = "id_pais")
    private PaisModel pais;
    
    @ManyToOne
    @JoinColumn(name = "id_estado")
    private EstadoModel estado;

    public void setPrioridad(long prioridad) {
        this.prioridad = prioridad;
    }

    public long getPrioridad() {
        return prioridad;
    }

    public long getId() {
        return id;
    }

    /* Ingresar el id */
    public void setId(long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getEdad() {
        return edad;
    }

    public void setEdad(long edad) {
        this.edad = edad;
    }

    public PaisModel getPais() {
        return pais;
    }

    public void setPais(PaisModel pais) {
        this.pais = pais;
    }
    public EstadoModel getEstado() {
        return estado;
    }

    public void setEstado(EstadoModel estado) {
        this.estado = estado;
    }

}
