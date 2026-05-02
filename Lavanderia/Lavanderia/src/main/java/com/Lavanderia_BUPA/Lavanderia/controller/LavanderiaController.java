package com.Lavanderia_BUPA.Lavanderia.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Lavanderia_BUPA.Lavanderia.model.Lavanderia;
import com.Lavanderia_BUPA.Lavanderia.service.LavanderiaService;

@RestController
@RequestMapping("/api/lavanderia")
public class LavanderiaController {

    @Autowired
    private LavanderiaService lavanderiaService;

    @GetMapping
    public List<Lavanderia> listar() {
        return lavanderiaService.obtenerTodos();
    }

    @PostMapping("/enviar")
    public Lavanderia enviar(@RequestBody Lavanderia registro) {
        return lavanderiaService.registrarEnvio(registro);
    }

    @GetMapping("/estado/{estado}")
    public List<Lavanderia> listarPorEstado(@PathVariable String estado) {
        return lavanderiaService.buscarPorEstado(estado);
    }

    @GetMapping("/prenda/{prendaId}")
    public List<Lavanderia> verHistorialPrenda(@PathVariable Integer prendaId) {
        return lavanderiaService.historialDePrenda(prendaId);
    }

    @PutMapping("/retorno/{id}")
    public Lavanderia registrarRetorno(@PathVariable Integer id, @RequestBody Lavanderia datosRetorno) {
        // Buscamos el registro existente por el ID (la llave primaria)
        Lavanderia registroExistente = lavanderiaService.obtenerPorId(id); 
    
        // Actualizamos solo los campos de llegada
        registroExistente.setCantidadRecibida(datosRetorno.getCantidadRecibida());
        registroExistente.setFechaDeRetorno(LocalDateTime.now()); // Se asigna la hora actual del retorno
        registroExistente.setEstadoRopa("RECIBIDO");
        
        return lavanderiaService.registrarEnvio(registroExistente); // Guardamos los cambios
}
}
