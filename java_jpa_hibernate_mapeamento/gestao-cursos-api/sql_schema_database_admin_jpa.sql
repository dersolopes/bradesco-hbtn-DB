-- Tabela Professor
CREATE TABLE professor (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  nomeCompleto TEXT,
  matricula TEXT,
  email TEXT
);

-- Tabela Curso
CREATE TABLE curso (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  nome TEXT,
  sigla TEXT,
  professor_id INTEGER,
  material_curso_id INTEGER,
  FOREIGN KEY (professor_id) REFERENCES professor(id),
  FOREIGN KEY (material_curso_id) REFERENCES material_curso(id)
);

-- Tabela MaterialCurso
CREATE TABLE material_curso (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  url TEXT,
  curso_id INTEGER,
  FOREIGN KEY (curso_id) REFERENCES curso(id)
);

-- Tabela Aluno
CREATE TABLE aluno (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  nomeCompleto TEXT,
  matricula TEXT,
  nascimento DATE,
  email TEXT,
  curso_id INTEGER,
  FOREIGN KEY (curso_id) REFERENCES curso(id)
);

-- Tabela Endereco
CREATE TABLE endereco (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  logradouro TEXT,
  endereco TEXT,
  numero TEXT,
  bairro TEXT,
  cidade TEXT,
  estado TEXT,
  cep INTEGER,
  aluno_id INTEGER,
  FOREIGN KEY (aluno_id) REFERENCES aluno(id)
);

-- Tabela Telefone
CREATE TABLE telefone (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  DDD TEXT,
  numero TEXT,
  aluno_id INTEGER,
  FOREIGN KEY (aluno_id) REFERENCES aluno(id)
);
