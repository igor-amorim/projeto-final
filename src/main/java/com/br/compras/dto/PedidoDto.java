package com.br.compras.dto;

import java.math.BigDecimal;

public class PedidoDto {

    private long produto;
    private BigDecimal preco;
    private int quantidade;

    public PedidoDto(long produto, String preco, int quantidade) {
        this.produto = produto;
        this.preco = new BigDecimal(preco);
        this.quantidade = quantidade;
    }

    public long getProduto() {
        return produto;
    }

    public void setProduto(long produto) {
        this.produto = produto;
    }

    public String getPreco() {
        return preco.toString();
    }

    public void setPreco(String preco) {
        this.preco = new BigDecimal(preco);
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
