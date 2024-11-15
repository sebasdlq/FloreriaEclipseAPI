package com.seb.floreriaeleclipse.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;


@Data
@AllArgsConstructor @NoArgsConstructor
public class PedidoDto {
    private Long id;
    private String codigo;
    private BigDecimal total;

    private List<DetallePedidoDto> detalle;
}
