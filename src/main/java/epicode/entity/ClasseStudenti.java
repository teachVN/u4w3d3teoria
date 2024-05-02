package epicode.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "classe_studenti")
public class ClasseStudenti {
    @Id
    @GeneratedValue
    private int id;

    private String nome;
    private int piano;
    // lato inverso: è sempre il lato One e ha la lista
    @OneToMany(mappedBy = "classeStudenti")
    private List<Studente> studenti;

    public ClasseStudenti(int id, String nome, int piano) {
        this.id = id;
        this.nome = nome;
        this.piano = piano;
    }

    public ClasseStudenti(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPiano() {
        return piano;
    }

    public void setPiano(int piano) {
        this.piano = piano;
    }

    public List<Studente> getStudenti() {
        return studenti;
    }

    public void setStudenti(List<Studente> studenti) {
        this.studenti = studenti;
    }
}
