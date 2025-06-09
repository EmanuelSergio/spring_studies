# 🔐 Spring Security com JWT - Autenticação Segura com Chaves RSA

<p align="center">
  <img src="https://img.shields.io/badge/Java-21-blue?logo=java" />
  <img src="https://img.shields.io/badge/Spring%20Boot-3.3.0-brightgreen?logo=spring" />
  <img src="https://img.shields.io/badge/JWT-Autenticação-red?logo=jsonwebtokens" />
  <img src="https://img.shields.io/badge/MySQL-Database-blue?logo=mysql" />
  <img src="https://img.shields.io/badge/Docker-Containerization-blue?logo=docker" />
</p>

## 📌 Visão Geral

Este projeto demonstra uma implementação robusta de autenticação e autorização utilizando **Spring Security** com **JWT (JSON Web Tokens)** e **chaves RSA**. A aplicação simula uma rede social estilo Twitter, com controle de acesso baseado em funções.

---

## 🧰 Tecnologias Utilizadas

- Java 21  
- Spring Boot 3.3.0  
- Spring Security (OAuth2 Resource Server)  
- Spring Data JPA  
- MySQL  
- Docker (para conteinerização do banco de dados)  

---

## 🔒 Funcionalidades de Segurança

- Autenticação baseada em JWT com par de chaves RSA (pública/privada)  
- Autorização baseada em funções (admin e usuário comum)  
- Senhas criptografadas com **BCrypt**  
- Gerenciamento de sessão **stateless**  
- Integração com banco de dados MySQL para persistência  

---

## 🧱 Estrutura do Projeto

- **Controllers**: Camada responsável por tratar as requisições HTTP  
- **DTOs**: Objetos de transferência para requisições e respostas  
- **Entities**: Entidades JPA que representam as tabelas do banco de dados  
- **Repositories**: Interfaces de acesso a dados  
- **Config**: Configurações de segurança e inicialização da aplicação  

---

## 🗃️ Estrutura do Banco de Dados

- `tb_users`: Armazena dados dos usuários  
- `tb_roles`: Armazena os tipos de funções (admin, usuário)  
- `tb_users_roles`: Tabela intermediária de relacionamento entre usuários e funções  
- `tb_tweets`: Armazena os tweets e referência ao usuário  

---

## ▶️ Como Executar

### Pré-requisitos

- Java 21  
- Docker (opcional, para subir o banco de dados)  

### Banco de Dados

Você pode utilizar o arquivo **docker-compose.yml** fornecido para iniciar uma instância do MySQL:

```bash
docker-compose up -d
```

Ou configurar manualmente o banco de dados no `application.properties`.

### Executar a Aplicação

```bash
./mvnw spring-boot:run
```

Acesse a aplicação em: [http://localhost:8080](http://localhost:8080)

---

## 🔑 Endpoints de Autenticação

- `POST /login`: Autentica o usuário e retorna o token JWT  
  **Exemplo de body:**  
  ```json
  {
    "username": "admin",
    "password": "123"
  }
  ```

  **Resposta:**  
  ```json
  {
    "accessToken": "jwt-token",
    "expiresIn": 300
  }
  ```

- Todos os demais endpoints requerem o envio do token JWT no cabeçalho `Authorization`.

---

## ⚙️ Detalhes da Implementação JWT

- Par de chaves **RSA** usado para assinar/verificar o token  
- Chave pública: `app.pub`  
- Chave privada: `app.key`  
- Tokens expiram em **5 minutos (300 segundos)**  
- Chaves armazenadas em `src/main/resources`  
- Roles e usuário admin são criados via `data.sql` e `AdminUserConfig`  

---

## 🌱 Possíveis Funcionalidades Futuras

- Registro de novos usuários  
- Tokens de atualização (refresh tokens)  
- Verificação de e-mail  
- Redefinição de senha  
- Login via OAuth2 (Google, GitHub etc.)  
- Limites de requisição (rate limiting)  
- Upload de mídias em tweets  
- Sistema de seguidores e timelines personalizadas  
- Documentação com Swagger/OpenAPI  

---

## 🔐 Boas Práticas de Segurança

- Armazene as chaves JWT com segurança (ex.: **vaults**)  
- Utilize **HTTPS** em ambientes de produção  
- Faça rotação periódica das chaves  
- Considere camadas adicionais de segurança para produção  

---

## 👨‍💻 Sobre o Projeto

Este projeto tem como objetivo demonstrar uma arquitetura de autenticação segura com JWT e Spring Security, com foco em **boas práticas**, **modularização** e **manutenibilidade**.

[![LinkedIn](https://img.shields.io/badge/LinkedIn-Perfil-blue?logo=linkedin)](https://www.linkedin.com/in/emanuel-girardi-99320421a/)