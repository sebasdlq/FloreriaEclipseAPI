package com.seb.floreriaeleclipse.mappers;

import com.seb.floreriaeleclipse.dtos.DetallePedidoDto;
import com.seb.floreriaeleclipse.dtos.PedidoDto;
import com.seb.floreriaeleclipse.entities.DetallePedido;
import com.seb.floreriaeleclipse.entities.Pedido;

import java.util.stream.Collectors;

public class PedidoMapper {
    public static PedidoDto pedidoToPedidoDto(Pedido pedido) {
        PedidoDto pedidoDto = new PedidoDto();
        pedidoDto.setId(pedido.getId());
        pedidoDto.setCodigo(pedido.getCodigo());
        pedidoDto.setTotal(pedido.getTotal());

        pedidoDto.setDetalle(
                pedido.getDetallePedidos().stream().map(
                        DetallePedidoMapper::entityToDto
                ).collect(Collectors.toList())
        );
        return pedidoDto;
    }

    public static Pedido pedidoDtoToPedido(PedidoDto pedidoDto) {
        Pedido pedido = new Pedido();
        pedido.setId(pedidoDto.getId());
        pedido.setCodigo(pedidoDto.getCodigo());
        pedido.setTotal(pedidoDto.getTotal());

        pedido.setDetallePedidos(
                pedidoDto.getDetalle().stream().map(
                        dtoDetalle -> {
                            DetallePedido detallePedido = DetallePedidoMapper.dtoToEntity(dtoDetalle);
                            detallePedido.setPedido(pedido);

                            return detallePedido;
                        }
                ).collect(Collectors.toList())
        );
        return pedido;
    }
}
