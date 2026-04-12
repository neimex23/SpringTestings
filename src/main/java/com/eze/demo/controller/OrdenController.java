package com.eze.demo.controller;

import com.eze.demo.entity.OrdenResponse;
import com.eze.demo.entity.DTOs.DTOProducto;
import com.eze.demo.service.MercadoPagoService;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/ordenes")
public class OrdenController {

    private final MercadoPagoService mercadoPagoService;

    public OrdenController(MercadoPagoService mercadoPagoService) {
        this.mercadoPagoService = mercadoPagoService;
    }

    @PostMapping("/create-order")
    public ResponseEntity<?> create(@RequestBody List<DTOProducto> products) {
        if (products == null || products.isEmpty()) {
            return ResponseEntity.badRequest().body("La lista de productos no puede estar vacía");
        }

        if (products.stream().anyMatch(p -> p.getCantidad() <= 0 || p.getPrecio().compareTo(BigDecimal.ZERO) <= 0)) {
            return ResponseEntity.badRequest().body("La cantidad y el precio de los productos deben ser mayores a cero");
        }

        try {
            return ResponseEntity.ok(mercadoPagoService.crearOrden(products));
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                .body("Error al crear la orden: " + e.getMessage());
        }
    }

}
