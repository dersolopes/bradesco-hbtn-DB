package entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table (name = "curso")
public class Curso implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    private String nome;
    private String sigla;

    @OneToOne @JoinColumn(name = "material_curso_id")
    MaterialCurso materialCurso;

    @ManyToOne @JoinColumn(name = "professor_id")
    private Professor professor;

    @OneToMany (mappedBy = "aluno", cascade = CascadeType.ALL)
    protected List<Aluno> alunos;

    //empt constructor
    public Curso() {}

    //complete constructor
    public Curso(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }

    //getters
    public Long getId() {return id;}
    public String getNome() {return nome;}
    public String getSigla() {return sigla;}

}
