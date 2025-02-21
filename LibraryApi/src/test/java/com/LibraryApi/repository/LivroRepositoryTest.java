package com.LibraryApi.repository;

import com.LibraryApi.model.Autor;
import com.LibraryApi.model.GeneroLivro;
import com.LibraryApi.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@SpringBootTest
public class LivroRepositoryTest {

    @Autowired
    LivroRepository repository;
    @Autowired
    AutorRepository autorRepository;
    //forma de salvar sem ser cascata
    @Test
    void salvarTest(){

        Livro livro = new Livro();
        livro .setIsbn("90887-84874");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setGenero(GeneroLivro.FICCAO);
        livro.setTitulo("UFO");
        livro.setDataPublicacao(LocalDate.of(1980,1,2));

        Autor autor = autorRepository
                .findById(UUID.fromString("54a620e3-4d86-45a0-bd3b-cda0a365b241"))
                .orElse(null);



        livro.setAutor(new Autor());

        repository.save(livro);
    }
    @Test
    public void salvarCascadeTest(){

        Livro livro = new Livro();
        livro .setIsbn("90887-84874");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setGenero(GeneroLivro.FICCAO);
        livro.setTitulo("UFO");
        livro.setDataPublicacao(LocalDate.of(1980,1,2));

        Autor autor = new Autor();
        autor.setNome("Joao");
        autor.setNacionalidade("Brasileira");
        autor.setDataNascimento(LocalDate.of(1980,1,31));

        livro.setAutor(autor);

        repository.save(livro);
    }

}
