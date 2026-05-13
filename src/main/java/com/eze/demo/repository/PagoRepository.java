package com.eze.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eze.demo.entity.Pago;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer> {
    Optional<Pago> findByIdTransaccion(String idTransaccion);
}
