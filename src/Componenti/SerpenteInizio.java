package Componenti;

import Giocatore.Giocatore;
import SupportClass.Posizione;

public class SerpenteInizio extends AbstractComponent{

    public SerpenteInizio(Posizione p){
        super(p);
    }

    @Override
    public void azione(Giocatore g) {
        super.azione(g);
    }

    @Override
    public void stampa() {
        if(! this.getGiocatoriSuCella().isEmpty())
            System.out.print(String.format("[ Se[%d]In ]", getGiocatoriSuCella().size()));
        else System.out.print("[  SerIn  ]");
    }

    @Override
    public String toString() {
        return "Componente 'SerpenteInizio' in posizione " + getPosizione();
    }
}
