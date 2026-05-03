package com.Asignacion_Unidades.Unidades.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Asignacion_Unidades.Unidades.model.AsignacionUnidad;
import com.Asignacion_Unidades.Unidades.service.AsignacionService;

@RestController
@RequestMapping("/api/asignaciones")
public class AsignacionController {

    @Autowired
    private AsignacionService asignacionService;

    // 1. Guardar una nueva asignación (POST)
    @PostMapping("/guardar")
    public ResponseEntity<AsignacionUnidad> guardar(@RequestBody AsignacionUnidad asignacion) {
        AsignacionUnidad nuevaAsignacion = asignacionService.guardar(asignacion);
        return new ResponseEntity<>(nuevaAsignacion, HttpStatus.CREATED);
    }

    // 2. Obtener todas las asignaciones (GET)
    @GetMapping("/listar")
    public List<AsignacionUnidad> obtenerTodas() {
        return asignacionService.obtenerTodas();
    }

    // 3. Buscar una asignación por su ID automático (GET)
    @GetMapping("/{id}")
    public ResponseEntity<AsignacionUnidad> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(asignacionService.buscarPorId(id));
    }

    // 4. Buscar todas las asignaciones de un empleado (GET)
    @GetMapping("/empleado/{idEmpleado}")
    public List<AsignacionUnidad> listarPorEmpleado(@PathVariable Integer idEmpleado) {
        return asignacionService.listarPorEmpleado(idEmpleado);
    }

    // 5. Registrar devolución (PUT) - Usa el buscarPorId del Service
    @PutMapping("/devolucion/{id}")
    public ResponseEntity<AsignacionUnidad> registrarDevolucion(@PathVariable Integer id) {
        // Buscamos el registro existente usando el ID automático
        AsignacionUnidad asignacion = asignacionService.buscarPorId(id);
        
        // Modificamos los datos (puedes añadir lógica aquí)
        asignacion.setFechaDevolucion(java.time.LocalDateTime.now());
        asignacion.setEstadoUnidad("DEVUELTO");
        
        // Guardamos los cambios
        return ResponseEntity.ok(asignacionService.guardar(asignacion));
    }
    
}
