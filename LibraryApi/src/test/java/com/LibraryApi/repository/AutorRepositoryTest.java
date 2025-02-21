package com.LibraryApi.repository;

import com.LibraryApi.model.Autor;
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
}
