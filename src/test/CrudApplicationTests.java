package com.trabalho.Restaurante;

// Em src/test/java/.../CrudApplicationTests.java

import org.springframework.boot.test.context.SpringBootTest; 
import org.junit.jupiter.api.extension.ExtendWith; // Para JUnit 5
import org.springframework.test.context.junit.jupiter.SpringExtension; // Para JUnit 5

// Para JUnit 5 (Recomendado):
@SpringBootTest 
@ExtendWith(SpringExtension.class) // Garante a integração com Spring
public class CrudApplicationTests {
    // ...
}

// Para JUnit 4:
@RunWith(SpringRunner.class) // Garante a integração com Spring
@SpringBootTest
public class CrudApplicationTests {
    // ...
}