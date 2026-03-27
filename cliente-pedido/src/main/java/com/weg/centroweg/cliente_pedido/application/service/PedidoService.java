package com.weg.centroweg.cliente_pedido.application.service;

import com.weg.centroweg.cliente_pedido.application.dto.pedido.request.PedidoDescricaoRequestDto;
import com.weg.centroweg.cliente_pedido.application.dto.pedido.request.PedidoRequestDto;
import com.weg.centroweg.cliente_pedido.application.dto.pedido.response.PedidoResponseDto;
import com.weg.centroweg.cliente_pedido.application.mapper.PedidoMapper;
import com.weg.centroweg.cliente_pedido.domain.entity.Cliente;
import com.weg.centroweg.cliente_pedido.domain.entity.Pedido;
import com.weg.centroweg.cliente_pedido.domain.repository.ClienteRepository;
import com.weg.centroweg.cliente_pedido.domain.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final PedidoMapper pedidoMapper;
    private final ClienteRepository clienteRepository;

    public PedidoResponseDto criarPedido(PedidoRequestDto request){

        Cliente cliente = clienteRepository.findById(request.clienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Pedido pedido = pedidoMapper.toEntity(request);

        pedido.setCliente(cliente);

        pedidoRepository.save(pedido);

        return pedidoMapper.toDto(pedido);
    }

    public List<PedidoResponseDto> listarPedidos(){

        return pedidoRepository.findAll().stream()
                .map(pedidoMapper::toDto)
                .toList();

    }

    public PedidoResponseDto buscarPedidoPorId(Long id){

        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        return pedidoMapper.toDto(pedido);
    }

    public PedidoResponseDto buscarPedidoPorDescricao(Long id, PedidoDescricaoRequestDto request){

        Pedido pedido = pedidoRepository.findByIdAndDescricao(id, request.descricao());

        if (pedido == null) {
            throw new RuntimeException("Pedido não encontrado");
        }

        return pedidoMapper.toDto(pedido);
    }

    public List<PedidoResponseDto> buscarPedidoPorClienteId(Long clienteId){

        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));


        return pedidoRepository.findByClienteId(clienteId)
                .stream()
                .map(pedidoMapper::toDto)
                .toList();
    }



    public PedidoResponseDto atualizarPedido(Long id, PedidoRequestDto request){

        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));


        pedidoRepository.save(pedido);

        return pedidoMapper.toDto(pedido);
    }

    public void deletarPedido(Long id){

        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        pedidoRepository.delete(pedido);
    }
}
