package io.github.jeffersonLucass.arquiteturaspring.montadora.api;

import io.github.jeffersonLucass.arquiteturaspring.montadora.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carros")
public class TesteFabricaController {
    //UTILIZO ESSA ANNOTATION PARA INJETAR  A INSTANCIA DE MOTOR DA MONTADORACONFIGURATION.
    //UTILIZO QUALIFIER PARA IDENTIFICAR QUAL CONFIGURATION DO MOTOR EU QUERO UTILIZAR.
    @Autowired
    @Qualifier("motorTurbo")
    private Motor motor;


    @PostMapping
    public CarroStatus ligarCarro(@RequestBody Chave chave){
        var carro = new HondaHRV(motor);
        return carro.darIgnicao(chave);
    }



}
