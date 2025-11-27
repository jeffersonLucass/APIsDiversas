package io.github.jeffersonLucass.libraryapi.repository;

import io.github.jeffersonLucass.libraryapi.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AutorRepository extends JpaRepository<Autor, UUID> {
}
