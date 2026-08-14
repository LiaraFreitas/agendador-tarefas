# 📅 Agendador de Tarefas

Aplicação Back-End para **gerenciamento e agendamento de tarefas**, desenvolvida utilizando **Java 17 e Spring Boot**, com uma arquitetura baseada em **microsserviços**.

O projeto foi desenvolvido com o objetivo de aplicar na prática conceitos de desenvolvimento Back-End, arquitetura de microsserviços, comunicação entre serviços, autenticação, persistência de dados, validações, tratamento de exceções e boas práticas de desenvolvimento.


## 🏗️ Arquitetura

A aplicação é dividida em diferentes serviços, cada um responsável por uma parte específica do sistema.

```text
                         ┌──────────────────┐
                         │     Cliente      │
                         └────────┬─────────┘
                                  │
                                  ▼
                     ┌────────────────────────┐
                     │          BFF           │
                     │   Back For Frontend    │
                     └───────────┬────────────┘
                                 │
                    ┌────────────┴────────────┐
                    │                         │
                    ▼                         ▼
          ┌──────────────────┐      ┌──────────────────┐
          │  Microsserviço   │      │  Microsserviço   │
          │     Usuário      │      │    Agendador     │
          └──────────────────┘      └─────────┬────────┘
                                              │
                                              ▼
                                   ┌──────────────────┐
                                   │  Microsserviço   │
                                   │   Notificação    │
                                   └──────────────────┘
```

### Microsserviços

| Serviço                  | Responsabilidade                                            |
| ------------------------ | ----------------------------------------------------------- |
| **Usuario**              | Cadastro, autenticação e gerenciamento de usuários          |
| **Agendador de Tarefas** | Criação, consulta e gerenciamento das tarefas               |
| **Notificação**          | Envio de notificações relacionadas às tarefas               |
| **BFF**                  | Centralização da comunicação entre cliente e microsserviços |



## 🚀 Tecnologias utilizadas

### Back-End

* Java 17
* Spring Boot
* Spring Data
* Spring Security
* Spring Validation
* APIs REST

### Arquitetura e comunicação

* Arquitetura de Microsserviços
* OpenFeign
* BFF — Back For Frontend
* JWT

### Banco de dados

* MongoDB
* PostgreSQL

### Notificações

* Spring Mail
* Thymeleaf

### DevOps e ferramentas

* Docker
* Docker Compose
* Git
* GitHub Actions
* Gradle
* Postman

# 🔐 Autenticação

A aplicação utiliza **Spring Security** para controle de autenticação e autorização.

O processo de autenticação utiliza **JWT (JSON Web Token)**.

Fluxo simplificado:

```text
Cliente
   │
   │ Credenciais
   ▼
Microsserviço de Usuário
   │
   │ JWT
   ▼
Cliente
   │
   │ Requisição + Bearer Token
   ▼
Microsserviço protegido
   │
   │ Validação do token
   ▼
Requisição autorizada
```


# 🔄 Comunicação entre os serviços

A comunicação entre os microsserviços utiliza **OpenFeign** para chamadas HTTP entre os serviços.

O uso do OpenFeign permite encapsular a comunicação entre APIs e facilita a integração entre os diferentes componentes da aplicação.

---

# 🔌 BFF — Back For Frontend

O projeto possui um **BFF (Back For Frontend)** responsável por atuar como uma camada intermediária entre o cliente e os microsserviços.

Essa abordagem permite centralizar determinadas chamadas e evitar que o cliente precise conhecer diretamente todos os serviços existentes na aplicação.

Repositório:

👉 [BFF Agendador de Tarefas](https://github.com/LiaraFreitas/bff-agendador-tarefas)

---

# 👤 Microsserviço de Usuário

Responsável pelo gerenciamento dos usuários e pela autenticação da aplicação.

Principais responsabilidades:

* Cadastro de usuários
* Autenticação
* Geração e validação de JWT
* Persistência de usuários
* Validação de dados
* Controle de acesso

Repositório:

👉 [Usuario](https://github.com/LiaraFreitas/usuario)

---

# 📋 Microsserviço de Agendamento

Responsável pelo gerenciamento das tarefas cadastradas na aplicação.

Entre as funcionalidades estão:

* Criação de tarefas
* Consulta de tarefas
* Atualização de tarefas
* Atualização de status
* Consulta por período
* Validação do usuário autenticado

Repositório:

👉 [Agendador de Tarefas](https://github.com/LiaraFreitas/agendador-tarefas)

---

# 📧 Microsserviço de Notificação

Responsável pelo envio de notificações relacionadas às tarefas agendadas.

O serviço utiliza recursos do **Spring Mail** para envio de e-mails e **Thymeleaf** para construção dos templates das mensagens.

Repositório:

👉 [Notificação](https://github.com/LiaraFreitas/notificacao)

---

# 🧪 Testes

O projeto possui testes automatizados utilizando as ferramentas do ecossistema Java.

Também foram utilizados testes manuais das APIs durante o desenvolvimento utilizando o **Postman**.

---

# ⚙️ Como executar o projeto

### Pré-requisitos

Antes de executar o projeto, é necessário possuir:

* Java 17
* Docker
* Docker Compose
* Git

## Clonar os repositórios

```bash
git clone https://github.com/LiaraFreitas/usuario.git

git clone https://github.com/LiaraFreitas/agendador-tarefas.git

git clone https://github.com/LiaraFreitas/notificacao.git

git clone https://github.com/LiaraFreitas/bff-agendador-tarefas.git
```

## Executar a infraestrutura

Dentro do projeto correspondente:

```bash
docker compose up -d
```

Depois, execute os microsserviços de acordo com suas respectivas configurações.

---

# 📂 Estrutura do projeto

```text
Agendador de Tarefas
│
├── usuario
│   └── Microsserviço de Usuário
│
├── agendador-tarefas
│   └── Microsserviço de Agendamento
│
├── notificacao
│   └── Microsserviço de Notificação
│
└── bff-agendador-tarefas
    └── Back For Frontend
```

---

# 📚 Conceitos praticados

Durante o desenvolvimento do projeto foram praticados conceitos como:

* Arquitetura de microsserviços
* APIs REST
* Spring Boot
* Spring Data
* Spring Security
* JWT
* OpenFeign
* BFF
* MongoDB
* DTOs
* Validações
* Tratamento de exceções
* Testes automatizados
* Docker
* Git
* GitHub Actions
* Integração entre serviços

---

# 🎯 Objetivo do projeto

O principal objetivo do projeto é consolidar conhecimentos em **desenvolvimento Back-End com Java e Spring Boot**, aplicando conceitos de arquitetura de microsserviços e boas práticas de desenvolvimento em uma aplicação prática.

O projeto continua em evolução e novos recursos podem ser adicionados futuramente.

---

# 👩‍💻 Autora

**Liara Freitas**

Desenvolvedora de Software Júnior com foco em **Back-End, Java e Spring Boot**.

🔗 [GitHub](https://github.com/LiaraFreitas)

🔗 [LinkedIn](https://www.linkedin.com/in/liara-freitas/)
