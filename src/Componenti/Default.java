package Componenti;

import Giocatore.Giocatore;
import SupportClass.Posizione;

public class Default extends AbstractComponent {

    public Default(Posizione p){
        super(p);
    }

    @Override
    public void azione(Giocatore g) {
        super.azione(g);
    }

    @Override
    public void stampa() {
        if(! this.getGiocatoriSuCella().isEmpty())
            System.out.print(String.format("[ Vu[%d]ta ]", this.getGiocatoriSuCella().size()));
        else
            System.out.print("[  Vuota  ]");
    }

    @Override
    public String toString() {
        return "Componente 'Defoult' in posizione " + getPosizione();
    }
}
