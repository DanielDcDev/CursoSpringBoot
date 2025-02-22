package com.LibraryApi.repository;

import com.LibraryApi.model.Autor;
import com.LibraryApi.model.GeneroLivro;
import com.LibraryApi.model.Livro;
import jakarta.transaction.Transactional;
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
/* nao esta funcionando
    @Test
    public void salvarAutorELivroTest(){

        Livro livro = new Livro();
        livro .setIsbn("90887-22274");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setGenero(GeneroLivro.FICCAO);
        livro.setTitulo("Terceiro Livro");
        livro.setDataPublicacao(LocalDate.of(1980,1,2));

        Autor autor = new Autor();
        autor.setNome("Jose ");
        autor.setNacionalidade("Escandinavo");
        autor.setDataNascimento(LocalDate.of(1990,1,31));

        autorRepository.save(autor);

        livro.setAutor(autor);

        repository.save(livro);
    }

 */
//so utilizar em projetos pessoais, necessario salvar separadamente.
    @Test
    void salvarCascadeTest(){

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

    @Test
    void AtualizarAutorDoLivro(){
        UUID id =UUID.fromString("1f15dcdb-15ee-47cc-abc2-18b9288cca44");
         var livroParaAtualizar = repository.findById(id)
                 .orElse(null);

        UUID autorId= UUID.fromString("54a620e3-4d86-45a0-bd3b-cda0a365b241");
        Autor maria =autorRepository.findById((autorId)).orElse(null);

        livroParaAtualizar.setAutor(maria);

        repository.save(livroParaAtualizar);
    }

    @Test
    void deletar(){
        UUID id = UUID.fromString("1f15dcdb-15ee-47cc-abc2-18b9288cca44");
        repository.deleteById(id);
    }
    @Test
    void deletarComCascata(){
        UUID id = UUID.fromString("1f15dcdb-15ee-47cc-abc2-18b9288cca44");
        repository.deleteById(id);
    }

    @Transactional
    @Test
    void BuscarLivroTest(){
        UUID id = UUID.fromString("1f15dcdb-15ee-47cc-abc2-18b9288cca44");
        Livro livro = repository.findById(id).orElse(null);
        System.out.println("Livro");
        System.out.println(livro.getTitulo());
        System.out.println("Autor");
        System.out.println(livro.getAutor().getNome());
    }

}
