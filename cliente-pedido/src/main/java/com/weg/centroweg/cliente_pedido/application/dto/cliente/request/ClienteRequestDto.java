package com.weg.centroweg.cliente_pedido.application.dto.cliente.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClienteRequestDto(

        @NotBlank(message = "O nome do cliente é obrigatório")
        String nome,

        @NotBlank(message = "O email do cliente é obrigatório")
        @Email(message= "O email do cliente deve ser válido")
        String email
) {
}
