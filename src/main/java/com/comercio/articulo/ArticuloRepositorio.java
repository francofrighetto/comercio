/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.comercio.articulo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

/**
 *
 * @author Franco
 */
public interface ArticuloRepositorio extends JpaRepository<Articulo,Integer> {

    @Query(value = "SELECT * FROM Articulo WHERE art_cat = :idCategoria", nativeQuery = true)
    List<Articulo> findByArt_cat_Cat_id(int idCategoria);

    @Query(value = "SELECT * FROM Articulo WHERE promocion <> 0", nativeQuery = true)
    List<Articulo> findPromocion();

}
