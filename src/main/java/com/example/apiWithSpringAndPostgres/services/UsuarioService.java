package com.example.apiWithSpringAndPostgres.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apiWithSpringAndPostgres.models.UsuarioModel;
import com.example.apiWithSpringAndPostgres.repository.IUsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    IUsuarioRepository usuarioRepository;

    //getAll
    public List<UsuarioModel> obtenerUsuarios(){
        List<UsuarioModel> lista;
        lista = usuarioRepository.findAll();
        return lista;
    }
    // tabien podria hacerlo de esta manera
    // si mi repositorio extendiera de CrudRepository y no de JPArepositori
    /*
        public ArrayList<UsuarioModel> obtenerUsuarios(){
        return (ArrayList <UsuarioModel>) usuarioRepository.findAll();
        }
    */
    

    // set
    public UsuarioModel agregarUsuario(UsuarioModel usuario){
        return this.usuarioRepository.save(usuario);
    }
    // getById
    public Optional<UsuarioModel> obtenerPorId(long id){
        return usuarioRepository.findById(id);
    }

    // getByEstado
    public Optional<ArrayList<UsuarioModel>>obtenerPorEstado(long id){
        return usuarioRepository.findByEstadoId(id);
    }
    // getbyPais
    public ArrayList<UsuarioModel>obtenerPorPais(long idPais){
        return usuarioRepository.findByPaisId(idPais);
    }

    // delete
    public boolean eliminarUsuario(long id){
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
