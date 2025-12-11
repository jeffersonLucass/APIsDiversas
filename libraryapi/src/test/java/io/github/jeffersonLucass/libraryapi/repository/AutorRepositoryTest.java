package io.github.jeffersonLucass.libraryapi.repository;
import io.github.jeffersonLucass.libraryapi.model.Autor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.util.List;
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

    @Test
    public void ListarTest(){
        List<Autor> list = repository.findAll();

        list.forEach(System.out::println);
    }

    @Test
    public void countTest(){
        long count = repository.count();
        System.out.println("Contagem de autores: " + count);
    }

    @Test
    public void deleteporIdTest(){
        var id = UUID.fromString("11ecb97e-f7bf-4863-958d-9e00bd156944");

        repository.deleteById(id);


    }


    @Test
    public void deleteTest(){
        var id = UUID.fromString("eff716f8-9a8e-4210-9117-e3ff6b0f5cf8");
        var maria = repository.findById(id).get();

        repository.delete(maria);


    }




}
