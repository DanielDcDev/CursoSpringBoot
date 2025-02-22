package com.LibraryApi.repository;

import com.LibraryApi.model.Autor;
import com.LibraryApi.model.GeneroLivro;
import com.LibraryApi.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class AutorRepositoryTest {
    @Autowired
    AutorRepository repository;
    @Autowired
    LivroRepository livroRepository;

    @Test
    public void salvarTest() {
        Autor autor = new Autor();

        autor.setNome("Maria");
        autor.setNacionalidade("Brasileira");
        autor.setDataNascimento(LocalDate.of(1969,1,31));
        var autorSalvo = repository.save(autor);
        System.out.println("Autor salvo: "+ autorSalvo);
    }
    public void atualizarTest(){
        var id = UUID.fromString("54a620e3-4d86-45a0-bd3b-cda0a365b241");

        Optional<Autor> possivelAutor = repository.findById(id);
        if(possivelAutor.isPresent()){
            Autor autorEncontrado = possivelAutor.get();
            System.out.println("Dados do autor: ");
            System.out.println(autorEncontrado);

            autorEncontrado.setDataNascimento(LocalDate.of(1960, 1, 30));
            repository.save(autorEncontrado);
        }
    }
 @Test
    public void listarTest(){
        List<Autor> lista = repository.findAll();
        lista.forEach(System.out::println);

    }
    @Test
    public void countTest(){
        System.out.println("Contagem de autores" + repository.count());
    }
    @Test
    public void deletePorIdTest(){

        var id = UUID.fromString("e6b07976-a8c2-406e-af2c-914689e21d321");
        repository.deleteById(id);
    }
    public void deleteTest(){
        var id = UUID.fromString("b68fe998-bbae-44c9-91bd-fab3bdc0675c");
        var maria = repository.findById(id).get();
        repository.deleteById(id);
    }

    @Test
    void SalvarAutorComLivros(){
        Autor autor = new Autor();
        autor.setNome("Mario");
        autor.setNacionalidade("Bulgaro");
        autor.setDataNascimento(LocalDate.of(1998,10,3));

        Livro livro = new Livro();
        livro .setIsbn("99998-84874");
        livro.setPreco(BigDecimal.valueOf(120));
        livro.setGenero(GeneroLivro.Misterio);
        livro.setTitulo("A coisa");
        livro.setDataPublicacao(LocalDate.of(2020,1,20));
        livro.setAutor(autor);

        Livro livro2 = new Livro();
        livro2.setIsbn("99998-84874");
        livro2.setPreco(BigDecimal.valueOf(120));
        livro2.setGenero(GeneroLivro.Misterio);
        livro2.setTitulo("A coisa da morte");
        livro2.setDataPublicacao(LocalDate.of(2022,2,22));

        autor.setLivros(new ArrayList<>());
        autor.getLivros().add(livro);
        autor.getLivros().add(livro2);

        repository.save(autor);

      


    }
}
