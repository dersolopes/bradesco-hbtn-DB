package entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity @Table(name = "aluno")
public class Aluno implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected String nomeCompleto;
    protected String matricula;
    protected Date nascimento;
    protected String email;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    protected List<Endereco> enderecos;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    protected List<Telefone> telefones;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    protected Curso curso;

    //empt constructor
    public Aluno() {}

    //complete constructor
    public Aluno(String nome,String matricula, Date nascimento, String email) {
        this.nomeCompleto = nome;
        this.matricula = matricula;
        this.nascimento = nascimento;
        this.email = email;
    }

    //getters
    public Long getId() {return id;}
    public String getNomeCompleto() {return nomeCompleto;}
    public String getMatricula() {return matricula;}
    public Date getNascimento() {return nascimento;}
    public String getEmail() {return email;}

}
