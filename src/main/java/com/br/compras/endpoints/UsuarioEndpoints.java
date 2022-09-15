package com.br.compras.endpoints;

import java.util.List;
import org.slf4j.Logger;
import java.util.Optional;
import javax.validation.Valid;
import org.slf4j.LoggerFactory;
import com.br.compras.models.Usuario;
import org.springframework.http.HttpStatus;
import com.br.compras.service.UsuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@Tag(name = "Usuário")
public class UsuarioEndpoints {

    @Autowired
    UsuarioService usuarioService;

    Logger logger = LoggerFactory.getLogger(UsuarioEndpoints.class);

    @RequestMapping(path = "/usuario", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Usuario>> getUsuarios() {
        logger.info("GET /usuario");
        List<Usuario> usuarios = usuarioService.getUsuarios();
        return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
    }

    @RequestMapping(path = "/usuario/{email}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Usuario>> getUsuario(@PathVariable String email) {
        logger.info("GET /usuario/" + email);
        Optional<Usuario> usuario = usuarioService.getUsuario(email);
        return new ResponseEntity<Optional<Usuario>>(usuario, HttpStatus.OK);
    }

    @RequestMapping(path = "/usuario", method = RequestMethod.POST)
    public ResponseEntity<String> newUsuario(@RequestBody @Valid Usuario usuario) {
        logger.info("POST /usuario");
        if (usuarioService.newUsuario(usuario)) {
            return new ResponseEntity<String>("Usuário criado com sucesso.", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<String>("Não foi possível criar o usuário.", HttpStatus.BAD_REQUEST);
        }
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(path = "/usuario", method = RequestMethod.PUT)
    public ResponseEntity<String> setUsuario(@RequestBody @Valid Usuario usuario) {
        logger.info("PUT /usuario");
        if (usuarioService.setUsuario(usuario)) {
            return new ResponseEntity<String>("Usuário atualizado com sucesso.", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<String>("Não foi possível atualizar o usuário.", HttpStatus.BAD_REQUEST);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/usuario/{email}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delUsuario(@PathVariable String email) {
        logger.info("DELETE /usuario/" + email);
        if (usuarioService.delUsuario(email)) {
            return new ResponseEntity<String>("Usuário excluído com sucesso!", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Não foi possível excluir o usuário.", HttpStatus.BAD_REQUEST);
        }
    }

}
