package com.br.compras.service.impl;

import java.util.List;
import java.util.Optional;
import com.br.compras.dao.ProdutoDao;
import com.br.compras.dto.ProdutoDto;
import com.br.compras.models.Produto;
import com.br.compras.service.ProdutoService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    ProdutoDao produtoDao;

    @Override
    public List<Produto> getProdutos() {
        return produtoDao.findAll();
    }

    @Override
    public Optional<Produto> getProduto(long id) {
        return produtoDao.findById(id);
    }

    @Override
    public boolean newProduto(ProdutoDto produtoDto) {
        try {
            Produto produto = new Produto(produtoDto.getNome(), produtoDto.getPreco());
            produtoDao.save(produto);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean setProduto(Produto produto) {
        try {
            produtoDao.save(produto);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delProduto(long id) {
        try {
            produtoDao.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
