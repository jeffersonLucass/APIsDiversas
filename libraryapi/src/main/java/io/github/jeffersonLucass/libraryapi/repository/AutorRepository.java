package io.github.jeffersonLucass.libraryapi.repository;

import io.github.jeffersonLucass.libraryapi.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;

public interface AutorRepository extends JpaRepository<Autor, UUID> {
    List<Autor> findByNomeIgnoreCaseAndNacionalidadeIgnoreCase(String nome, String nacionalidade);
    List<Autor> findByNomeIgnoreCase(String nome);
    List<Autor> findByNacionalidadeIgnoreCase(String nacionalidade);

    Optional<Autor> findByNomeAndDataNascimentoAndNacionalidade(String nome, LocalDate dataNascimento, String nacionalidade);

}

