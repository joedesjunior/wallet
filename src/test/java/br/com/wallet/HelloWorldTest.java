package br.com.wallet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HelloWorldTest {

    @Test
    void deveValidarMensagemDeHelloWorld() {
        String frase = "Hello World";
        Assertions.assertEquals(frase.toString(), "Hello World");
    }
}
