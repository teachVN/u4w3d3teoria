package epicode.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "studenti")
public class Studente{
    @Id
    @GeneratedValue
    private int matricola;

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(nullable = false, length = 30)
    private String cognome;

    @Column(name = "data_nascita")
    private LocalDate dataNascita;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_studente")
    private TipoStudente tipoStudente;

    //per creare una sola tabella studenti in cui vengono inseriti anche i dati dell'indirizzo
//    @Embedded
//    private Indirizzo indirizzo;
    @OneToOne
    @JoinColumn(name = "indirizzo_id")
    private Indirizzo indirizzo;

    //lato proprietario: è sempre quello many e ha la JoinColumn
    @ManyToOne
    @JoinColumn(name = "classe_studenti_id")
    private ClasseStudenti classeStudenti;

    @ManyToMany
    @JoinTable(name = "studenti_corsi",
    joinColumns = @JoinColumn(name = "studenti_id"),
    inverseJoinColumns = @JoinColumn(name = "corsi_id"))
    private List<Corso> corsi;


    public Studente(int matricola, String nome, String cognome,  LocalDate dataNascita) {
        this.nome=nome;
        this.matricola = matricola;
        this.cognome = cognome;

        this.dataNascita = dataNascita;
    }



    public Studente(){

    }

    public List<Corso> getCorsi() {
        return corsi;
    }

    public void setCorsi(List<Corso> corsi) {
        this.corsi = corsi;
    }

    public ClasseStudenti getClasseStudenti() {
        return classeStudenti;
    }

    public void setClasseStudenti(ClasseStudenti classeStudenti) {
        this.classeStudenti = classeStudenti;
    }

    public Indirizzo getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
    }

    public int getMatricola() {
        return matricola;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }



    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }





    @Override
    public String toString() {
        return "Studente{" +
                "matricola=" + matricola +
                ", nome='" + getNome() + '\'' +
                ", cognome='" + cognome + '\'' +

                ", dataNascita=" + dataNascita +
                ", tipoStudente=" + tipoStudente +

                '}';
    }

    public TipoStudente getTipoStudente() {
        return tipoStudente;
    }

    public void setTipoStudente(TipoStudente tipoStudente) {
        this.tipoStudente = tipoStudente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Studente studente = (Studente) o;
        return matricola == studente.matricola;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricola);
    }
}
