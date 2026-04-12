package com.eze.demo.repository;


import com.eze.demo.entity.Cliente;
import com.eze.demo.entity.Orden;
import com.thoughtworks.qdox.model.expression.Or;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenRepository extends JpaRepository<Orden, Long> {
}
