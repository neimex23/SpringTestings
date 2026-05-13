package com.eze.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eze.demo.entity.ProductoPedido;

@Repository
public interface ProductoPedidoRepository extends JpaRepository<ProductoPedido, Integer> {
}
