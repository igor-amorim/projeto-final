package com.br.compras.models;

import lombok.Data;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @Column(name = "Email")
    private String email;

    @Column(name = "Senha")
    private String senha;

}
