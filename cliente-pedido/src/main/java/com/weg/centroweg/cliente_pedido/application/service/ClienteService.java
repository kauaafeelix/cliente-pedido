package com.weg.centroweg.cliente_pedido.application.service;

import com.weg.centroweg.cliente_pedido.application.dto.cliente.request.ClienteRequestDto;
import com.weg.centroweg.cliente_pedido.application.dto.cliente.response.ClienteResponseDto;
import com.weg.centroweg.cliente_pedido.application.mapper.ClienteMapper;
import com.weg.centroweg.cliente_pedido.domain.entity.Cliente;
import com.weg.centroweg.cliente_pedido.domain.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClienteService {

    private final ClienteRepository repository;
    private final ClienteMapper mapper;

    public ClienteResponseDto criarCliente(ClienteRequestDto request){

        Cliente cliente = mapper.toEntity(request);

        repository.save(cliente);

        return mapper.toDto(cliente);
    }

    public List<ClienteResponseDto> listarClientes(){

        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();

    }

    public ClienteResponseDto buscarClientePorId(Long id){

        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        return mapper.toDto(cliente);
    }

    public ClienteResponseDto buscarClientePorNome(String nome){

        Cliente cliente = repository.findByClienteNome(nome);

        if (cliente == null) {
            throw new RuntimeException("Cliente não encontrado");
        }

        return mapper.toDto(cliente);
    }

    public ClienteResponseDto atualizarCliente(Long id, ClienteRequestDto request){

        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        cliente.setNome(request.nome());
        cliente.setEmail(request.email());

        repository.save(cliente);

        return mapper.toDto(cliente);
    }

    public void deletarCliente(Long id){

        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        repository.delete(cliente);
    }

}
