package com.eze.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eze.demo.entity.SubCategoria;
import com.eze.demo.entity.Enums.EnumCategoriaProducto;

@Repository
public interface SubCategoriaRepository extends JpaRepository<SubCategoria, Integer> {
    Optional<SubCategoria> findByNombre(String nombre);

    List<SubCategoria> findByCategoria(EnumCategoriaProducto categoria);
}
