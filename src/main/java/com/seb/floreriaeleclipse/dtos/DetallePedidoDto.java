package com.seb.floreriaeleclipse.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor @NoArgsConstructor
public class DetallePedidoDto {
    private Long id;
    private Long florId;
    private int cantidad;
    private BigDecimal subTotal;
    private Long pedidoId;
}
