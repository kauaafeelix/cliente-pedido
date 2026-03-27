package com.weg.centroweg.cliente_pedido.application.controller;

import com.weg.centroweg.cliente_pedido.application.dto.pedido.request.PedidoDescricaoRequestDto;
import com.weg.centroweg.cliente_pedido.application.dto.pedido.request.PedidoRequestDto;
import com.weg.centroweg.cliente_pedido.application.dto.pedido.response.PedidoResponseDto;
import com.weg.centroweg.cliente_pedido.application.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoResponseDto> save (@RequestBody PedidoRequestDto request){

        PedidoResponseDto response = pedidoService.criarPedido(request);
        return ResponseEntity.status(201).body(response);


    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDto> findById (@PathVariable Long id){

        PedidoResponseDto response = pedidoService.buscarPedidoPorId(id);
        return ResponseEntity.ok(response);

    }

     @GetMapping("/{id}/descricao")
     public ResponseEntity<PedidoResponseDto> findByDescricao (@PathVariable Long id, @RequestBody PedidoDescricaoRequestDto request){

        PedidoResponseDto response = pedidoService.buscarPedidoPorDescricao(id, request);
        return ResponseEntity.ok(response);
    }
}
