package test;

import Componenti.*;
import Giocatore.Giocatore;
import GiocoEtabellone.*;
import SupportClass.Posizione;

public class TestGiochi2 {
    public static void main(String ... args) {
        //creo il tabellone
        int numeroRighe = 8;
        int numeroColonne = 6;
        int numCelle = 48;

        ConcreteTabellone tabellone = new ConcreteTabellone(numCelle, numeroRighe, numeroColonne);
        //test su serpenti e scale(superato)
        Posizione pSerpenteInizio = new Posizione(1, numeroRighe, numeroColonne, numCelle);
        SerpenteInizio serpenteInizio = new SerpenteInizio(pSerpenteInizio);
        tabellone.add(serpenteInizio);

        Posizione pSerpenteFine = new Posizione(6,numeroRighe, numeroColonne, numCelle);
        SerpenteFine serpenteFine = new SerpenteFine(pSerpenteFine, serpenteInizio);
        tabellone.add(serpenteFine);



        Posizione pScalaFine1 = new Posizione(19,numeroRighe, numeroColonne, numCelle);
        ScalaFine scalaFine1 = new ScalaFine(pScalaFine1);
        tabellone.add(scalaFine1);

        Posizione pScalaInizio1 = new Posizione(6, numeroRighe, numeroColonne, numCelle);
        ScalaInizio scalaInizio1 = new ScalaInizio(pScalaInizio1,scalaFine1);
        tabellone.add(scalaInizio1);

        //test divieto di sosta(superato)
        Posizione p1 = new Posizione(2,numeroRighe, numeroColonne, numCelle);
        DivietoDiSosta divietoDiSosta = new DivietoDiSosta(p1);
        tabellone.add(divietoDiSosta);

        //test premio(superato)
        Posizione p3 = new Posizione(5,numeroRighe, numeroColonne, numCelle);
        Premio premio = new Premio(p3, Premio.TipoPremio.MOLLA);
        tabellone.add(premio);

        //test sosta(superato)
        Posizione p7 = new Posizione(11,numeroRighe,numeroColonne, numCelle);
        Sosta sosta = new Sosta(p7, Sosta.TipoSosta.PANCHINA);
        tabellone.add(sosta);

        //test pesca una carta (superato)
        Posizione p2 = new Posizione(4,numeroRighe, numeroColonne, numCelle);
        StateComponent pescaUnaCarta = new PescaUnaCarta(p2,4);
        tabellone.add(pescaUnaCarta);



        tabellone.stampa();
        System.out.println("------------------");
        //creo il gioco
        //Gioco gioco = new GiocoNormale(tabellone,2);
        //Gioco gioco = new GiocoUnSoloDadoFinale(tabellone);
        Gioco gioco = new GiocoNormale(tabellone,2);
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




            tabellone.stampa();
        }

        System.out.println("------------------");
        // tabellone.stampa();



    }
}
