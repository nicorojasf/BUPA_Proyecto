package com.BUPA_Inventario.Inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BUPA_Inventario.Inventario.model.Prendas;
import com.BUPA_Inventario.Inventario.service.PrendasService;

@RestController
@RequestMapping("/api/prendas")
public class PrendasController {
    
    @Autowired
    private PrendasService prendasService;

   @GetMapping("/listar")
    public ResponseEntity<List<Prendas>> listarTodo() {
    return ResponseEntity.ok(prendasService.obtenerTodas());
    }
    @GetMapping("/buscar")
    public ResponseEntity<List<Prendas>> buscar(@RequestParam String criterio) {
        return ResponseEntity.ok(prendasService.buscarRopaGeneral(criterio));
    }

    @PostMapping("/guardar")
    public ResponseEntity<Prendas> guardar(@RequestBody Prendas prenda) {
    return ResponseEntity.ok(prendasService.guardarPrendas(prenda));
    }
}
