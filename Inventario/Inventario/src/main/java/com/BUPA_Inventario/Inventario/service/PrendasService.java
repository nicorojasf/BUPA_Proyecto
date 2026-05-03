package com.BUPA_Inventario.Inventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BUPA_Inventario.Inventario.model.Prendas;
import com.BUPA_Inventario.Inventario.repository.PrendasRepository;

@Service
public class PrendasService {
    @Autowired

    private PrendasRepository prendasRepository;

    public List<Prendas> obtenerTodas() {
    return prendasRepository.findAll(); // JpaRepository ya trae este método
}
    public List<Prendas> buscarRopaGeneral(String criterio){
        return prendasRepository.findByNombrePrendaOrCategoria(criterio, criterio);
    }

    public List<Prendas> buscarRopaPorCategoria(String categoria){
        return prendasRepository.findByCategoria(categoria);
    }

    public List<Prendas> buscaRopaPorPrenda(String palabra){
        return prendasRepository.findByNombrePrenda(palabra);
    }

    public Prendas guardarPrendas(Prendas prenda){
        return prendasRepository.save(prenda);
    }
    
}
