package com.example.apiWithSpringAndPostgres.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiWithSpringAndPostgres.models.UsuarioModel;
import com.example.apiWithSpringAndPostgres.services.UsuarioService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/usuario")
public class UserController {
    
    @Autowired 
    UsuarioService usuarioService;

    @GetMapping()
    public List<UsuarioModel> getUsuarios(){
        return usuarioService.obtenerUsuarios();
    }
    
    // postMapin solo es el nombre de lo que hara la peticion
    // El requestBody indica por donde se van a enviar el objeto que se guardara
    @PostMapping()
    public UsuarioModel setUsuario(@RequestBody UsuarioModel usuario){
        return usuarioService.agregarUsuario(usuario);
    }

     // Obtener por Id
     @GetMapping(path = "/{id}") 
     // la cual sera /usuario/1     el 1 sera el id 
     // no se usa requestBody porque requestBody es mas que todo para guardar datos y pathvariable es para 
     // consultar datos en base a una query
    //  el valor que mandemos por ruta se agregara a long id y este pasara como argumento del metodo
     public Optional<UsuarioModel> getById(@PathVariable("id") long id){
         return usuarioService.obtenerPorId(id);
     }

     @GetMapping(path = "/porEstado/query")
     public Optional<ArrayList<UsuarioModel>> getByEstado(@RequestParam("idEstado") long idEstado){
        return usuarioService.obtenerPorEstado(idEstado);
     }

     @GetMapping(path = "/porPais/query")
     public ArrayList<UsuarioModel> getByPais(@RequestParam("idPais") long idPais){
        return usuarioService.obtenerPorPais(idPais);
     }

     @DeleteMapping(path = "/{id}")
     public String deleteUser(@PathVariable("id") long id){
        boolean ok = usuarioService.eliminarUsuario(id);
        if(ok){
            return "El usuario se ah eliminado correctamente";
        }else{
            return "Error eliminando este usuario";
        }
     }
}

// Nota: para enviar el recuestBody de un usuario que tiene una entidad relacionalr en la api
// se hace de la siguienet manera tomando como ejemplo el proyecto actual y el controlador de usuarios

/*  {
        "nombre": "Euclides",
        "apellido": "Perez",
        "edad": 26,
        "email": "euclides2696@gmail.com",
        "prioridad": 1,
        "pais":{
            "id":1
        },
        "estado":{
            "id":1
        }
    }
*/