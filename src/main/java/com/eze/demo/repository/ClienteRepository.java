package com.eze.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eze.demo.entity.PruebaConcepto.ClientePC;

public interface ClienteRepository extends JpaRepository<ClientePC, Long> {
}