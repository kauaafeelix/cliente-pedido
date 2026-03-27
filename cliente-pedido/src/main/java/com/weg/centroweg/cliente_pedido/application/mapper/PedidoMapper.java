package com.weg.centroweg.cliente_pedido.application.mapper;

import com.weg.centroweg.cliente_pedido.application.dto.pedido.request.PedidoRequestDto;
import com.weg.centroweg.cliente_pedido.application.dto.pedido.response.PedidoResponseDto;
import com.weg.centroweg.cliente_pedido.domain.entity.Pedido;
import org.springframework.stereotype.Component;

@Component
public class PedidoMapper {

    public Pedido toEntity (PedidoRequestDto request){

        return new Pedido(
                request.descricao(),
                request.valor(),
                request.dataPedido()
        );
    }

    public PedidoResponseDto toDto (Pedido pedido){
        return new PedidoResponseDto(
                pedido.getId(),
                pedido.getValor(),
                pedido.getDescricao(),
                pedido.getDataPedido(),
                pedido.getCliente().getId()
        );
    }
}
