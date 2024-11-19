package com.seb.floreriaeleclipse.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "flor-id", referencedColumnName = "id")
    private Flor flor;
    private int cantidad;
    private BigDecimal subtotal;

    @ManyToOne
    @JoinColumn(name = "pedido-id", referencedColumnName = "id")
    private Pedido pedido;

    public void calcularSubtotal() {
        subtotal = flor.getPrecio().multiply(new BigDecimal(cantidad));
    }
}
