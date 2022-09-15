package com.br.compras.service;

import java.util.List;
import java.util.Optional;
import com.br.compras.dto.PedidoDto;
import com.br.compras.models.Pedido;

public interface PedidoService {

    List<Pedido> getPedidos();

    Optional<Pedido> getPedido(long id);

    boolean newPedido(PedidoDto pedidoDto);

    boolean setPedido(Pedido pedido);

    boolean delPedido(long id);

}
