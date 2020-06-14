package test;

import Componenti.*;
import GiocoEtabellone.ConcreteTabellone;
import GiocoEtabellone.Tabellone;
import SupportClass.Posizione;

public class TestTabellone {

    public static void main(String ... args){
        int numeroRighe  = 9;
        int numeroColonne = 10;
        int numCelle = 19;

        Posizione p = new Posizione();
        p.setInformazioniTabellone(numeroRighe,numeroColonne,numCelle);
        ConcreteTabellone t = new ConcreteTabellone(numCelle,numeroRighe, numeroColonne);
        //aggiungo un po di componenti
        p.setNumeroCella(4);
        t.add(new Sosta(p, Sosta.TipoSosta.LOCANDA));
        p.setNumeroCella(2);
        t.add(new ScalaFine(p));
        p.setNumeroCella(7);
        t.add(new SerpenteInizio(p));

        t.stampa();
        System.out.println("------------------");



    }

}
