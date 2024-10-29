package com.larissaferreira.primeiraapi.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.larissaferreira.primeiraapi.models.Produto;
import com.larissaferreira.primeiraapi.services.ProdutoService;

@RestController
@RequestMapping("/produto/")
@Validated
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;


    @GetMapping("/{id}")
    public ResponseEntity<Produto>findById(@PathVariable Long id)  {

        Produto produto = produtoService.findById(id).orElseGet(null);
        return ResponseEntity.ok().body(produto);

    }

    @GetMapping
    public ResponseEntity<List<Produto>> buscarTodos() {
        List<Produto> listaProdutos = produtoService.findAll();
        return ResponseEntity.ok().body(listaProdutos);
    }

    @PostMapping
    @Validated
    public ResponseEntity<Void> create(@Valid @RequestBody Produto produto) {
        this.produtoService.create(produto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    @Validated(UpdateProduto.class)
    public ResponseEntity<Void> update(@PathVariable Long id, @Valid @RequestBody Produto produto) {
        produto.setId(id);
        this.produtoService.update(produto);
        return ResponseEntity.noContent().build();

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.produtoService.delete(id);
        return ResponseEntity.noContent().build();

    }
}



