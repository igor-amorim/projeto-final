package com.br.compras.service.impl;

import java.util.List;
import java.util.Optional;
import com.br.compras.dao.UsuarioDao;
import com.br.compras.models.Usuario;
import com.br.compras.service.UsuarioService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioDao usuarioDao;

    private PasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Usuario> getUsuarios() {
        return usuarioDao.findAll();
    }

    @Override
    public Optional<Usuario> getUsuario(String email) {
        return usuarioDao.findById(email);
    }

    @Override
    public boolean newUsuario(Usuario usuario) {
        // try {
            // usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
            usuarioDao.save(new Usuario(
                    usuario.getEmail(),
                    passwordEncoder.encode(usuario.getSenha()),
                    usuario.getPerfil()));
            return true;
        // } catch (Exception e) {
        //     return false;
        // }
    }

    @Override
    public boolean setUsuario(Usuario usuario) {
        try {
            usuarioDao.save(usuario);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delUsuario(String email) {
        try {
            usuarioDao.deleteById(email);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
