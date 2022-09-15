package com.br.compras.service.impl;

import java.util.List;
import java.util.Optional;
import com.br.compras.dao.PedidoDao;
import com.br.compras.dto.PedidoDto;
import com.br.compras.models.Pedido;
import com.br.compras.service.PedidoService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    PedidoDao pedidoDao;

    @Override
    public List<Pedido> getPedidos() {
        return pedidoDao.findAll();
    }

    @Override
    public Optional<Pedido> getPedido(long id) {
        return pedidoDao.findById(id);
    }

    @Override
    public boolean newPedido(PedidoDto pedidoDto) {
        try {
            Pedido pedido = new Pedido(pedidoDto.getProduto(), pedidoDto.getPreco(), pedidoDto.getQuantidade());
            pedidoDao.save(pedido);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean setPedido(Pedido pedido) {
        try {
            pedidoDao.save(pedido);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delPedido(long id) {
        try {
            pedidoDao.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
