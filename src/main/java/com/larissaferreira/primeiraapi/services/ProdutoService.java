package com.larissaferreira.primeiraapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.larissaferreira.primeiraapi.models.Produto;
import com.larissaferreira.primeiraapi.repositories.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public Produto create(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Transactional
    public Produto update(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Optional<Produto> findById(Long id) {
        return produtoRepository.findById(id);
    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public void delete(Long id) {
        produtoRepository.deleteById(id);

    }


}
    





