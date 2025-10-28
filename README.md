


# 🍽️ Projeto-Sistema-Restaurante - Backend

## 📋 Descrição

O **Projeto-Sistema-Restaurante** é uma aplicação backend desenvolvida em **Java 17 com Spring Boot**, projetada para gerenciar os processos internos de um restaurante.  
O sistema contempla módulos de **cadastro de produtos, controle de pedidos, gerenciamento de clientes, funcionários, mesas e autenticação de usuários**.  

O objetivo é oferecer uma API RESTful organizada, segura e escalável, pronta para integração com um **frontend web** ou **aplicativo mobile**.

---

## ⚙️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.x**
- **Spring Web**
- **Spring Data JPA**
- **Spring Security (JWT)**
- **MySQL**
- **Lombok**
- **Maven**
- **Swagger / SpringDoc OpenAPI**

---

## 🧱 Pré-requisitos

Antes de iniciar, você precisará ter instalado:

- **JDK 17+**
- **Maven 3.8+**
- **MySQL 8+**
- **Git**

---

## 🚀 Instalação e Execução

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/seu-usuario/Projeto-Sistema-Restaurante.git
   ```

2. **Acesse o diretório do projeto:**
   ```bash
   cd Projeto-Sistema-Restaurante
   ```

3. **Configure o banco de dados:**
   Edite o arquivo `src/main/resources/application.yaml` com as configurações do seu MySQL:
   ```yaml
   spring:
     datasource:
       url: jdbc:mysql://localhost:3306/restaurante_db
       username: root
       password: sua_senha
       driver-class-name: com.mysql.cj.jdbc.Driver

     jpa:
       hibernate:
         ddl-auto: update
       show-sql: true

     jackson:
       serialization:
         INDENT_OUTPUT: true

   jwt:
     secret: minha_chave_super_secreta
     expiration: 86400000 # 1 dia
   ```

4. **Compile e execute o projeto:**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

5. **Acesse a API:**
   ```
   http://localhost:8080
   ```

---

## 📖 Documentação da API (Swagger)

Após iniciar o backend, acesse a documentação gerada automaticamente pelo Swagger em:  
👉 [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

## 🔐 Autenticação

O sistema utiliza **JWT (JSON Web Token)** para autenticação e autorização.  
Fluxo básico:

1. O usuário realiza login em `/api/auth/login` enviando **email e senha**.  
2. Se válido, o sistema retorna um **token JWT**.  
3. O token deve ser enviado no cabeçalho `Authorization` em todas as requisições protegidas:  
   ```
   Authorization: Bearer seu_token_jwt
   ```

---

## 🔗 Endpoints Principais

### **1. POST /api/auth/login**

- **Descrição:** Realiza o login e retorna o token JWT.
- **Corpo da Requisição:**
  ```json
  {
    "email": "admin@restaurante.com",
    "senha": "123456"
  }
  ```
- **Resposta:**
  ```json
  {
    "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
  }
  ```

---

### **2. GET /api/produtos**

- **Descrição:** Retorna todos os produtos cadastrados.
- **Resposta:**
  ```json
  [
    {
      "id": 1,
      "nome": "Pizza Calabresa",
      "preco": 45.90,
      "categoria": "Pizzas"
    }
  ]
  ```

---

### **3. POST /api/pedidos**

- **Descrição:** Cria um novo pedido para uma mesa ou cliente.
- **Corpo da Requisição:**
  ```json
  {
    "clienteId": 1,
    "mesa": 5,
    "itens": [
      { "produtoId": 1, "quantidade": 2 },
      { "produtoId": 3, "quantidade": 1 }
    ]
  }
  ```
- **Resposta:**
  ```json
  {
    "id": 10,
    "status": "RECEBIDO",
    "valorTotal": 92.80
  }
  ```

---

### **4. PUT /api/pedidos/{id}/status**

- **Descrição:** Atualiza o status de um pedido.
- **Corpo da Requisição:**
  ```json
  { "status": "ENTREGUE" }
  ```
- **Resposta:**
  ```json
  {
    "id": 10,
    "status": "ENTREGUE"
  }
  ```

---

### **5. GET /api/clientes**

- **Descrição:** Retorna todos os clientes cadastrados.
- **Resposta:**
  ```json
  [
    {
      "id": 1,
      "nome": "Carlos Mendes",
      "telefone": "(11) 99999-9999"
    }
  ]
  ```

---

### **6. POST /api/funcionarios**

- **Descrição:** Cadastra um novo funcionário.
- **Corpo da Requisição:**
  ```json
  {
    "nome": "Fernanda Lima",
    "cargo": "Atendente",
    "salario": 2300.00
  }
  ```
- **Resposta:**
  ```json
  {
    "id": 4,
    "nome": "Fernanda Lima",
    "cargo": "Atendente"
  }
  ```

---

## 🗂️ Estrutura de Pacotes (Sugerida)

```
src/
 └── main/
     ├── java/com/restaurante/backend/
     │   ├── controller/
     │   ├── model/
     │   ├── repository/
     │   ├── service/
     │   ├── config/
     │   ├── security/
     │   └── dto/
     └── resources/
         ├── application.yaml
         └── data.sql
```

---

## 🧩 Futuras Implementações

- [ ] Controle de estoque em tempo real  
- [ ] Relatórios gerenciais (vendas diárias, produtos mais vendidos, etc.)  
- [ ] Integração com sistema de entregas  
- [ ] Painel administrativo com dashboards  
- [ ] Módulo de reservas de mesas  

---

## 👨‍💻 Equipe de Desenvolvimento

- **Cesar [Seu Sobrenome]** — Desenvolvedor Backend  

---

## 📜 Licença

Este projeto é distribuído sob a licença **MIT**.  
Veja o arquivo `LICENSE` para mais detalhes.
>>>>>>> da60b2b3d274b462829c8246ded71bd60c6624fd
