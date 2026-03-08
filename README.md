# 🖋️ MicroPost API — MiniBlog

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.6-brightgreen?style=for-the-badge&logo=springboot)
![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![Security](https://img.shields.io/badge/Spring%20Security-JWT-blueviolet?style=for-the-badge&logo=springsecurity)
![MySQL](https://img.shields.io/badge/MySQL-Connector-blue?style=for-the-badge&logo=mysql)

O **MiniBlog** é uma API RESTful robusta e escalável desenvolvida para gerenciar publicações, comentários e interações entre usuários. Com foco em segurança e performance, o projeto implementa autenticação via JWT, controle de acesso por perfis (Roles) e resiliência de sistema.

---

## 🚀 Tecnologias Utilizadas

O projeto utiliza o que há de mais moderno no ecossistema Java:

- **[Java 21](https://www.oracle.com/java/):** Linguagem base com recursos avançados.
- **[Spring Boot 3.5.6](https://spring.io/projects/spring-boot):** Framework para agilizar o desenvolvimento.
- **[Spring Security](https://spring.io/projects/spring-security):** Proteção de rotas e autenticação.
- **[Java JWT (Auth0)](https://github.com/auth0/java-jwt):** Emissão e validação de tokens seguros.
- **[Spring Data JPA](https://spring.io/projects/spring-data-jpa):** Persistência de dados e mapeamento objeto-relacional (ORM).
- **[MySQL](https://www.mysql.com/):** Banco de dados relacional para armazenamento robusto.
- **[Resilience4j](https://resilience4j.readme.io/):** Implementação de padrões de tolerância a falhas (Circuit Breaker, Rate Limiter).

---

## 🏛️ Arquitetura e Organização

O projeto segue os princípios de **Clean Architecture** e separação de responsabilidades:

- **Controllers:** Pontos de entrada da API que gerenciam as requisições HTTP.
- **Services:** Camada de lógica de negócio (com implementações separadas por interfaces).
- **Repositories:** Abstração de acesso ao banco de dados utilizando Spring Data.
- **Models/Entities:** Representação das tabelas do banco de dados (Post, Comment, Tag, User).
- **Security:** Configurações de filtros e estratégia de autenticação.

---

## 🛠️ Instalação e Configuração

### Pré-requisitos
*   JDK 21 instalado.
*   Maven 3.x.
*   Instância do MySQL rodando.

### Passo a Passo

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/flaviare1s/mini-blog.git
   cd mini-blog
   ```

2. **Configure o Banco de Dados:**
   Edite o arquivo `src/main/resources/application.properties` com suas credenciais:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/nome_do_seu_banco
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Compile e execute:**
   ```bash
   # Utilizando o Maven Wrapper
   ./mvnw clean install
   ./mvnw spring-boot:run
   ```

---

## 🔌 Endpoints Principais

### Autenticação
*   `POST /auth/login` - Autentica usuário e retorna token JWT.
*   `POST /auth/register` - Cria uma nova conta.

### Posts
*   `GET /posts` - Lista todos os posts.
*   `POST /posts` - Cria uma nova publicação (Requer Autenticação).

### Comentários & Tags
*   `POST /comments` - Adiciona comentário a um post.
*   `GET /tags` - Lista tags cadastradas.

---

## 🛡️ Segurança

A API utiliza **Spring Security** com a seguinte estratégia:
- **Stateless:** Não mantém sessão no servidor.
- **JWT Filter:** Verifica o token no Header `Authorization: Bearer <token>` em cada requisição protegida.
- **Roles:** Diferentes níveis de acesso baseados em `RoleEnum` (ex: ADMIN, USER).

---

## 🧪 Testes

Para executar a suite de testes unitários e de integração:
```bash
./mvnw test
```

---

> *Este projeto foi desenvolvido com Spring Boot para a disciplina de Framework da Faculdade Descomplica.*