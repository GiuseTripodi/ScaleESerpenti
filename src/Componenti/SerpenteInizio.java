package Componenti;

import Giocatore.Giocatore;
import SupportClass.Posizione;

public class SerpenteInizio extends AbstractComponent{

    public SerpenteInizio(Posizione p){
        super(p);
    }



    @Override
    public void stampa() {
        if(getGiocatore() != null)
            System.out.print(String.format("[ Se[%d]In ]", getGiocatore().getID()));
        System.out.print("[  SerIn  ]");
    }
}
