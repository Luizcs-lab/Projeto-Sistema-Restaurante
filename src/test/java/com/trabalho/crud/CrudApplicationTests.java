package com.trabalho.crud;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertTrue; // Importação para o Assertions

@SpringBootTest
@ActiveProfiles("test")
class CruidApplicationTests {

    @Test
    void contextLoads() {
        // Apenas para confirmar que o contexto carregou sem exceções
        assertTrue(true); 
    }
}