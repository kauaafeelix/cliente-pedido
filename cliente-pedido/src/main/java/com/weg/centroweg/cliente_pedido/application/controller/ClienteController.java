package com.weg.centroweg.cliente_pedido.application.controller;

import com.weg.centroweg.cliente_pedido.application.dto.cliente.request.ClienteRequestDto;
import com.weg.centroweg.cliente_pedido.application.dto.cliente.response.ClienteResponseDto;
import com.weg.centroweg.cliente_pedido.application.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteResponseDto> save (@RequestBody ClienteRequestDto request){

        ClienteResponseDto response = clienteService.criarCliente(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDto>> findAll (){

        List<ClienteResponseDto> response = clienteService.listarClientes();
        return ResponseEntity.ok(response);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDto> findById (@PathVariable Long id){

        ClienteResponseDto response = clienteService.buscarClientePorId(id);
        return ResponseEntity.ok(response);

    }

    @GetMapping("/nome/{nome}")
     public ResponseEntity<ClienteResponseDto> findByNome (@PathVariable String nome){

        ClienteResponseDto response = clienteService.buscarClientePorNome(nome);
        return ResponseEntity.ok(response);

    }

    @PutMapping("/{id}")
     public ResponseEntity<ClienteResponseDto> update (@PathVariable Long id, @RequestBody ClienteRequestDto request){

        ClienteResponseDto response = clienteService.atualizarCliente(id, request);
        return ResponseEntity.ok(response);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){

        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();

    }
}
