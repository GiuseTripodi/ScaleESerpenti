package Componenti;

import Giocatore.Giocatore;
import SupportClass.Posizione;

public class ScalaFine extends AbstractComponent{

    public ScalaFine(Posizione p){
        super(p);
    }

    @Override
    public void azione(Giocatore g) {
        super.azione(g);
    }


    @Override
    public void stampa() {
        if(! this.getGiocatoriSuCella().isEmpty())
            System.out.print(String.format("[ Sc[%d]Fi ]", getGiocatoriSuCella().size()));
        else System.out.print("[  ScaFi  ]");
    }

    @Override
    public String toString() {
        return "Componente 'ScalaFine' in posizione " + getPosizione();
    }
}
