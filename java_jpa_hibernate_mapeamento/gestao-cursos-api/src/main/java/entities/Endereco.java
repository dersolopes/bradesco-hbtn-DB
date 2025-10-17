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


    //Construtor vazio
    public Endereco() {}

    //Construtor com parametros e utilizando setters
    public Endereco(String logradouro, String endereco, String numero, String bairro, String cidade, String estado, Integer cep) {
        setLogradouro(logradouro);
        setEndereco(endereco);
        setNumero(numero);
        setBairro(bairro);
        setCidade(cidade);
        setEstado(estado);
        setCep(cep);
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

    //setters
    public void setLogradouro(String logradouro) {this.logradouro = logradouro;}
    public void setEndereco(String endereco) {this.endereco = endereco;}
    public void setNumero(String numero) {this.numero = numero;}
    public void setBairro(String bairro) {this.bairro = bairro;}
    public void setCidade(String cidade) {this.cidade = cidade;}
    public void setEstado(String estado) {this.estado = estado;}
    public void setCep(Integer cep) {this.cep=cep;}
    public void setAluno(Aluno aluno) {this.aluno = aluno;}

}
