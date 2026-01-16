# 📋 Tasklist API

API desenvolvida em **Spring Boot (Java 21)** para gerenciamento de tarefas (Tasklist).  
O projeto foi construído com **Gradle** e utiliza **PostgreSQL** como banco de dados.

---

## 🚦 Funcionalidades Implementadas

- Criar uma nova tarefa (`POST /tasks`)
- Listar todas as tarefas (`GET /tasks`)
- Buscar tarefa por ID (`GET /tasks/{id}`)
- Atualizar tarefa (`PUT /tasks/{id}`)
- Deletar tarefa (`DELETE /tasks/{id}`)

---

## ⚙️ Tecnologias utilizadas

- **Java 21**
- **Spring Boot 3.5.5**
- **Gradle**
- **Spring Data JPA**
- **PostgreSQL**
- **Lombok**
- **Spring Validation**
- **Actuator** (monitoramento)

---

## Estrutura do projeto

```text
src/main/java/com/jtech/todolist
 ├── application
 │    ├── controllers   → REST Controllers (entrada da API)
 │    └── dtos          → Objetos de transferência (request/response)
 │    └── exceptions    → Tratamentos de exceções
 ├── core
 │    ├── domain        → Entidades (ex: Task)
 │    └── usecases      → Interfaces dos casos de uso
 ├── infrastructure
 │    ├── persistence   → Repositórios JPA, implementações de gateways
 │    └── config        → Configurações do Spring Boot (Beans, DB, etc.)
 └── usecases
      └── impl          → Implementações dos casos de uso
```
### O projeto segue princípios de Clean Architecture, separando domínio, casos de uso, infraestrutura e adapters.
---

## ▶️ Como executar localmente

### Pré-requisitos
- Java 21 instalado
- Gradle instalado
- PostgreSQL rodando localmente

### Passos
# Clonar o repositório

```bash
git clone https://github.com/seu-usuario/tasklist-api.git
cd tasklist-api
```
### Executar a aplicação
```bash
./gradlew bootRun
```
- Pode-se também executar a classe **StartTasklist** encontrada na raiz do projeto.

### A aplicação está disponível em:
```bash
http://localhost:8080
```
---

## 🐳 Executando com Docker
### Você pode rodar a aplicação e o banco de dados via Docker para simplificar a configuração.

```bash
docker compose up -d
```

### Você pode acessar o banco de dados como teste para ver se foi criado sua tabela, pode utilizar seu navegador como demonstro a seguir:

```bash
http://localhost:8081/login

Login: admin@jtech.com
Password: admin

```

### Aqui será necessário a criação da conexão, podendo seguir meu exemplo de imagens abaixo:
<img width="650" height="600" alt="image" src="https://github.com/user-attachments/assets/6d4c7f6f-4e02-4723-bd8a-fec0e678abec" />
<img width="650" height="600" alt="image" src="https://github.com/user-attachments/assets/95bb3751-c669-4e6c-8fc6-caf671c868ed" />

### Agora basta navega até encontrar a aba de tabelas, que está encontrado em public:
<img width="235" height="217" alt="image" src="https://github.com/user-attachments/assets/fa597bb0-f8ec-4dac-a684-ba27b41c23c8" />


---

## 📬 Testes manuais com Postman

### POST /tasks → criar tarefa
<img width="850" height="600" alt="image" src="https://github.com/user-attachments/assets/a8d3044a-49e2-4e50-96a8-f93add44e6d3" />

### GET /tasks → listar tarefas
<img width="850" height="600" alt="image" src="https://github.com/user-attachments/assets/55d5a296-1efa-471f-ae74-ad17f262eb11" />

### GET /tasks/{id} → buscar tarefa específica
<img width="850" height="600" alt="image" src="https://github.com/user-attachments/assets/c74a43b2-19e3-4547-bf7d-e6ab757a9192" />

### PUT /tasks/{id} → atualizar tarefa
<img width="850" height="600" alt="image" src="https://github.com/user-attachments/assets/7c17d6af-9c29-4ddf-a7ae-bcc4e4728313" />

### DELETE /tasks/{id} → remover tarefa
<img width="850" height="600" alt="image" src="https://github.com/user-attachments/assets/0c7c332d-128d-48ef-b7a8-091fc3a9935c" />

### Nota: É possivel fazer o acesso aos endpoints utilizando o Swagger:
```bash
http://localhost:8080/swagger-ui/index.html#/
````
<img width="1300" height="550" alt="image" src="https://github.com/user-attachments/assets/78fc2df3-e199-4209-bf77-3b323f19d5f0" />


---
## Exceções personalizadas

### 404 Not Found
<img width="850" height="600" alt="image" src="https://github.com/user-attachments/assets/eb895a41-0a7b-47a0-a9b2-3449bd43d97a" />

### 404 Not Found
<img width="850" height="600" alt="image" src="https://github.com/user-attachments/assets/fcbc77d9-ce46-4893-ad7f-1e89623a7639" />

### 400 Bad Request
<img width="850" height="600" alt="image" src="https://github.com/user-attachments/assets/2ea3a1c1-62b2-451f-a9d6-e6f493d6b774" />

---
# 🖥️ Frontend — TODO List | JTech Challenge

Este repositório contém a aplicação **frontend** do desafio técnico proposto pela **JTech**, desenvolvida para consumir uma API RESTful de gerenciamento de tarefas (TODO List).

O frontend foi construído com foco em **clareza de código**, **boa experiência do usuário**, **integração correta com o backend** e **boas práticas modernas de desenvolvimento frontend**.

---

## 🎯 Objetivo

Fornecer uma interface web moderna e intuitiva para:

- Criar tarefas
- Listar tarefas
- Visualizar tarefa por ID
- Atualizar tarefas
- Remover tarefas

A aplicação consome diretamente a API backend desenvolvida em **Java + Spring Boot**, respeitando os contratos REST definidos no desafio.

---

## 🧱 Stack Tecnológica

- **Vue.js 3** — Framework frontend (Composition API)
- **Vite** — Build tool e dev server
- **Tailwind CSS v4** — Estilização utilitária moderna
- **Axios** — Comunicação HTTP com a API
- **Vue Router** — Gerenciamento de rotas

---

## 📁 Estrutura do Projeto

```text
src/
 ├─ api/
 │   ├─ http.js          # Configuração do Axios
 │   └─ tasks.js         # Camada de acesso à API de tarefas
 │
 ├─ components/
 │   ├─ AppHeader.vue
 │   ├─ TaskFormModal.vue
 │   ├─ TaskStatusBadge.vue
 │   └─ UiEmptyState.vue
 │
 ├─ pages/
 │   ├─ TasksPage.vue        # Listagem, criação e edição
 │   └─ TaskDetailsPage.vue # Detalhes da tarefa
 │
 ├─ router/
 │   └─ index.js
 │
 ├─ assets/
 │   └─ main.css         # Importação do Tailwind
 │
 ├─ App.vue
 └─ main.js
```
---
## 🔗 Integração com o Backend
### A aplicação consome a API REST exposta pelo backend no endpoint base:
```bash
http://localhost:8080/tasks
```
---
## Endpoints consumidos

| Método | Endpoint      | Descrição                  |
| ------ | ------------- | -------------------------- |
| GET    | `/tasks`      | Listar todas as tarefas    |
| GET    | `/tasks/{id}` | Buscar tarefa por ID       |
| POST   | `/tasks`      | Criar nova tarefa          |
| PUT    | `/tasks/{id}` | Atualizar tarefa existente |
| DELETE | `/tasks/{id}` | Remover tarefa             |

### ⚠️ O frontend envia o campo status respeitando exatamente o enum definido no backend:

- PENDENTE
- CONCLUIDA
---
## 🌐 Configuração de Ambiente

### Crie um arquivo .env na raiz do projeto:

```bash
VITE_API_URL=http://localhost:8080
```
### Após qualquer alteração no .env, reinicie o servidor do Vite.
---

## 🎨 Estilização com Tailwind CSS

### O projeto utiliza Tailwind CSS v4, integrado diretamente ao Vite, seguindo a abordagem moderna recomendada.

### Arquivo global de estilos

```bash
/* src/assets/main.css */
@import "tailwindcss";
```

### O Tailwind é importado no projeto através do main.js.
---

##🚦 Funcionalidades Implementadas

- ✅ Listagem de tarefas com feedback visual
- ✅ Criação de tarefas via modal
- ✅ Edição de tarefas
- ✅ Exclusão com confirmação
- ✅ Visualização detalhada por ID
- ✅ Estados visuais para carregamento e lista vazia
- ✅ Tratamento de erros de API
- ✅ Integração correta com enums do backend
- ✅ Interface responsiva e consistente

---

## ▶️ Como Executar o Projeto
### Pré-requisitos

- Node.js 18+
- Backend em execução (Spring Boot)

### Passos:
```bash
# Instalar dependências
npm install

# Iniciar o servidor de desenvolvimento
npm run dev
```

### A aplicação estará disponível em:

```text
http://localhost:5173
```
---
## 🎨 Visual da aplicação
### Tela inicial listando tarefas:
<img width="1000" height="500" alt="image" src="https://github.com/user-attachments/assets/46fa73c3-dba3-412b-b3b0-7bc69bd05ba7" />

### Criando nova tarefa:
<img width="500" height="470" alt="image" src="https://github.com/user-attachments/assets/cd72016b-2d2e-4874-b20e-6e14c0a6cc29" />

### Editar tarefa:
<img width="500" height="470" alt="image" src="https://github.com/user-attachments/assets/b56a4f6a-16ef-4301-9b44-c43e7742697c" />

### Deletando tarefa
<img width="1000" height="500" alt="image" src="https://github.com/user-attachments/assets/fdd5a4de-d7e2-42da-94b1-b3eb4d9ae74e" />

---

## 🧪 Observações Técnicas
- O estado da aplicação é atualizado após cada operação de CRUD
- O frontend respeita integralmente os contratos definidos no backend
- A arquitetura prioriza separação de responsabilidades (API, páginas e componentes)
- Código escrito utilizando Composition API e práticas modernas do Vue 3
---

# 💡 Sugestões de melhorias
De uam maneira geral acabei pensando em melhorias quanto a projetos empresariais, 
sendo um deles a criação de usuário ADMIN e do tipo NORMAL, dando a condição do ADMIN
delegar tarefas que serão executados pelos demais. Podemos até acrescentar campos para
monitorar o tempo que se leva para executar determinadas tarefas, adicionando na classe
Task um atributo createdAt e updatedAt, fazendo salvar a data que o ADMIN criou o mesmo
e dando a liberdade apenas para o NORMAL atualizar o campo que estaria em PENDENTE, para CONCLUÍDA.
Também não podemos descartar a idéia de deixar o usuário NORMAL comentar como executou e
o que precisou para executar a tarefa.

---
# 📌 Considerações Finais

Este projeto foi desenvolvido como parte de um desafio técnico,
com foco em boas práticas de desenvolvimento, organização de código,
clareza arquitetural e integração correta entre frontend e backend.

