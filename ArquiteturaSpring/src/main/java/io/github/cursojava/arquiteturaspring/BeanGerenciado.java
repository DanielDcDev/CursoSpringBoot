package io.github.cursojava.arquiteturaspring;

import io.github.cursojava.arquiteturaspring.todos.TodoEntity;
import io.github.cursojava.arquiteturaspring.todos.TodoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanGerenciado {


        @Autowired
        private TodoValidator validator;
        //Dessa forma nao traz obrigatoriedade nem opcionalidade, ele sempre vem com a instancia de forma alguma.
        //Mais facil
        @Autowired
        public BeanGerenciado(TodoValidator validator) {
            this.validator = validator;
        }
        //Melhor forma de fazer essa injecao de dependencia e desta forma com construtor, pois e uma forma mais comum e que nos tira problemas no futuro.
        //Mais recomendada

        public void utilizar(){
            var todo = new TodoEntity();
            validator.validar(todo);
        }
        @Autowired
        public void setValidator(TodoValidator validator){
            this.validator = validator;
        }


    }

