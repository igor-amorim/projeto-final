package com.br.compras.service;

import java.util.List;
import java.util.Optional;
import com.br.compras.dto.ProdutoDto;
import com.br.compras.models.Produto;

public interface ProdutoService {

    List<Produto> getProdutos();

    Optional<Produto> getProduto(long id);

    boolean newProduto(ProdutoDto produtoDto);

    boolean setProduto(Produto produto);

    boolean delProduto(long id);

}
