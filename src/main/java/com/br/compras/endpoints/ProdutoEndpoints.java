package com.br.compras.endpoints;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import com.br.compras.dto.ProdutoDto;
import com.br.compras.models.Produto;
import org.springframework.http.HttpStatus;
import com.br.compras.service.ProdutoService;
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
@Tag(name = "Produto")
public class ProdutoEndpoints {

    @Autowired
    ProdutoService produtoService;

    @RequestMapping(path = "/produto", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Produto>> getProdutos() {
        List<Produto> produtos = produtoService.getProdutos();
        return new ResponseEntity<List<Produto>>(produtos, HttpStatus.OK);
    }

    @RequestMapping(path = "/produto/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Produto>> getProduto(@PathVariable long id) {
        Optional<Produto> produto = produtoService.getProduto(id);
        return new ResponseEntity<Optional<Produto>>(produto, HttpStatus.OK);
    }

    @RequestMapping(path = "/produto", method = RequestMethod.POST)
    public ResponseEntity<String> newProduto(@RequestBody @Valid ProdutoDto produtoDto) {
        if (produtoService.newProduto(produtoDto)) {
            return new ResponseEntity<String>("Produto criado com sucesso.", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<String>("Não foi possível criar o produto.", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/produto", method = RequestMethod.PUT)
    public ResponseEntity<String> setProduto(@RequestBody @Valid Produto produto) {
        if (produtoService.setProduto(produto)) {
            return new ResponseEntity<String>("Produto atualizado com sucesso.", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<String>("Não foi possível atualizar o produto.", HttpStatus.BAD_REQUEST);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/produto/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delProduto(@PathVariable long id) {
        if (produtoService.delProduto(id)) {
            return new ResponseEntity<String>("Produto excluído com sucesso!", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Não foi possível excluir o produto.", HttpStatus.BAD_REQUEST);
        }
    }

}
