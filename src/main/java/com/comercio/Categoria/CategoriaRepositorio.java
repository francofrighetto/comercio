/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.comercio.Categoria;

import java.util.List;
import org.springframework.data.repository.Repository;

/**
 *
 * @author Franco
 */
public interface CategoriaRepositorio extends Repository<Categoria,Integer>{
    List<Categoria>findAll();
    Categoria findById(int id_cat);
    void save(Categoria c);
    void deleteById(int c);
}
