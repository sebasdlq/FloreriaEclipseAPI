package com.seb.floreriaeleclipse.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "atributos_flores",
            joinColumns = @JoinColumn(name = "flor_id"),
            inverseJoinColumns = @JoinColumn(name = "atributo_id"))
    List<Atributos> atributos;
}
