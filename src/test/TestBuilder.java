package test;

import Builder.*;
import Componenti.ContextState;
import Giocatore.Giocatore;
import GiocoEtabellone.ConcreteTabellone;
import GiocoEtabellone.Gioco;
import GiocoEtabellone.GiocoNormale;
import GiocoEtabellone.Tabellone;

public class TestBuilder {
    public static void main(String ... args){
        Builder builder = new ConcreteBuilder();
        //creo il tabellone
        //builder.buildTabellone();
        builder.buildTabellone(6,8,48);
        //aggiungo un po di componenti, con l'aggiunta casuale
        builder.buildCaselleScale(3);
        builder.buildCaselleSerpenti(3);
        builder.buildCaselleSosta(4);
        builder.buildCasellePremio(3);
        builder.buildCasellePescaUnaCarta(3);
        builder.buildCasellePescaUnaCartaConUlterioriCarte(4);

        ConcreteTabellone ret = (ConcreteTabellone)builder.getResult();
        ret.stampa();
        System.out.println("------------------");
        System.out.println("Inizio il Gioco");

        Gioco gioco = new GiocoNormale(ret,2);
        //creo il Giocotore
        Giocatore giocatore = new Giocatore(0,gioco);
        Giocatore giocatore1 = new Giocatore(1,gioco);
        Giocatore giocatore2 = new Giocatore(2,gioco);
        boolean termina = false;
        boolean termina1 = false;
        boolean termina2 = false;

        while (! termina && ! termina1 && ! termina2){
            //Giocatore 0
            System.out.println(giocatore.getPosizione() + "0: Prima del lancio");
            termina = giocatore.lancio();
            System.out.println(giocatore.getPosizione() + "0: Dopo il lancio");

            //Giocatore 1
            System.out.println(giocatore1.getPosizione() + "1: Prima del lancio");
            termina1 = giocatore1.lancio();
            System.out.println(giocatore1.getPosizione() + "1: Dopo il lancio");

            //Giocatore 2
            System.out.println(giocatore2.getPosizione() + "2: Prima del lancio");
            termina2 = giocatore2.lancio();
            System.out.println(giocatore2.getPosizione() + "2: Dopo il lancio");

            ret.stampa();
        }


    }//main
}
