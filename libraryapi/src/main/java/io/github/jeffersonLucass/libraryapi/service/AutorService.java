package io.github.jeffersonLucass.libraryapi.service;

import io.github.jeffersonLucass.libraryapi.model.Autor;
import io.github.jeffersonLucass.libraryapi.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
//A CLASSE DE SERVICE TRATA DIRETAMENTE COM A ENTIDADE AUTOR, LOGO NÃO DEVE SER UTILIZADO DTO NESSA CAMADA.
@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public Autor salvar(Autor autor){
        return autorRepository.save(autor);
    }


    public Optional<Autor> obterPorId(UUID id) {
        return autorRepository.findById(id);

    }

    public void deletar(Autor autor) {

        autorRepository.delete(autor);

    }

    public List<Autor> pesquisa(String nome, String nacionalidade) {
        if (nome != null && nacionalidade != null) {
            return autorRepository.findByNomeIgnoreCaseAndNacionalidadeIgnoreCase(nome, nacionalidade);
        } else if (nome != null) {
            return autorRepository.findByNomeIgnoreCase(nome);
        } else if (nacionalidade != null) {
            return autorRepository.findByNacionalidadeIgnoreCase(nacionalidade);
        } else {
            return autorRepository.findAll();
        }
    }


}
