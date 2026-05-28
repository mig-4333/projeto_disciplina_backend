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


Arquitetura REST

A API será desenvolvida seguindo o padrão REST, utilizando métodos HTTP para realizar operações de criação, consulta, atualização e remoção dos dados do sistema.

A base da API será:

http://localhost:8080/api
Rotas da API
Alunos
Listar alunos
GET /api/alunos

Código de resposta

200 OK → Lista retornada com sucesso
Buscar aluno por ID
GET /api/alunos/{id}

Código de resposta

200 OK → Aluno encontrado
404 Not Found → Aluno não encontrado
Cadastrar aluno
POST /api/alunos
Exemplo de requisição
{
  "nome": "João Silva",
  "matricula": "2026001",
  "email": "joao@email.com",
  "idade": 17
}

Código de resposta

201 Created → Aluno criado com sucesso
400 Bad Request → Dados inválidos
Atualizar aluno
PUT /api/alunos/{id}

Código de resposta

200 OK → Aluno atualizado
404 Not Found → Aluno não encontrado
400 Bad Request → Dados inválidos
Remover aluno
DELETE /api/alunos/{id}

Código de resposta

204 No Content → Aluno removido
404 Not Found → Aluno não encontrado
Professores
Listar professores
GET /api/professores

Código de resposta

200 OK → Lista retornada com sucesso
Buscar professor por ID
GET /api/professores/{id}

Código de resposta

200 OK → Professor encontrado
404 Not Found → Professor não encontrado
Cadastrar professor
POST /api/professores
Exemplo de requisição
{
  "nome": "Carlos Souza",
  "disciplina": "Matemática",
  "email": "carlos@email.com"
}

Código de resposta

201 Created → Professor criado
400 Bad Request → Dados inválidos
Atualizar professor
PUT /api/professores/{id}

Código de resposta

200 OK → Professor atualizado
404 Not Found → Professor não encontrado
Remover professor
DELETE /api/professores/{id}

Código de resposta

204 No Content → Professor removido
404 Not Found → Professor não encontrado
Turmas
Listar turmas
GET /api/turmas

Código de resposta

200 OK → Lista retornada com sucesso
Buscar turma por ID
GET /api/turmas/{id}

Código de resposta

200 OK → Turma encontrada
404 Not Found → Turma não encontrada
Cadastrar turma
POST /api/turmas
Exemplo de requisição
{
  "nome": "Turma A",
  "serie": "3º Ano",
  "turno": "Manhã"
}

Código de resposta

201 Created → Turma criada
400 Bad Request → Dados inválidos
Atualizar turma
PUT /api/turmas/{id}

Código de resposta

200 OK → Turma atualizada
404 Not Found → Turma não encontrada
Remover turma
DELETE /api/turmas/{id}

Código de resposta

204 No Content → Turma removida
404 Not Found → Turma não encontrada
Associar aluno à turma
POST /api/turmas/{idTurma}/alunos/{idAluno}

Código de resposta

200 OK → Aluno associado à turma
404 Not Found → Turma ou aluno não encontrado
400 Bad Request → Associação inválida
Associar professor à turma
POST /api/turmas/{idTurma}/professor/{idProfessor}

Código de resposta

200 OK → Professor associado à turma
404 Not Found → Professor ou turma não encontrado
Associar sala à turma
POST /api/turmas/{idTurma}/sala/{idSala}

Código de resposta

200 OK → Sala associada à turma
404 Not Found → Sala ou turma não encontrada
Salas
Listar salas
GET /api/salas

Código de resposta

200 OK → Lista retornada com sucesso
Buscar sala por ID
GET /api/salas/{id}

Código de resposta

200 OK → Sala encontrada
404 Not Found → Sala não encontrada
Cadastrar sala
POST /api/salas
Exemplo de requisição
{
  "numero": "101",
  "bloco": "A",
  "capacidade": 40
}

Código de resposta

201 Created → Sala criada
400 Bad Request → Dados inválidos
Atualizar sala
PUT /api/salas/{id}

Código de resposta

200 OK → Sala atualizada
404 Not Found → Sala não encontrada
Remover sala
DELETE /api/salas/{id}

Código de resposta

204 No Content → Sala removida
404 Not Found → Sala não encontrada
Mapeamento das Funcionalidades
Funcionalidade	Endpoint
Cadastrar aluno	POST /api/alunos
Listar alunos	GET /api/alunos
Buscar aluno por ID	GET /api/alunos/{id}
Atualizar aluno	PUT /api/alunos/{id}
Remover aluno	DELETE /api/alunos/{id}
Cadastrar professor	POST /api/professores
Listar professores	GET /api/professores
Buscar professor por ID	GET /api/professores/{id}
Atualizar professor	PUT /api/professores/{id}
Remover professor	DELETE /api/professores/{id}
Cadastrar turma	POST /api/turmas
Listar turmas	GET /api/turmas
Buscar turma por ID	GET /api/turmas/{id}
Atualizar turma	PUT /api/turmas/{id}
Remover turma	DELETE /api/turmas/{id}
Associar aluno à turma	POST /api/turmas/{idTurma}/alunos/{idAluno}
Associar professor à turma	POST /api/turmas/{idTurma}/professor/{idProfessor}
Associar sala à turma	POST /api/turmas/{idTurma}/sala/{idSala}
Cadastrar sala	POST /api/salas
Listar salas	GET /api/salas
Buscar sala por ID	GET /api/salas/{id}
Atualizar sala	PUT /api/salas/{id}
Remover sala	DELETE /api/salas/{id}

