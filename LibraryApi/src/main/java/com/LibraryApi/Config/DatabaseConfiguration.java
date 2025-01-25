
//configuracao opcional, bom para saber mas tem outras formas de fazer e nao e tao necessario a um baixo nivel de codigo
//para questoes de empresa e perfeito.



package com.LibraryApi.Config;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatabaseConfiguration {

    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.username}")
    String username;
    @Value("${spring.datasource.password}")
    String password;
    @Value("${spring.datasource.driver-class-name}")
    String driver;

    /*
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setDriverClassName(driver);
        return ds;
    }
    */
    @Bean
    public DataSource hikariDataSource(){

        HikariConfig config = new HikariConfig();
        config.setUsername(username);
        config.setPassword(password);
        config.setDriverClassName(driver);
        config.setJdbcUrl(url);

        config.setMaximumPoolSize(10); //maximo de conexoes liberadas
        config.setMinimumIdle(1); //tamanho inicial da pool
        config.setPoolName("library");
        config.setMaxLifetime(600000);//600 mil ms (10 minutos)
        config.setConnectionTimeout(100000);//timout para conseguir uma conexao
        config.setConnectionTestQuery("select 1 ");//query de teste no sql. Coisa basica

        return new HikariDataSource(config);
    }
}