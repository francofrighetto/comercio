/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.comercio.foto;

import com.comercio.articulo.Articulo;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Franco
 */
@Entity
@Table(name="foto")
@Getter
@Setter
public class Foto {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int foto_id;
    
    @Column
    private String foto_nombre;
    
    @ManyToOne()
    @JoinColumn(name="foto_art",referencedColumnName="art_id")
    @JsonBackReference
    private Articulo articulo;

    public Foto(String foto_nombre, Articulo articulo) {
        this.foto_nombre = foto_nombre;
        this.articulo = articulo;
    }
    public Foto() {
    }


    public Articulo getArticulo(){
        return this.articulo;
    }

    public void setArticulo(Articulo articulo){
        this.articulo = articulo;
    }

    public String getFoto_nombre() {
        return foto_nombre;
    }

    public void setFoto_nombre(String foto_nombre) {
        this.foto_nombre = foto_nombre;
    }
}
