package io.github.jeffersonLucass.libraryapi.validator;

import io.github.jeffersonLucass.libraryapi.Exceptions.RegistroDuplicadoException;
import io.github.jeffersonLucass.libraryapi.controller.dto.AutorDTO;
import io.github.jeffersonLucass.libraryapi.model.Autor;
import io.github.jeffersonLucass.libraryapi.repository.AutorRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AutorValidator {

    private AutorRepository repository;

    public AutorValidator(AutorRepository repository){
        this.repository = repository;
    }

    public void Validar(Autor autor){
        if(existeAutorCadastrado(autor)){
            throw new RegistroDuplicadoException("Autor cadastrado com este registro");
    }
}

    private boolean existeAutorCadastrado(Autor autor){
        Optional<Autor> autorEncontrado =  repository.findByNomeAndDataNascimentoAndNacionalidade(
                autor.getNome(),autor.getDataNascimento(),autor.getNacionalidade()
        );

        if (autor.getId() == null){
            return autorEncontrado.isPresent();
        }

        return !autor.getId().equals(autorEncontrado.get().getId())  && autorEncontrado.isPresent();
    }
}
