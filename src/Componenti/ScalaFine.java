package Componenti;

import Giocatore.Giocatore;
import SupportClass.Posizione;

public class ScalaFine extends AbstractComponent{

    public ScalaFine(Posizione p){
        super(p);
    }


    @Override
    public void stampa() {
        if(getGiocatore() != null)
            System.out.print(String.format("[ Sc[%d]Fi ]", getGiocatore().getID()));
        System.out.print("[  ScaFi  ]");
    }
}
