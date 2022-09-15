package com.br.compras.endpoints;

import java.util.List;
import org.slf4j.Logger;
import java.util.Optional;
import javax.validation.Valid;
import org.slf4j.LoggerFactory;
import com.br.compras.dto.PedidoDto;
import com.br.compras.models.Pedido;
import org.springframework.http.HttpStatus;
import com.br.compras.service.PedidoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@Tag(name = "Pedido")
public class PedidoEndpoints {

    @Autowired
    PedidoService pedidoService;

    Logger logger = LoggerFactory.getLogger(Pedido.class);

    @RequestMapping(path = "/pedido", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Pedido>> getPedidos() {
        logger.info("GET /pedido");
        List<Pedido> pedidos = pedidoService.getPedidos();
        return new ResponseEntity<List<Pedido>>(pedidos, HttpStatus.OK);
    }

    @RequestMapping(path = "/pedido/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Pedido>> getPedido(@PathVariable long id) {
        logger.info("GET /pedido/" + id);
        Optional<Pedido> pedido = pedidoService.getPedido(id);
        return new ResponseEntity<Optional<Pedido>>(pedido, HttpStatus.OK);
    }

    @RequestMapping(path = "/pedido", method = RequestMethod.POST)
    public ResponseEntity<String> newPedido(@RequestBody @Valid PedidoDto pedidoDto) {
        logger.info("POST /pedido");
        if (pedidoService.newPedido(pedidoDto)) {
            return new ResponseEntity<String>("Pedido criado com sucesso.", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<String>("Não foi possível criar o pedido.", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/pedido", method = RequestMethod.PUT)
    public ResponseEntity<String> setPedido(@RequestBody @Valid Pedido pedido) {
        logger.info("PUT /pedido");
        if (pedidoService.setPedido(pedido)) {
            return new ResponseEntity<String>("pedido atualizado com sucesso.", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<String>("Não foi possível atualizar o pedido.", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/pedido/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delPedido(@PathVariable long id) {
        logger.info("DELETE /pedido/" + id);
        if (pedidoService.delPedido(id)) {
            return new ResponseEntity<String>("Pedido excluído com sucesso!", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Não foi possível excluir o pedido.", HttpStatus.BAD_REQUEST);
        }
    }

}
