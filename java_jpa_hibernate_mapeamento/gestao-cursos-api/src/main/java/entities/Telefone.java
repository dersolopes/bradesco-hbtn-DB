package entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table (name = "telefone")
public class Telefone implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected String DDD;
    protected String numero;

    @ManyToOne @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    //empt constructor
    public Telefone() {}

    //complete constructor
    public Telefone(String DDD, String numero) {
        this.DDD = DDD;
        this.numero = numero;
    }

    //getters
    public Long getId() {return id;}
    public String getNumero() {return numero;}
    public String getDDD() {return DDD;}
}
