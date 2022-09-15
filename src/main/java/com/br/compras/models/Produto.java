package com.br.compras.models;

import java.math.BigDecimal;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "Produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Nome")
    private String nome;

    @Column(name = "Preco")
    private BigDecimal preco;

    public Produto(long id, String nome, String preco) {
        this.id = id;
        this.nome = nome;
        this.preco = new BigDecimal(preco);
    }

    public Produto(String nome, String preco) {
        this.nome = nome;
        this.preco = new BigDecimal(preco);
    }

    public long getId() {
        return id;
    }

    public Produto() {
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
