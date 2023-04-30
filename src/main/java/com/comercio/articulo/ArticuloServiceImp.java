/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.comercio.articulo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Franco
 */
@Service
public class ArticuloServiceImp implements ArticuloService{

    @Autowired
    private ArticuloRepositorio repo;
    @Override
    public List<Articulo> listar() {
        return repo.findAll();
    }

    @Override
    public Articulo add(Articulo a) {
        return repo.save(a);
    }

    @Override
    public Articulo listarId(int id) {
        return repo.findById(id);
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }

    @Override
    public Articulo edit(Articulo cs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
