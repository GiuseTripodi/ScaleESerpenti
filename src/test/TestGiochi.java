package test;

import Componenti.ScalaFine;
import Componenti.SerpenteInizio;
import Componenti.Sosta;
import Giocatore.Giocatore;
import GiocoEtabellone.ConcreteTabellone;
import GiocoEtabellone.Gioco;
import GiocoEtabellone.GiocoNormale;
import SupportClass.Posizione;

public class TestGiochi {
    public static void main(String ... args) {
        //creo il tabellone
        int numeroRighe = 4;
        int numeroColonne = 5;
        int numCelle = 20;

        Posizione p = new Posizione();
        p.setInformazioniTabellone(numeroRighe, numeroColonne, numCelle);
        ConcreteTabellone t = new ConcreteTabellone(numCelle, numeroRighe, numeroColonne);
        //aggiungo un po di componenti
        p.setNumeroCella(4);
        t.add(new Sosta(p, Sosta.TipoSosta.LOCANDA));
        p.setNumeroCella(2);
        t.add(new ScalaFine(p));
        p.setNumeroCella(7);
        t.add(new SerpenteInizio(p));
        t.stampa();
        System.out.println("------------------");
        //creo il gioco
        Gioco gioco = new GiocoNormale(t,2);
        //creo il Giocotore
        Giocatore giocatore = new Giocatore(0,gioco);
        giocatore.lancio();
    }
}
