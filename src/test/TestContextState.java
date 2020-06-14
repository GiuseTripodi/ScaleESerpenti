package test;

import Componenti.*;
import Giocatore.Giocatore;
import GiocoEtabellone.Gioco;
import SupportClass.Posizione;

import javax.naming.Context;
import java.util.Random;

public class TestContextState {
    public static void main(String... args){
        System.out.println("-----------------------------");
        Posizione p = new Posizione(0,0,0);
        ContextState c1 = new ContextState(p);

        /**
        System.out.println(c1.stampa());
        //Provo tutti i componenti cambiando lo stato
        c1.setState(new DivietoDiSosta(p));System.out.println(c1.stampa());
        c1.setState(new PescaUnaCarta(p,5));System.out.println(c1.stampa());
        c1.setState(new Premio(p, Premio.TipoPremio.DADI));System.out.println(c1.stampa());
        c1.setState(new ScalaFine(p));System.out.println(c1.stampa());
        c1.setState(new ScalaInizio(p, new ScalaFine(p)));System.out.println(c1.stampa());
        c1.setState(new SerpenteFine(p, new SerpenteInizio(p)));System.out.println(c1.stampa());
        c1.setState(new SerpenteInizio(p));System.out.println(c1.stampa());
        c1.setState(new Sosta(p, Sosta.TipoSosta.LOCANDA));System.out.println(c1.stampa());
        System.out.println("-----------------------------");

         */


    }
}
