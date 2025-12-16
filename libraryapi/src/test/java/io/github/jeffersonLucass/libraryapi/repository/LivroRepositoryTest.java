package io.github.jeffersonLucass.libraryapi.repository;

import io.github.jeffersonLucass.libraryapi.model.Autor;
import io.github.jeffersonLucass.libraryapi.model.GeneroLivro;
import io.github.jeffersonLucass.libraryapi.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@SpringBootTest
class LivroRepositoryTest {

    @Autowired
    LivroRepository repository;

    @Autowired
    AutorRepository autorRepository;


    @Test
    void salvarTest(){
        Livro livro = new Livro();
        livro.setIsbn("90887-84874");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setGenero(GeneroLivro.FICCAO);
        livro.setDataPublicacao(LocalDate.of(2000,2,21));
        livro.setTitulo("UFO");

        Autor autor = autorRepository
                .findById(UUID.fromString("14ee33ef-d9bd-42c6-9c37-12dedd6cc5e7"))
                .orElse(null);

        livro.setAutor(autor);
        repository.save(livro);

    }

    @Test
    void salvarCascadeTest(){
        Livro livro = new Livro();
        livro.setIsbn("90888-84874");
        livro.setPreco(BigDecimal.valueOf(200));
        livro.setGenero(GeneroLivro.FICCAO);
        livro.setDataPublicacao(LocalDate.of(2000,2,21));
        livro.setTitulo("Terceiro Livro");

        Autor autor = new Autor();
        autor.setNome("Maria");
        autor.setNacionalidade("Brasileira");
        autor.setDataNascimento(LocalDate.of(1960,1,31));

        livro.setAutor(autor);
        repository.save(livro);

    }

    @Test
    void atualizarAutorDoLivro(){
        UUID id = UUID.fromString("c5b837fc-7c08-4c19-9613-f5f82b375176");
        var livroParaAtualizar = repository.findById(id).orElse(null);

        UUID IdAutor = UUID.fromString("14ee33ef-d9bd-42c6-9c37-12dedd6cc5e7");
        Autor lucas = autorRepository.findById(IdAutor).orElse(null);

        livroParaAtualizar.setAutor(lucas);

        repository.save(livroParaAtualizar);


    }

    //Ao deletar um livro o hibernate tenta deletar o Autor vinculado a esse livro, o banco bloqueou pq outros livros utilizam esse autor
    @Test
    void deletar(){
        UUID id = UUID.fromString("83d074e8-5989-42b3-96ad-4bf736d5c8cf");
        repository.deleteById(id);
    }

    @Test
    void deletarCascade(){
        UUID id = UUID.fromString("c5b837fc-7c08-4c19-9613-f5f82b375176");
        repository.deleteById(id);
    }




}