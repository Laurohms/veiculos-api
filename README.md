# lb-veiculos-api

Exemplo de API REST para gerenciamento de veículos associados a apartamentos, desenvolvida com Spring Boot e PostgreSQL.

## Tecnologias Utilizadas

- **Linguagem**: Kotlin
- **Framework**: Spring Boot
- **Banco de Dados**: PostgreSQL
- **ORM**: Spring Data JPA
- **Gerenciamento de Dependências**: Maven

## Configuração do Banco de Dados

Antes de iniciar a aplicação, certifique-se de que o PostgreSQL está configurado corretamente.

### Configuração no `application.yml`:

```yaml
spring:
  application:
    name: lb-veiculos-api
  datasource:
    url: jdbc:postgresql://localhost:5432/veiculos
    username: postgres
    password: 123
    driver-class-name: org.postgresql.Driver
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect
```

## Executando o Projeto

1. Clone este repositório:
   ```sh
   git clone https://github.com/Laurohms/veiculos-api.git
   ```
2. Acesse o diretório do projeto:
   ```sh
   cd veiculos-api
   ```
3. Compile e execute a aplicação:
   ```sh
   mvn spring-boot:run
   ```

## Endpoints da API

### Criar um Veículo
- **POST** `/veiculos`
- **Request Body (JSON)**:
  ```json
  {
    "placa": "ABC1234",
    "marca": "Toyota",
    "modelo": "Corolla",
    "cor": "Prata",
    "apartamento": 101,
    "vagaAlugada": true
  }
  ```
- **Response**:
  ```json
  {
    "placa": "ABC1234",
    "marca": "toyota",
    "modelo": "corolla",
    "cor": "prata",
    "apartamento": 101,
    "vagaAlugada": true
  }
  ```

### Buscar Veículo por Placa
- **GET** `/veiculos/{placa}`
- **Exemplo de Resposta:**
  ```json
  {
    "placa": "ABC1234",
    "marca": "toyota",
    "modelo": "corolla",
    "cor": "prata",
    "apartamento": 101,
    "vagaAlugada": 5
  }
  ```

### Listar Todos os Veículos
- **GET** `/veiculos`

### Buscar Veículos por Apartamento
- **GET** `/veiculos/apartamento/{apartamento}`

### Atualizar Veículo
- **PUT** `/veiculos/{placa}`

### Deletar Veículo
- **DELETE** `/veiculos/{placa}`

## Tratamento de Erros

### Veículo Não Encontrado
- **Código HTTP:** `404`
- **Exemplo de Resposta:**
  ```json
  {
    "code": 404,
    "message": "Veículo com placa não encontrado: XYZ9999"
  }
  ```

### Placa Inválida
- **Código HTTP:** `400`
- **Exemplo de Resposta:**
  ```json
  {
    "code": 400,
    "message": "Placa deve conter 7 caracteres"
  }
  ```

