package com.weg.centroweg.cliente_pedido.application.dto.pedido.request;

import jakarta.validation.constraints.NotBlank;

public record PedidoDescricaoRequestDto(
        @NotBlank(message = "A descrição do pedido é obrigatória")
        String descricao
) {
}
