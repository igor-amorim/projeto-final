package com.br.compras.dto;

import java.math.BigDecimal;

public class ProdutoDto {

    private String nome;
    private BigDecimal preco;

    public ProdutoDto(String nome, String preco) {
        this.nome = nome;
        this.preco = new BigDecimal(preco);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco.toString();
    }

    public void setPreco(String preco) {
        this.preco = new BigDecimal(preco);
    }

}
