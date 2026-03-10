package io.github.jeffersonLucass.libraryapi.controller;

import io.github.jeffersonLucass.libraryapi.controller.dto.AutorDTO;
import io.github.jeffersonLucass.libraryapi.model.Autor;
import io.github.jeffersonLucass.libraryapi.service.AutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/autores")
// http://localhost:8080/autores
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService){
        this.autorService = autorService;
    }



    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody AutorDTO autorDTO) {
        var autorEntidade = autorDTO.mapearParaAutor();
        autorService.salvar(autorEntidade);

        URI location =ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(autorEntidade.getId()).toUri();

        return ResponseEntity.created(location).build();
    }



}
