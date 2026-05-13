package com.eze.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eze.demo.entity.Reclamo;
import com.eze.demo.entity.Enums.EnumEstadoReclamo;

@Repository
public interface ReclamoRepository extends JpaRepository<Reclamo, Integer> {
    List<Reclamo> findByEstado(EnumEstadoReclamo estado);
}
