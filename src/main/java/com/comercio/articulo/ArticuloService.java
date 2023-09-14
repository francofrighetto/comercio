/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.comercio.articulo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Franco
 */
@Service
public class ArticuloService {

    @Autowired
    private ArticuloRepositorio repo;

    public List<Articulo> listar() {
        return repo.findAll();
    }
    public Articulo add(Articulo a) {
        return repo.save(a);
    }


    public Optional<Articulo> listarId(int id) {
        return repo.findById(id);
    }


    public void delete(int id) {
        repo.deleteById(id);
    }


    public Articulo edit(Articulo cs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Articulo> obtenerArticulosPorIdCategoria(int idCategoria) {
        return repo.findByArt_cat_Cat_id(idCategoria);
    }

    public List<Articulo> obtenerPromociones() {
        return repo.findPromocion();
    }

}
