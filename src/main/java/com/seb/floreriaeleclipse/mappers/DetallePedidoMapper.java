package com.seb.floreriaeleclipse.mappers;

import com.seb.floreriaeleclipse.dtos.DetallePedidoDto;
import com.seb.floreriaeleclipse.entities.DetallePedido;

public class DetallePedidoMapper {
    public static DetallePedido dtoToEntity(DetallePedidoDto dto) {
        DetallePedido detallePedido = new DetallePedido();
        detallePedido.setId(detallePedido.getId());
        detallePedido.setCantidad(dto.getCantidad());
        detallePedido.setSubtotal(dto.getSubTotal());
        return detallePedido;
    }
    public static DetallePedidoDto entityToDto(DetallePedido detallePedido) {
        return new DetallePedidoDto(
          detallePedido.getId(),
          detallePedido.getFlor().getId(),
          detallePedido.getCantidad(),
          detallePedido.getSubtotal(),
          detallePedido.getPedido().getId()
        );
    }
}
