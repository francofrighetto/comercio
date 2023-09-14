/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.comercio.articulo;

import com.comercio.Categoria.Categoria;
import com.comercio.foto.Foto;
import com.comercio.promocion.Promocion;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Franco
 */
@Getter
@Setter

@Entity
@Table(name="articulo")
public class Articulo {
 
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int art_id;
    

    private int codigo;
    

    private Integer subcodigo;


    private boolean art_habilitado;

    private String nombre;

    private int stock;
    
    private BigDecimal precio_compra;

    private BigDecimal precio_venta;
    
    private String descripcion;


    private String color;

    private String unidadMedida;

    //@ManyToOne()
    //@JoinColumn(name="promocion",referencedColumnName="promo_id")
    private int promocion;
    
    
    @ManyToOne()
    @JoinColumn(name="art_cat",referencedColumnName="cat_id")
    private Categoria art_cat;


    @ManyToMany(mappedBy="articulo")
    //@JsonIgnore
    @JsonManagedReference
    private List<Foto> fotos;


    public Articulo(int art_id) {
        this.art_id = art_id;
    }

    public Articulo(){}

    public int getArt_id(){
        return this.art_id;
    }
    
    
}
