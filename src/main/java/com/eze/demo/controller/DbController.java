package com.eze.demo.controller;
import com.eze.demo.service.FirebaseService;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/DB")
public class DbController {
    private final FirebaseService service;

    public DbController(FirebaseService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Probar conexión a Firebase")
    public void probar() {
        service.testConnection();
    }
}
