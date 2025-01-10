package io.github.cursojava.arquiteturaspring.montadora.api;

import io.github.cursojava.arquiteturaspring.montadora.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carros")
public class testeFabricaController {

    @Autowired//essa anotation nada mais faz do que trazer o motor o arquivo original pra este codigo sem a necessidade de instanciamento.
    @Turbo
    private Motor motor;

    @PostMapping
    public CarroStatus ligarCarro (@RequestBody Chave chave){
        var carro = new HondaHRV(motor);
        return carro.darIgnicao(chave);
    }
}
