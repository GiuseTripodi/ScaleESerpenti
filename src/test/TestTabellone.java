package test;

import Componenti.*;
import GiocoEtabellone.ConcreteTabellone;
import GiocoEtabellone.Tabellone;
import SupportClass.Posizione;

public class TestTabellone {

    public static void main(String ... args){
        int numeroRighe  = 4;
        int numeroColonne = 5;
        int numCelle = 20;

        Posizione p = new Posizione();
        p.setInformazioniTabellone(numeroRighe,numeroColonne,numCelle);
        ConcreteTabellone t = new ConcreteTabellone(numeroRighe, numeroColonne,numCelle);
        //aggiungo un po di componenti
        Posizione p1 = new Posizione(4,numeroRighe,numeroColonne,numCelle);
        Sosta sosta = new Sosta(p1, Sosta.TipoSosta.LOCANDA);
        t.add(sosta);
        p.setNumeroCella(2);
        t.add(new ScalaFine(p));
        p.setNumeroCella(7);
        t.add(new SerpenteInizio(p));
        t.stampa();
        System.out.println("------------------");
        t.remove(sosta);
        t.stampa();



    }

}
