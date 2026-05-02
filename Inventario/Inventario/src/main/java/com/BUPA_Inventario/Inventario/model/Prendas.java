package com.BUPA_Inventario.Inventario.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Prendas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prendas {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @Column(nullable = false, length = 200)
    private String nombrePrenda;
    
    @Column(length = 200)
    private String material;

    @Column(nullable = false, length = 200)
    private String categoria;

    @JsonManagedReference
    @OneToMany(mappedBy = "prendas", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Stock> stocks;
}
