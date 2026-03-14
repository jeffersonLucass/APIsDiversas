package io.github.jeffersonLucass.libraryapi.controller;

import io.github.jeffersonLucass.libraryapi.controller.dto.AutorDTO;
import io.github.jeffersonLucass.libraryapi.model.Autor;
import io.github.jeffersonLucass.libraryapi.service.AutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

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

    @GetMapping("{id}")
    public ResponseEntity<AutorDTO> obterDetalhesAutor(@PathVariable("id") String id){
            var idAutor = UUID.fromString(id);
            Optional<Autor> autorOptional = autorService.obterPorId(idAutor);
            if(autorOptional.isPresent()){
                Autor autor = autorOptional.get();
                AutorDTO dto = new AutorDTO(autor.getId(), autor.getNome(), autor.getDataNascimento(), autor.getNacionalidade());
                return ResponseEntity.ok(dto);
            }

            return ResponseEntity.notFound().build();

    }


}
