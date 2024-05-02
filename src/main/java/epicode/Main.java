package epicode;


import epicode.dao.ClasseStudentiDao;
import epicode.dao.CorsoDao;
import epicode.dao.IndirizzoDao;
import epicode.dao.StudenteDao;
import epicode.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode_jpa");
        EntityManager em = emf.createEntityManager();

        StudenteDao studenteDao = new StudenteDao(em);
        IndirizzoDao indirizzoDao = new IndirizzoDao(em);
        ClasseStudentiDao classeStudentiDao = new ClasseStudentiDao(em);
        CorsoDao corsoDao = new CorsoDao(em);

        //scenario: studente da agganciare ad un indirizzo (OneToOne)
        //creo uno studente
//        Studente s1 = new Studente();
//        s1.setNome("Francesco");
//        s1.setCognome("Landi");
//        s1.setTipoStudente(TipoStudente.FULL_TIME);
//        s1.setDataNascita(LocalDate.of(2000,9,9));
//
        //creo un indirizzo
//        Indirizzo indirizzo = new Indirizzo();
//        indirizzo.setVia("Via dei Greci 10");
//        indirizzo.setComune("Salerno");
//        indirizzo.setProvincia("SA");
//       //lo salvo sul db
//        indirizzoDao.save(indirizzo);
//      //inserisco questo indirizzo allo studente precedentemente creato
//        s1.setIndirizzo(indirizzo);
//      //salvo lo studente sul db(posso farlo solo dopo aver salvato l'indirizzo sul db)
//        studenteDao.save(s1);
//
//        em.refresh(indirizzo);
//
//        System.out.println(indirizzo.getStudente());
//
        //scenario: studente da assegnare ad una classe (oneToMany)
        //creo una classe di studenti
//        ClasseStudenti classeStudenti = new ClasseStudenti();
//        classeStudenti.setNome("1I");
//        classeStudenti.setPiano(2);
//
        //salvo la classe sul db
//        classeStudentiDao.save(classeStudenti);
//
        //creo un nuovo studente a cui assegno la classe appena creata sul db
//        Studente s2 = new Studente();
//        s2.setTipoStudente(TipoStudente.FULL_TIME);
//        s2.setNome("Sara");
//        s2.setCognome("Solimene");
//        s2.setDataNascita(LocalDate.of(1995, 6, 3));
//        s2.setClasseStudenti(classeStudenti);
//      //salvo lo studente sul db
//        studenteDao.save(s2);

        //scenario : ho uno studente senza classe e voglio assegnargliela. Classe già presente sul db
        //recupero lo studente con matricola 14 dal db
//        Studente s3 = studenteDao.getById(14);
//        //recupero la classe numero 15 dal db
//        ClasseStudenti classeStudenti2 = classeStudentiDao.getById(15);
//        //setto la classe sullo studente che è lato proprietario
//        s3.setClasseStudenti(classeStudenti2);
//        //salvo sul db lo studente
//        studenteDao.save(s3);

        //scenario: assegnare una nuova classe non presente sul db ad uno studente già collegato ad una classe
        //creo la classe degli studenti
//        ClasseStudenti classeStudenti = new ClasseStudenti();
//        classeStudenti.setNome("1A");
//        classeStudenti.setPiano(2);
//        //la salvo sul db
//        classeStudentiDao.save(classeStudenti);
//        //recupero lo studente con matricola 14 dal db
//        Studente studente = studenteDao.getById(14);
//        //riassegno la classe allo studente che già aveva una classe collegata
//        studente.setClasseStudenti(classeStudenti);
//        //salvo lo studente sul db
//        studenteDao.save(studente);


//        //scenario: recuperare tutti gli studenti di una classe
//        //recupero la classe dal db con id 15
//        ClasseStudenti classeStudenti = classeStudentiDao.getById(15);
//        //stampo tutti gli studenti presenti nella lista della classe
//        //la lista è popolata automaticamente dal Jpa
//        classeStudenti.getStudenti().forEach(System.out::println);

        //scenario: creo 2 corsi e li assegno a tutti gli studenti già presenti sul db
        //creo il primo corso
        Corso c1 = new Corso();
        c1.setNome("Recupero Matematica");
        //salvo il corso sul db
        corsoDao.save(c1);

        //creo il secondo corso
        Corso c2 = new Corso();
        c2.setNome("Cad");
        //salvo il corso sul db
        corsoDao.save(c2);

        //recuperto 4 studenti dal db
        Studente s1 = studenteDao.getById(1);
        Studente s2 = studenteDao.getById(2);
        Studente s3 = studenteDao.getById(14);
        Studente s4 = studenteDao.getById(16);

        //setto su ogni studente la lista di corsi a cui partecipa
        s1.setCorsi(List.of(c1, c2));
        s2.setCorsi(List.of(c1, c2));
        s3.setCorsi(List.of(c1, c2));
        s4.setCorsi(List.of(c1, c2));

        //salvo gli aggiornamenti sugli studenti sul db
        studenteDao.save(s1);
        studenteDao.save(s2);
        studenteDao.save(s3);
        studenteDao.save(s4);






//
    }
}
