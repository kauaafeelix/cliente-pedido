package com.weg.centroweg.cliente_pedido.application.mapper;

import com.weg.centroweg.cliente_pedido.application.dto.cliente.request.ClienteRequestDto;
import com.weg.centroweg.cliente_pedido.application.dto.cliente.response.ClienteResponseDto;
import com.weg.centroweg.cliente_pedido.domain.entity.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public Cliente toEntity(ClienteRequestDto request){

        return new Cliente(
                request.nome(),
                request.email()
        );
    }

    public ClienteResponseDto toDto(Cliente cliente){

        return new ClienteResponseDto(
                cliente.getId(),
                cliente.getNome(),
                cliente.getEmail()
        );
    }

}
