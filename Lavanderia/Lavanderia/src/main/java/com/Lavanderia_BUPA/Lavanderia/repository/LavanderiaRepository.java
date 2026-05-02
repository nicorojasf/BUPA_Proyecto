package com.Lavanderia_BUPA.Lavanderia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Lavanderia_BUPA.Lavanderia.model.Lavanderia;
import java.time.LocalDateTime;


public interface LavanderiaRepository extends JpaRepository<Lavanderia, Integer> {

    // Buscar prendas que están en un estado específico (ej: "RETARDADO")
    List<Lavanderia> findByEstadoRopa(String estado);

    // Buscar historial de una prenda específica
    List<Lavanderia> findByPrendaId(Integer prendraId);

    // Buscar envíos realizados hoy
    List<Lavanderia> findByFechaDeSalidaAfter(LocalDateTime fecha);

    //Para buscar, por ejemplo, qué registros de una prenda específica siguen todavía en la lavandería
    List<Lavanderia> findByPrendaIdAndEstadoRopa(Integer prendaId, String estado);
}
