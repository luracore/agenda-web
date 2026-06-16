# Agenda Web - Material Educacional

Sistema Web para gerenciamento de atendimentos e exames, desenvolvido para demonstrar o ciclo completo de desenvolvimento de software utilizando tecnologias modernas de backend, frontend, banco de dados, containers e CI/CD.

## Tecnologias

| Camada         | Tecnologia                  |
| -------------- | --------------------------- |
| Backend        | Java 17 + Spring Boot 3.2   |
| Frontend       | React 18 + React Router     |
| Banco de Dados | PostgreSQL 15               |
| Build Backend  | Maven                       |
| Build Frontend | Node.js 20 + npm            |
| Versionamento  | Git + GitHub                |
| CI/CD          | GitHub Actions              |
| Containers     | Docker + Docker Compose     |
| Produção       | AWS (ECS + RDS + ECR + ALB) |

## Funcionalidades

### Atendimentos

* Cadastro de atendimentos
* Registro de data e hora
* Descrição do atendimento
* Inclusão de links de referência
* Registro de receitas
* Edição e exclusão de atendimentos

### Exames

* Cadastro de exames
* Descrição do exame
* Inclusão de links de referência
* Registro de posologia/orientações
* Edição e exclusão de exames

## Estrutura do Projeto

```text
agenda-web/
├── backend/                    # API REST (Java/Spring Boot)
│   ├── pom.xml
│   ├── Dockerfile
│   └── src/
│       ├── controller/
│       │   ├── AtendimentoController.java
│       │   └── ExameController.java
│       ├── model/
│       │   ├── Atendimento.java
│       │   └── Exame.java
│       └── repository/
│           ├── AtendimentoRepository.java
│           └── ExameRepository.java
│
├── frontend/                   # Interface React
│   ├── package.json
│   ├── Dockerfile
│   └── src/
│       ├── components/
│       │   ├── AtendimentoList.js
│       │   ├── AtendimentoForm.js
│       │   ├── ExameList.js
│       │   └── ExameForm.js
│       ├── services/
│       │   └── api.js
│       └── App.js
│
├── docker-compose.yml
├── .github/workflows/ci-cd.yml
└── README.md
```

## Como Executar (Desenvolvimento)

### Utilizando Docker Compose

```bash
docker-compose up -d
```

Aplicações disponíveis em:

* Backend: http://localhost:8080
* Frontend: http://localhost:3000

## Como Executar Testes

### Backend (JUnit 5 + Mockito)

```bash
cd backend
mvn test
```

### Frontend (Jest)

```bash
cd frontend
npm test
```

## Endpoints da API

### Atendimentos

```http
GET    /api/atendimentos
GET    /api/atendimentos/{id}
POST   /api/atendimentos
PUT    /api/atendimentos/{id}
DELETE /api/atendimentos/{id}
```

### Exames

```http
GET    /api/exames
GET    /api/exames/{id}
POST   /api/exames
PUT    /api/exames/{id}
DELETE /api/exames/{id}
```

## Modelos de Dados

### Atendimento

| Campo     | Tipo      |
| --------- | --------- |
| id        | Long      |
| titulo    | String    |
| data      | LocalDate |
| hora      | LocalTime |
| descricao | String    |
| link      | String    |
| receita   | String    |

### Exame

| Campo     | Tipo   |
| --------- | ------ |
| id        | Long   |
| descricao | String |
| link      | String |
| posologia | String |

## Objetivo Educacional

Este projeto demonstra:

* Desenvolvimento de APIs REST com Spring Boot
* Integração frontend React com backend Java
* Persistência de dados com PostgreSQL
* Testes automatizados com JUnit e Mockito
* Consumo de APIs com React e Axios
* Containerização com Docker
* Integração contínua com GitHub Actions
* Estruturação de aplicações Full Stack modernas
* Boas práticas de organização em camadas (Controller, Model, Repository)

```
```
