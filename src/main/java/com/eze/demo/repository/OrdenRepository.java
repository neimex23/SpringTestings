package com.eze.demo.repository;


import com.eze.demo.entity.PruebaConcepto.ClientePC;
import com.eze.demo.entity.PruebaConcepto.OrdenPC;
import com.thoughtworks.qdox.model.expression.Or;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenRepository extends JpaRepository<OrdenPC, Long> {
}
