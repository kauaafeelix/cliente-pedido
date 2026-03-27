package com.weg.centroweg.cliente_pedido.application.dto.pedido.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDateTime;

public record PedidoRequestDto(

        @PositiveOrZero(message = "O valor do pedido deve ser positivo ou zero")
        Double valor,

        @NotBlank(message = "A descrição do pedido é obrigatória")
        String descricao,

        @NotNull(message = "A data do pedido é obrigatória")
        LocalDateTime dataPedido,

        @Positive(message = "O ID do cliente deve ser um número maior que 0")
        @NotNull(message = "O ID do cliente é obrigatório")
        Long clienteId
) {
}
