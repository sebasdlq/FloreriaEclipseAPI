package com.seb.floreriaeleclipse.repositories;

import com.seb.floreriaeleclipse.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
