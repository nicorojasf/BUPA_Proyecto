package com.BUPA_Inventario.Inventario.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Stock")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Integer id;

    @Column(nullable = false)
    private Integer cantidadActual;

    @Column(nullable = false)
    private Integer cantidadMinima;

    @Column(nullable = false)
    private Integer cantidadBodega;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "prenda_id", nullable = false)
    private Prendas prendas;
}
