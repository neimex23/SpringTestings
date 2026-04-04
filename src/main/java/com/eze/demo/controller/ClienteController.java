package com.eze.demo.controller;

import com.eze.demo.entity.Cliente;
import com.eze.demo.entity.DtoCliente;
import com.eze.demo.service.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
     @Operation(summary = "Listar Todos los Clientes")
    public List<Cliente> listar() {
        return service.listar();
    }

    @PostMapping
    @Operation(summary = "Crear cliente")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Cliente creado"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    public ResponseEntity<Cliente> crear(@RequestBody DtoCliente cliente) {

        Cliente nuevo = service.guardar(new Cliente(cliente.getNombre(),cliente.getEmail()));

        URI location = URI.create("/clientes/" + nuevo.getId());

        return ResponseEntity.created(location).body(nuevo);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener Cliente por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cliente encontrado"),
            @ApiResponse(responseCode = "404", description = "Cliente no existe")
    })
    public Cliente obtener(@PathVariable Long id) {

        return service.obtener(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
     @Operation(summary = "Eliminar Cliente por ID")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        service.obtener(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        service.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}