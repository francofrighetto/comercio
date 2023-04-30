/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.comercio.articulo;

import java.util.List;

/**
 *
 * @author Franco
 */
public interface ArticuloService {
    List<Articulo> listar();
    Articulo add(Articulo c);
    Articulo listarId(int id);
    void delete(int id);
    Articulo edit(Articulo cs);
}
