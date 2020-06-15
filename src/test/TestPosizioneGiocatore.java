package test;

import Giocatore.Giocatore;
import GiocoEtabellone.Gioco;
import SupportClass.Posizione;

public class TestPosizioneGiocatore {
    public static void main(String... args){
        Giocatore g = new Giocatore();
        Posizione posizione = new Posizione(0,0,0);
        posizione.setInformazioniTabellone(4,5,20);
        g.setPosizione(posizione);
        System.out.println(g.getPosizione());
        for(int i = 0; i< 1000; i++) {
            Posizione pos = g.getPosizione();

            pos.posDopoLancio(i);
            //g.setPosizione(pos);
            System.out.println(g.getPosizione());
        }


    }
}
