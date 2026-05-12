package com.eze.demo.service;

import com.eze.demo.entity.PruebaConcepto.ClientePC;
import com.eze.demo.repository.ClienteRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository repo;

    public ClienteService(ClienteRepository repo) {
        this.repo = repo;
    }

    public List<ClientePC> listar() {
        return repo.findAll();
    }

    public ClientePC guardar(ClientePC cliente) {
        return repo.save(cliente);
    }

    public Optional<ClientePC> obtener(Long id) {
        return repo.findById(id);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}