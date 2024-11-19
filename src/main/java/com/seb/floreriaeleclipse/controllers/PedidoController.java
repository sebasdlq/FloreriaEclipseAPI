package com.seb.floreriaeleclipse.controllers;

import com.seb.floreriaeleclipse.dtos.PedidoDto;
import com.seb.floreriaeleclipse.services.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("api/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;
    @PostMapping
    ResponseEntity <PedidoDto> create(@RequestBody PedidoDto pedidoDto) {
        return ResponseEntity.ok(pedidoService.create(pedidoDto));
    }
    @GetMapping
    ResponseEntity<List<PedidoDto>> getAll() {
        return ResponseEntity.ok(pedidoService.readAll());
    }
    @GetMapping("{id}")
    ResponseEntity<PedidoDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoService.readById(id));
    }
    @PutMapping
    ResponseEntity<PedidoDto> update(@RequestBody PedidoDto pedidoDto) {
        return ResponseEntity.ok(pedidoService.update(pedidoDto));
    }
    @DeleteMapping("{id}")
    ResponseEntity<String> delete(@PathVariable Long id) {
        pedidoService.delete(id);
        return ResponseEntity.ok("pedido eliminado " + id);
    }

}
