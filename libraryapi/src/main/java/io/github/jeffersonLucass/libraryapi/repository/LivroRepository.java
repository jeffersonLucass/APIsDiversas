package io.github.jeffersonLucass.libraryapi.repository;

import io.github.jeffersonLucass.libraryapi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LivroRepository extends JpaRepository<Livro, UUID> {
}
