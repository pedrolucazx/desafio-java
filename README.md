# Desafio Técnico - Sistema de Gerenciamento de Tarefas Simplificado

Status: Not started

**Objetivo:** Desenvolver uma aplicação web utilizando Spring Boot que permita aos usuários gerenciar tarefas diárias de forma simples.

**Requisitos Funcionais:**

1. Criação de Tarefa: O usuário pode adicionar uma nova tarefa. Cada tarefa deve ter um título, descrição, data de criação e um status (por exemplo, pendente, concluída).
2. Listagem de Tarefas: O usuário pode ver todas as suas tarefas em uma lista, ordenadas pela data de criação.
3. Edição de Tarefa: O usuário pode editar o título e a descrição de uma tarefa existente. Não é permitido editar a data de criação.
4. Exclusão de Tarefa: O usuário pode excluir uma tarefa.
5. Alteração de Status: O usuário pode alterar o status de uma tarefa para "concluída" ou voltar para "pendente".

**Regras de Negócio:**

1. Validação de Dados: As tarefas devem ter um título e uma descrição. O título deve ter pelo menos 5 caracteres.
2. Ordenação de Tarefas: Ao listar as tarefas, estas devem estar ordenadas pela data de criação, das mais antigas para as mais recentes.
3. Limitação de Criação: Um usuário não pode criar mais de 10 tarefas pendentes ao mesmo tempo.

**Tecnologias:**

![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)

## Instruções para Executar a Aplicação

### Pré-requisitos

- Docker
- Docker Compose

### Configuração do Projeto

1. Clone o repositório:

   ```bash
   git clone https://github.com/pedrolucazx/desafio-java.git
   cd desafio-java
   ```

2. Execute a aplicação:

   ```bash
   docker-compose up --build
   ```

3. Acesse [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
