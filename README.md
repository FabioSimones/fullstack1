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
git clone https://github.com/seu-usuario/tasklist-api.git
cd tasklist-api

### Executar a aplicação
./gradlew bootRun

# A aplicação está disponível em:
```bash
http://localhost:8080
```
---

## 🐳 Executando com Docker
### Você pode rodar a aplicação e o banco de dados via Docker para simplificar a configuração.

```bash
docker-compose up --build
```
---

## 📬 Testes manuais com Postman

### POST /tasks → criar tarefa

### GET /tasks → listar tarefas

### GET /tasks/{id} → buscar tarefa específica

### PUT /tasks/{id} → atualizar tarefa

### DELETE /tasks/{id} → remover tarefa

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

## 🧪 Observações Técnicas
- O estado da aplicação é atualizado após cada operação de CRUD
- O frontend respeita integralmente os contratos definidos no backend
- A arquitetura prioriza separação de responsabilidades (API, páginas e componentes)
- Código escrito utilizando Composition API e práticas modernas do Vue 3
---

## 📌 Considerações Finais

Este projeto foi desenvolvido como parte de um desafio técnico,
com foco em boas práticas de desenvolvimento, organização de código,
clareza arquitetural e integração correta entre frontend e backend.

