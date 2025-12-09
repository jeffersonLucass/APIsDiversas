package io.github.jeffersonLucass.libraryapi;

import io.github.jeffersonLucass.libraryapi.model.Autor;
import io.github.jeffersonLucass.libraryapi.repository.AutorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class LibraryapiApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(LibraryapiApplication.class, args);
		AutorRepository Repository = context.getBean(AutorRepository.class);

		exemploSalvarRegistro(Repository);

	}


	public static void exemploSalvarRegistro(AutorRepository autorRepository) {
		Autor autor = new Autor();
		autor.setNome("Jefferson Lucass");
		autor.setNacionalidade("brasileira");
		autor.setDataNascimento(LocalDate.of(1950,1,31));

		var autorSalvo = autorRepository.save(autor);

		System.out.println("Autor Salvo: " + autorSalvo);


	}




}
