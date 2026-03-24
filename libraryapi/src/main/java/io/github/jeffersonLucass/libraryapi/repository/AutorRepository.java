package io.github.jeffersonLucass.libraryapi.repository;

import io.github.jeffersonLucass.libraryapi.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AutorRepository extends JpaRepository<Autor, UUID> {
    List<Autor> findByNomeIgnoreCaseAndNacionalidadeIgnoreCase(String nome, String nacionalidade);
    List<Autor> findByNomeIgnoreCase(String nome);
    List<Autor> findByNacionalidadeIgnoreCase(String nacionalidade);
}

