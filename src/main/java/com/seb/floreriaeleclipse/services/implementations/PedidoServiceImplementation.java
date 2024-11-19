package com.seb.floreriaeleclipse.services.implementations;

import com.seb.floreriaeleclipse.dtos.PedidoDto;
import com.seb.floreriaeleclipse.entities.Flor;
import com.seb.floreriaeleclipse.entities.Pedido;
import com.seb.floreriaeleclipse.exceptions.ResourceNotFoundException;
import com.seb.floreriaeleclipse.mappers.PedidoMapper;
import com.seb.floreriaeleclipse.repositories.DetallePedidoRepository;
import com.seb.floreriaeleclipse.repositories.FlorRepository;
import com.seb.floreriaeleclipse.repositories.PedidoRepository;
import com.seb.floreriaeleclipse.services.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PedidoServiceImplementation implements PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;
    @Autowired
    private FlorRepository florRepository;

    @Override
    public PedidoDto create(PedidoDto pedidoDto) {
        Pedido newPedido = PedidoMapper.pedidoDtoToPedido(pedidoDto);
        for (int i = 0; i < pedidoDto.getDetalle().size(); i++) {
            Flor flor = florRepository.findById(pedidoDto.getDetalle().get(i).getId()).orElseThrow(
                    () -> new ResourceNotFoundException("Flor no encontrado " )
            );
            newPedido.getDetallePedidos().get(i).setFlor(flor);
            newPedido.getDetallePedidos().get(i).calcularSubtotal();
        }
        newPedido.calcularTotal();
        Pedido savedPedido = pedidoRepository.save(newPedido);
        return PedidoMapper.pedidoToPedidoDto(savedPedido);
    }

    @Override
    public List<PedidoDto> readAll() {
        return pedidoRepository.findAll().stream().map(
                PedidoMapper::pedidoToPedidoDto
        ).collect(Collectors.toList());
    }

    @Override
    public PedidoDto readById(Long id) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Pedido no encontrado id: " + id)
        );

        return PedidoMapper.pedidoToPedidoDto(pedido);
    }

    @Override
    public PedidoDto update(PedidoDto pedidoDto) {
        Pedido pedido = pedidoRepository.findById(pedidoDto.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Pedido no encontrado id: " + pedidoDto.getId())
        );
        pedido.setCodigo(pedidoDto.getCodigo());
        for (int i = 0; i < pedidoDto.getDetalle().size(); i++) {
            Flor flor = florRepository.findById(pedidoDto.getDetalle().get(i).getId()).orElseThrow(
                    () -> new ResourceNotFoundException("Flor no encontrado " )
            );
            pedido.getDetallePedidos().get(i).setFlor(flor);
            pedido.getDetallePedidos().get(i).calcularSubtotal();
        }
        pedido.calcularTotal();
        Pedido savedPedido = pedidoRepository.save(pedido);
        return PedidoMapper.pedidoToPedidoDto(savedPedido);
    }

    @Override
    public void delete(Long id) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Pedido no encontrado id: " + id)
        );
        pedidoRepository.delete(pedido);
    }
}
