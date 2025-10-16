package entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "professor")
public class Professor implements Serializable{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected String nomeCompleto;
    protected String matricula;
    protected String email;

    @OneToMany (mappedBy = "professor", cascade = CascadeType.ALL)
    protected List <Curso> cursos;

    //empt constructor
    public Professor() {}

    //complete constructor
    public Professor(String nome,String matricula, Date nascimento, String email) {
        this.nomeCompleto = nome;
        this.matricula = matricula;
        this.email = email;
    }

    //getters
    public Long getId() {return id;}
    public String getNomeCompleto() {return nomeCompleto;}
    public String getMatricula() {return matricula;}
    public String getEmail() {return email;}

}
