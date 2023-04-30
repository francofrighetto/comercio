/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.comercio.promocion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Franco
 */
@Entity
@Table(name="promocion")
@Getter
@Setter
public class Promocion {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int promo_id;
    private String promo_nombre;
    private int promo_descuento;
    private int promo_vigente;
}
