package com.jeffersonLucass.produtosapi.controller;

import com.jeffersonLucass.produtosapi.model.Produto;
import com.jeffersonLucass.produtosapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }


    @PostMapping
    public Produto Salvar(@RequestBody Produto produto){
        System.out.println("Produto recebido: " +  produto);
        //gera um id aleatorio e transforma ele em uma string.
        var id = UUID.randomUUID().toString();
        produto.setId(id);
        produtoRepository.save(produto);
        return produto;
    }
    //CAMINHO DA URL
    @GetMapping("/{id}")
    public Produto obterporId(@PathVariable("id") String id){

        // Na linha abaixo se o id existir ele ira retorna-lo, caso não exista retornará nulo.
        return produtoRepository.findById(id).orElse(null);

    }

}
