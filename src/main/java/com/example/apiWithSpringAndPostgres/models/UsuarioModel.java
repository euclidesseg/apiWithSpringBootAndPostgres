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
/* especificamos que la tabla se va a llamar usuario */
public class UsuarioModel {

    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /* que se genere automaticamente y que se atutoincremente el campo id */
    @Column(unique = true, nullable = false)
    /* que es unico y no null */
    private long id;

    
    private String nombre;
    private String apellido;
    private long edad;
    private String email;
    private long prioridad;

    @ManyToOne
    // se agrega esta sentencia por la relacion entre pais y usuario
    // la clave de pais pasa a ser clave foranea de usuario
    @JoinColumn(name = "id_pais")
    // join column indica que id_pais es el nombre del pais con el que vamos a identificar el pais
    // cuando agreguemos un usuario nuevo, es decir, cuando agregamos un usuario nuevo y lea agreguemos
    // un pais lo haremos con id_pais = el id del pais
    private PaisModel pais;
    
    @ManyToOne
    @JoinColumn(name = "id_estado")
    private EstadoModel estado;

    /* DECLARANDO LOS METODOS PARA MANIPULAR LAS PROPIEDADES DE LA CLASE */
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
