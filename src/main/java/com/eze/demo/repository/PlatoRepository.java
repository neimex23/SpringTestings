package com.eze.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eze.demo.entity.Plato;

@Repository
public interface PlatoRepository extends JpaRepository<Plato, Integer> {
}
