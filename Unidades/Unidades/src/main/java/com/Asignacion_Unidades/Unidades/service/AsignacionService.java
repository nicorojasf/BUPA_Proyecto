package com.Asignacion_Unidades.Unidades.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Asignacion_Unidades.Unidades.model.AsignacionUnidad;
import com.Asignacion_Unidades.Unidades.repository.AsignacionRepository;

@Service
public class AsignacionService {

    @Autowired
    private AsignacionRepository asignacionRepository;

    // Guardar o Actualizar
    public AsignacionUnidad guardar(AsignacionUnidad asignacion) {
        return asignacionRepository.save(asignacion);
    }

    // Listar todas las asignaciones
    public List<AsignacionUnidad> obtenerTodas() {
        return asignacionRepository.findAll();
    }

    // Buscar una por ID (usado para el PUT de devolución)
  public AsignacionUnidad buscarPorId(Integer id) {
    return asignacionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("No existe el registro: " + id));
    }

    public List<AsignacionUnidad> listarPorEmpleado(Integer idEmpleado) {
    return asignacionRepository.findByIdEmpleado(idEmpleado);
    }
 
   
}
