package com.eze.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.eze.demo.entity.PruebaConcepto.OrdenPC;
import com.eze.demo.repository.OrdenRepository;

@Service
public class OrdenesService {
    private final OrdenRepository repo;

    public OrdenesService(OrdenRepository repo) {
        this.repo = repo;
    }

    public List<OrdenPC> listar() {
    return repo.findAll();
    }

    public OrdenPC guardar(OrdenPC orden) {
        return repo.save(orden);
    }

    public Optional<OrdenPC> obtener(Long id) {
        return repo.findById(id);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
    
}
