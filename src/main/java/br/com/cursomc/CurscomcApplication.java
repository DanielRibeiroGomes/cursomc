package br.com.cursomc;

import br.com.cursomc.model.*;
import br.com.cursomc.model.enums.EstadoPagamento;
import br.com.cursomc.model.enums.TipoCliente;
import br.com.cursomc.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class CurscomcApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CurscomcApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

    }
}
