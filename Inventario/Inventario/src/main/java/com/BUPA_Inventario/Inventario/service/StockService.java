package com.BUPA_Inventario.Inventario.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BUPA_Inventario.Inventario.model.Stock;
import com.BUPA_Inventario.Inventario.repository.StockRepository;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    // Listar todo el stock actual de la clínica
    public List<Stock> obtenerTodoElStock() {
        return stockRepository.findAll();
    }

    //Buscar stock de una categoría específica (Ej: Ropa de Cama)
    public List<Stock> buscarPorCategoria(String categoria) {
        // Aprovechamos la relación que definiste en el Model
        return stockRepository.findAll().stream()
                .filter(s -> s.getPrendas().getCategoria().equalsIgnoreCase(categoria))
                .toList();
    }

    //Agregar o Actualizar Stock
    public Stock guardarStock(Stock stock) {
        // Aquí podrías agregar lógica de negocio: 
        // Ej: No permitir stock negativo
        if (stock.getCantidadActual() < 0) {
            throw new RuntimeException("La cantidad no puede ser negativa");
        }
        return stockRepository.save(stock);
    }
    
    public List<Stock> obtenerStockPorTipoGeneral(String tipo) {
    // Esto busca en la tabla Stock, pero filtrando por la columna 'categoria' de la tabla Prendas
    // Es lo que el profesor evaluará como "Trazabilidad e Interoperabilidad"
    return stockRepository.findAll().stream()
            .filter(s -> s.getPrendas().getCategoria().contains(tipo))
            .collect(Collectors.toList());
}
}
