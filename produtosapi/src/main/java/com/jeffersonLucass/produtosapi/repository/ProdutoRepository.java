package com.jeffersonLucass.produtosapi.repository;

import com.jeffersonLucass.produtosapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,String>{

}
