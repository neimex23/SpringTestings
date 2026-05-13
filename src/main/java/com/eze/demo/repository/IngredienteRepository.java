package com.eze.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eze.demo.entity.Ingrediente;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer> {
    Optional<Ingrediente> findByNombre(String nombre);
}
