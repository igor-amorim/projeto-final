package com.br.compras.dao;

import com.br.compras.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoDao extends JpaRepository<Pedido, Long> {

}
