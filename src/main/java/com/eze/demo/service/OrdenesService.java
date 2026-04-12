package com.eze.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.eze.demo.entity.Orden;
import com.eze.demo.repository.OrdenRepository;

@Service
public class OrdenesService {
    private final OrdenRepository repo;

    public OrdenesService(OrdenRepository repo) {
        this.repo = repo;
    }

    public List<Orden> listar() {
    return repo.findAll();
    }

    public Orden guardar(Orden orden) {
        return repo.save(orden);
    }

    public Optional<Orden> obtener(Long id) {
        return repo.findById(id);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
    
}
