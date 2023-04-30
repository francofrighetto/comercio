/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.comercio.articulo;

import java.util.List;
import org.springframework.data.repository.Repository;

/**
 *
 * @author Franco
 */
public interface ArticuloRepositorio extends Repository<Articulo,Integer>{
    List<Articulo>findAll();
    Articulo findById(int id_header);
    Articulo save(Articulo h);
    void deleteById(int h);
}
