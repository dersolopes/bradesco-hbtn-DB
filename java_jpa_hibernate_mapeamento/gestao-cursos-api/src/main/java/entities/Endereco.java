package entities;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity @Table (name = "endereco")
public class Endereco implements Serializable {

    @Id @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    protected Long id;

    protected String logradouro;
    protected String endereco;
    protected String numero;
    protected String bairro;
    protected String cidade;
    protected String estado;
    protected Integer cep;

    @ManyToOne @JoinColumn(name = "aluno_id")
    private Aluno aluno;


    //empt constructor
    public Endereco() {}

    //complete constructor
    public Endereco(String logradouro, String endereco, String numero, String bairro, String cidade, String estado, Integer cep) {
        this.logradouro = logradouro;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    //getters
    public Long getId() {return id;}
    public String getLogradouro() {return logradouro;}
    public String getEndereco() {return endereco;}
    public String getNumero() {return numero;}
    public String getBairro() {return bairro;}
    public String getCidade() {return cidade;}
    public String getEstado() {return estado;}
    public Integer getCep() {return cep;}

}
