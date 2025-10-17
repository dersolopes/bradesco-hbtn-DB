package demo;

import entities.*;
import models.AlunoModel;
import models.CursoModel;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

//  Classe responsavel por popular todas as tabelas do banco de dados:
//      1 aluno (com um telefone e um endereço)
//      1 professor
//      1 curso (com um professor, um aluno e um material do curso)
public class GestaoCursosMain {
    public static void main(String[] args) {

        // Instanciar os models
        AlunoModel alunoModel = new AlunoModel();
        CursoModel cursoModel = new CursoModel();

        // Criar professor
        Professor professor = new Professor("Maria Souza","I999999", "maria@escola.com");

        // Criar material do curso
        MaterialCurso materialCurso = new MaterialCurso("http://material.com/engenharia");

        // Criar curso e associar professor e material
        Curso curso = new Curso("Engenharia", "ENG");
        curso.setProfessor(professor);
        curso.setMaterialCurso(materialCurso);

        // Criar telefone e endereço
        Telefone telefone = new Telefone("11", "999999999");
        Endereco endereco = new Endereco("Rua A", "Apto 101", "101", "Centro", "São Paulo", "SP", 12345678);

        // Criar aluno e associar curso, telefone e endereço
        Aluno aluno = new Aluno("João Silva", "2023001", Date.valueOf("2000-01-01"), "joao@email.com");
        aluno.setCurso(curso);

        List<Telefone> telefones = new ArrayList<>();
        telefones.add(telefone);
        aluno.setTelefones(telefones);
        telefone.setAluno(aluno);

        List<Endereco> enderecos = new ArrayList<>();
        enderecos.add(endereco);
        aluno.setEnderecos(enderecos);
        endereco.setAluno(aluno);

        // Adicionar aluno ao curso
        List<Aluno> alunosCurso = new ArrayList<>();
        alunosCurso.add(aluno);
        curso.setAlunos(alunosCurso);

        // Persistir curso (vai persistir professor, material, aluno, telefone e endereço por cascata)
        cursoModel.create(curso);

        // Buscar e mostrar dados
        List<Curso> cursos = cursoModel.findAll();
        System.out.println("Cursos cadastrados: " + cursos.size());

        List<Aluno> alunos = alunoModel.findAll();
        System.out.println("Alunos cadastrados: " + alunos.size());
    }
}