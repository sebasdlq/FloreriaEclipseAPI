package com.seb.floreriaeleclipse.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor

public class Flor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private String imagen;
    private BigDecimal precio;
    private int stock;

    @OneToOne
    @JoinColumn(name = "origen-id", referencedColumnName = "id")
    Lugar lugarDeOrigen;
}
