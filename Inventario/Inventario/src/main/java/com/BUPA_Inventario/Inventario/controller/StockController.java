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

import com.BUPA_Inventario.Inventario.model.Stock;
import com.BUPA_Inventario.Inventario.service.StockService;

@RestController
@RequestMapping("/api/stock")
public class StockController {
    
    @Autowired
    private StockService stockService;

                    
    @GetMapping
    public ResponseEntity<List<Stock>> listarTodo() {
        return ResponseEntity.ok(stockService.obtenerTodoElStock());
    }

    // Buscar stock por tipo (Ropa de Cama / Ropa Paciente)
    // URL: GET http://localhost:8081/api/stock/tipo?tipo=Cama
    @GetMapping("/tipo")
    public ResponseEntity<List<Stock>> buscarPorTipo(@RequestParam String tipo) {
        return ResponseEntity.ok(stockService.obtenerStockPorTipoGeneral(tipo));
    }

    // Guardar stock nuevo
    @PostMapping
    public ResponseEntity<Stock> crear(@RequestBody Stock stock) {
        return ResponseEntity.ok(stockService.guardarStock(stock));
    }
}
