package com.larissaferreira.primeiraapi.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.larissaferreira.primeiraapi.models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    
}
