package com.weg.centroweg.cliente_pedido.domain.repository;

import com.weg.centroweg.cliente_pedido.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByClienteId (Long clienteId);
    Pedido findByIdAndDescricao(Long id, String descricao);
}
