package com.br.compras.models;

import java.math.BigDecimal;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "Pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Produto")
    private long produto;

    @Column(name = "Preco")
    private BigDecimal preco;

    @Column(name = "Quantidade")
    private int quantidade;

    public Pedido(long id, long produto, String preco, int quantidade) {
        this.id = id;
        this.produto = produto;
        this.preco = new BigDecimal(preco);
        this.quantidade = quantidade;
    }

    public Pedido(long produto, String preco, int quantidade) {
        this.produto = produto;
        this.preco = new BigDecimal(preco);
        this.quantidade = quantidade;
    }

    public Pedido() {
    }

    public long getId() {
        return id;
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
