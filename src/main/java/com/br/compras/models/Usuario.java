package com.br.compras.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @Column(name = "Email")
    private String email;

    @Column(name = "Senha")
    private String senha;

    @Enumerated(EnumType.STRING)
    private Perfil perfil;

}
