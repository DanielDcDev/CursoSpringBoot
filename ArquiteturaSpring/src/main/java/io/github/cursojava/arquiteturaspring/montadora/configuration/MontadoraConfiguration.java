package io.github.cursojava.arquiteturaspring.montadora.configuration;

import io.github.cursojava.arquiteturaspring.montadora.Motor;
import io.github.cursojava.arquiteturaspring.montadora.TipoMotor;
import io.github.cursojava.arquiteturaspring.montadora.api.Aspirado;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MontadoraConfiguration {

    @Aspirado
    @Bean(name ="motorAspirado")
    public Motor motorAspirado(){
        var motor = new Motor();
        motor.setCavalos(120);
        motor.setCilindros(2);
        motor.setModelo("CTPO");
        motor.setLitragem(2.0);
        motor.setTipo(TipoMotor.ASPIRADO);
        return motor;
    }
    @Bean(name ="motorTurbo")
    public Motor motorTurbo(){
        var motor = new Motor();
        motor.setCavalos(180);
        motor.setCilindros(4);
        motor.setModelo("XTPO");
        motor.setLitragem(1.5);
        motor.setTipo(TipoMotor.TURBO);
        return motor;
    }
    @Bean(name ="motorEletrico")
    public Motor motorEletrico(){
        var motor = new Motor();
        motor.setCavalos(110);
        motor.setCilindros(3);
        motor.setModelo("TH-01");
        motor.setLitragem(1.4);
        motor.setTipo(TipoMotor.ELETRICO);
        return motor;
    }
}
