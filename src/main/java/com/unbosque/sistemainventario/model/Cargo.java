package com.unbosque.sistemainventario.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "cargo")
public class Cargo {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long idCargo;
    @Column (name = "descripcion")
    private String descripcion;
    
}