/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.comercio.articulo;

import com.comercio.Categoria.Categoria;
import com.comercio.foto.Foto;
import com.comercio.promocion.Promocion;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
    
    @Column
    private int art_codigo;
    
    @Column
    private Integer art_subcod;   
    @Column

    private int art_habilitado;
    @Column
    private String art_nombre;
    @Column    
    private int art_stock;
    
    @Column     
    private BigDecimal art_precio_compra;
    @Column    
    private BigDecimal art_precio_venta;
    
    @Column
    private String art_descr;
    
    @ManyToOne()
    @JoinColumn(name="promocion",referencedColumnName="promo_id")
    private Promocion promocion;
    
    
    @ManyToOne()
    @JoinColumn(name="art_cat",referencedColumnName="cat_id")
    private Categoria art_cat;
    
    
    @OneToMany(mappedBy="articulo", cascade = CascadeType.ALL)
    //@JsonIgnore 
    @JsonManagedReference
    private List<Foto> fotos;

    
    
}
