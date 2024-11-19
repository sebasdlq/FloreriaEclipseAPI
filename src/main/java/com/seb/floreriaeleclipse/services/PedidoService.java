package com.seb.floreriaeleclipse.services;

import com.seb.floreriaeleclipse.dtos.PedidoDto;

import java.util.List;

public interface PedidoService {
    PedidoDto create(PedidoDto pedidoDto);
    List<PedidoDto> readAll();
    PedidoDto readById(Long id);
    PedidoDto update(PedidoDto pedidoDto);
    void delete(Long id);
}
