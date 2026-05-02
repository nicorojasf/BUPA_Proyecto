package com.BUPA_Inventario.Inventario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BUPA_Inventario.Inventario.model.Prendas;

public interface PrendasRepository extends JpaRepository<Prendas,Integer> {

    List<Prendas> findByCategoria(String categoria);

    List<Prendas> findByNombrePrenda(String palabra);

    List<Prendas> findByNombrePrendaOrCategoria(String nombrePrenda, String categoria);
}
