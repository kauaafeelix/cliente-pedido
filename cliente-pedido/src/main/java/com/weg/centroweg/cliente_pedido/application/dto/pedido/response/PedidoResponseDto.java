package com.weg.centroweg.cliente_pedido.application.dto.pedido.response;

import java.time.LocalDateTime;

public record PedidoResponseDto(
        Long id,
        Double valor,
        String descricao,
        LocalDateTime dataPedido,
        Long idCliente
        ) {
}
