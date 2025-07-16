package com.jeffersonLucass.produtosapi.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString(includeFieldNames=true)
public class Produto {

    private String id;
    private String name;
    private String descriptor;
    private Double preco;

}
