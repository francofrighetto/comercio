/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.comercio.foto;

import java.util.List;

/**
 *
 * @author Franco
 */

public interface FotoService {
    List<Foto> listar();
    void add(Foto c);
    Foto listarId(int id);
    Foto delete(int id);
    Foto edit(Foto cs);
}