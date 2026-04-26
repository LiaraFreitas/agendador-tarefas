
# 📝 Agendador de Tarefas - Microsserviços em Java

Este microserviço é responsável por gerenciar o agendamento de tarefas em um sistema de gestão de tarefas. Ele interage com o microserviço de **Usuário** para validar o token de autenticação e, assim, garantir a segurança da API.

Este projeto é parte de um curso de **Java, Spring Boot e Arquitetura de Microsserviços**, com o objetivo de praticar conceitos de **POO, APIs REST, segurança com JWT, e banco de dados NoSQL (MongoDB)**.

## 📌 Status do Projeto

No momento, o projeto está em desenvolvimento.
Neste momento está sendo entregue o segundo microserviço **Agendador de tarefas**.

**Microsserviços planejados**:

- ✅ Cadastro de Usuário (finalizado)
- ✅ Agendador de Tarefas (finalizado)
- ✅ Notificação por Email (em finalizado)
- ⏳ BFF (Back For Frontend) (em andamento)


## ⚙️ Tecnologias Utilizadas

- ☕ **Java 17**
- 🌱 **Spring Boot** (Web, Data JPA, Security, Validation)
- 🗄️ **MongoDB** (Banco de Dados NoSQL)
- 🔐 **Spring Security + JWT** (autenticação e autorização)
- 📡 **OpenFeign** (Comunicação síncrona entre microserviços)
- 📬 **Spring Mail + Thymeleaf** (Notificações por Email)
- 📬 **Postman** (testes de requisições HTTP)
- 🔄 **GitHub Actions** (CI/CD)
- 🛠️ **Gradle** (build e gerenciamento de dependências)
- 🗂️ **Metodologias Ágeis** (Kanban, Git Flow com branches main, develop e feature)


## 🚀 Funcionalidades do Microsserviço de Usuário

- **Cadastrar tarefas**: Permite a criação de tarefas, incluindo nome, descrição, data de evento e status.
- **Buscar tarefas por um determinado período**: Permite consultar as tarefas dentro de um intervalo de datas.
- **Alterar dados de uma tarefa**: Possibilita a edição dos dados de uma tarefa previamente criada.
- **Alterar o status da tarefa**: Atualiza o status da tarefa (por exemplo, de **pendente** para **concluída** ou **cancelada**).
  


## 🧪 Testes de API (Usuário)

As rotas disponíveis foram testadas com **Postman**:

- `POST /tarefas` → Criar nova tarefa  
- `GET /tarefas?inicio=2025-09-01&fim=2025-09-30` → Buscar tarefas por período (data de início e fim)  
- `PUT /tarefas/{id}` → Atualizar dados de uma tarefa  
- `PATCH /tarefas/{id}/status` → Alterar o status da tarefa (PENDENTE, NOTIFICADO, CANCELADO)

 ## 📂 Estrutura do Projeto (parcial)
 
 ```shell
 /agendador-tarefas
├── usuario # Microsserviço de usuários (entregue)
│ ├── src/main/java  # Código principal
│ ├── src/test/java  # Testes unitários
├── agendador        # Microsserviço de tarefas (entregue)
├── notificacao      # Microsserviço de emails (em desenvolvimento)
├── bff              # Microsserviço BFF (planejado)
└── README.md
```

## ▶️ Como Rodar o Microsserviço de Usuário

**1.** Clone este repositório:
```bash
git clone https://github.com/SEU-USUARIO/agendador-tarefas.git
```

**2.** Clone este repositório:
```bash
cd agendador-tarefas
```
**3.** Configure o banco de dados no arquivo **application.properties**.

**4.** Utilize o **Postman** para testar as rotas.

## 👨‍💻 Autor

Desenvolvido por **Liara Freitas** no curso da Javanauta.
