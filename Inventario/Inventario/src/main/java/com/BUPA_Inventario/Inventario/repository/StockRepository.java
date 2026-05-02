package com.BUPA_Inventario.Inventario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BUPA_Inventario.Inventario.model.Stock;

public interface StockRepository extends JpaRepository<Stock,Integer>{

    List<Stock> findByPrendas_Categoria(String categoria); 
 }
