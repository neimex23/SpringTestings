package com.eze.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eze.demo.entity.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {
    List<Comentario> findByClienteIdUsuario(int idCliente);
}
