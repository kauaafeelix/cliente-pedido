package com.weg.centroweg.cliente_pedido.domain.repository;

import com.weg.centroweg.cliente_pedido.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByClienteNome(String nome);
}
