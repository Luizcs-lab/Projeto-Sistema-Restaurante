package com.trabalho.crud.core.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// Em src/test/java/.../UserServiceTest.java

import com.trabalho.Restaurante.CrudApplication; // Importe a classe principal

@SpringBootTest(classes = CrudApplication.class) // Aponta explicitamente para sua classe principal
@ExtendWith(SpringExtension.class) // Ou @RunWith(SpringRunner.class)
public class UserServiceTest {
    // ...
}