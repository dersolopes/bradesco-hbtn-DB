package entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table (name = "material_curso")
public class MaterialCurso implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    private String url;

    @OneToOne @JoinColumn(name = "curso_id")
    Curso curso;


    //empt constructor
    public MaterialCurso() {}

    //complete constructor
    public MaterialCurso(String url) {
        this.url = url;
    }

    //getters
    public Long getId() {return id;}
    public String getUrl() {return url;}
}
