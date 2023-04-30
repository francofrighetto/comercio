/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.comercio.foto;

import java.util.List;
import org.springframework.data.repository.Repository;

/**
 *
 * @author Franco
 */

public interface FotoRepositorio extends Repository<Foto,Integer>{
    List<Foto>findAll();
    Foto findById(int id_header);
    void save(Foto h);
    void deleteById(int h);
}
