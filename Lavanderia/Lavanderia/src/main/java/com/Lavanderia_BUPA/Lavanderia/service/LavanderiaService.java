package com.Lavanderia_BUPA.Lavanderia.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Lavanderia_BUPA.Lavanderia.model.Lavanderia;
import com.Lavanderia_BUPA.Lavanderia.repository.LavanderiaRepository;

@Service
public class LavanderiaService {
    
    @Autowired
    private LavanderiaRepository lavanderiaRepository;

    // Buscar por estado
    public List<Lavanderia> buscarPorEstado(String estado) {
        return lavanderiaRepository.findByEstadoRopa(estado);
    }
    // Buscar el historial de una prenda
    public List<Lavanderia> historialDePrenda(Integer prendaId) {
        return lavanderiaRepository.findByPrendaId(prendaId);
    }

    public Lavanderia obtenerPorId(Integer id) {
    // findById devuelve un Optional, usamos .orElseThrow para manejar si el ID no existe
    return lavanderiaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("No se encontró el registro con ID: " + id));
    }
    
    // Listar todos los registros
    public List<Lavanderia> obtenerTodos() {
        return lavanderiaRepository.findAll();
    }

    // Registrar salida a lavandería
    public Lavanderia registrarEnvio(Lavanderia registro) {
        // Aquí es donde en el futuro llamaremos al Microservicio de Inventario
        registro.setEstadoRopa("PROCESANDO");
        return lavanderiaRepository.save(registro);
    }
    
    // Aquí podrías agregar lógica para cuando la ropa regresa
    public Lavanderia registrarRetorno(Integer id, Integer cantidadRecibida) {
        Lavanderia registro = lavanderiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro no encontrado"));
        
        registro.setCantidadRecibida(cantidadRecibida);
        registro.setEstadoRopa("RECIBIDO");
        registro.setFechaDeRetorno(LocalDateTime.now());
        return lavanderiaRepository.save(registro);
    }
}
