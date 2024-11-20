package com.seb.floreriaeleclipse.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private BigDecimal total;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pedido", cascade = CascadeType.ALL)
    List<DetallePedido> detallePedidos;

    public void calcularTotal(){
        total = BigDecimal.ZERO;
        for(DetallePedido detallePedido : detallePedidos){
            total = total.add(detallePedido.getSubtotal());
        }
    }
}
