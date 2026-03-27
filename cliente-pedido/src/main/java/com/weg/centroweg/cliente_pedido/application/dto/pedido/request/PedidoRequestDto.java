package com.weg.centroweg.cliente_pedido.application.dto.pedido.request;

import java.time.LocalDateTime;

public record PedidoRequestDto(
        Double valor,
        String descricao,
        LocalDateTime dataPedido,
        Long clienteId
) {
}
