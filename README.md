# Integrantes

- Miguel Guerra da Rocha

##  Tema do Projeto
Sistema de gerenciamento escolar desenvolvido para controle de:

- Turmas
- Salas de aula
- Professores
- Alunos

A API permitirá o cadastro, edição, consulta e remoção das informações escolares, facilitando a organização acadêmica e administrativa da escola.

---

# Objetivo do Projeto

Criar uma API REST para gerenciamento escolar, permitindo controlar alunos, professores, salas e turmas de forma organizada e eficiente.

---

#  Funcionalidades Principais

##  Alunos
- Cadastro de alunos
- Listagem de alunos
- Atualização de dados do aluno
- Exclusão de alunos
- Consulta por matrícula

##  Professores
- Cadastro de professores
- Listagem de professores
- Atualização de professores
- Exclusão de professores
- Associação de professores às turmas

##  Turmas
- Cadastro de turmas
- Associação de alunos
- Associação de professores
- Consulta de turmas
- Exclusão de turmas

##  Salas de Aula
- Cadastro de salas
- Definição de capacidade
- Associação da sala à turma
- Consulta de disponibilidade

---

#  Modelos (Entidades)

##  Entidade: Aluno

Representa os estudantes cadastrados no sistema.

### Atributos:
| Campo | Tipo |
|------|------|
| id | Long |
| nome | String |
| matricula | String |
| email | String |
| idade | Integer |

---

##  Entidade: Professor

Representa os professores da escola.

### Atributos:
| Campo | Tipo |
|------|------|
| id | Long |
| nome | String |
| disciplina | String |
| email | String |

---

##  Entidade: Turma

Representa as turmas escolares.

### Atributos:
| Campo | Tipo |
|------|------|
| id | Long |
| nome | String |
| serie | String |
| turno | String |

### Relacionamentos:
- Uma turma possui vários alunos
- Uma turma possui um professor
- Uma turma utiliza uma sala

---

##  Entidade: Sala

Representa as salas de aula da escola.

### Atributos:
| Campo | Tipo |
|------|------|
| id | Long |
| numero | String |
| bloco | String |
| capacidade | Integer |

---

#  Relacionamentos

| Entidade | Relacionamento |
|----------|----------------|
| Turma → Aluno | OneToMany |
| Turma → Professor | ManyToOne |
| Turma → Sala | OneToOne |

---

#  Endpoints Principais

##  Alunos

| Método | Endpoint | Descrição |
|--------|----------|------------|
| GET | /alunos | Lista alunos |
| GET | /alunos/{id} | Busca aluno por ID |
| POST | /alunos | Cadastra aluno |
| PUT | /alunos/{id} | Atualiza aluno |
| DELETE | /alunos/{id} | Remove aluno |

---

##  Professores

| Método | Endpoint | Descrição |
|--------|----------|------------|
| GET | /professores | Lista professores |
| POST | /professores | Cadastra professor |
| PUT | /professores/{id} | Atualiza professor |
| DELETE | /professores/{id} | Remove professor |

---

##  Turmas

| Método | Endpoint | Descrição |
|--------|----------|------------|
| GET | /turmas | Lista turmas |
| POST | /turmas | Cadastra turma |
| PUT | /turmas/{id} | Atualiza turma |
| DELETE | /turmas/{id} | Remove turma |

---

##  Salas

| Método | Endpoint | Descrição |
|--------|----------|------------|
| GET | /salas | Lista salas |
| POST | /salas | Cadastra sala |
| PUT | /salas/{id} | Atualiza sala |
| DELETE | /salas/{id} | Remove sala |

