package io.github.jeffersonLucass.libraryapi.repository;
import io.github.jeffersonLucass.libraryapi.model.Autor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;


@SpringBootTest
public class AutorRepositoryTest {

    @Autowired
    AutorRepository repository;

    @Test
    public void salvarTest(){
        Autor autor = new Autor();
        autor.setNome("Lucas");
        autor.setNacionalidade("Europeia");
        autor.setDataNascimento(LocalDate.of(2000,8,25));

        var autorSalvo = repository.save(autor);

        System.out.println("Autor Salvo: " + autorSalvo);
    }

    @Test
    public void AtualizarTest(){
        var id = UUID.fromString("073e9a71-a0f9-4c2c-a03c-3f29f30ac672");

        Optional<Autor> possivelAutor = repository.findById(id);
        //Dentro desse if estou buscando as informações de determinado e printando na tela e realizando uma alteração na data de nascimento e atualizando no banco de dados.
        if (possivelAutor.isPresent()) {
            Autor autorEncontrado = possivelAutor.get();
            System.out.println("Dados do Autor:");
            System.out.println(possivelAutor.get());

            autorEncontrado.setDataNascimento(LocalDate.of(1960,1,30));

            repository.save(autorEncontrado);

        }


    }


}
