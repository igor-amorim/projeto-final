package com.br.compras.dao;

import com.br.compras.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, String> {

}
