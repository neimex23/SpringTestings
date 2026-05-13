package com.eze.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eze.demo.entity.Pedido;
import com.eze.demo.entity.Enums.EnumEstadoPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    List<Pedido> findByClienteIdUsuario(int idCliente);

    List<Pedido> findByRestauranteIdUsuario(int idRestaurante);

    List<Pedido> findByEstado(EnumEstadoPedido estado);
}
