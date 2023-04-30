/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.comercio.Categoria;

import java.util.List;

/**
 *
 * @author Franco
 */
public interface CategoriaService {
    List<Categoria> listar();
    void add(Categoria c);
    Categoria listarId(int id);
    void delete(int id);
    void edit(Categoria cs);
}
