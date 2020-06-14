package Componenti;

import Giocatore.Giocatore;
import SupportClass.Posizione;

public class Default extends AbstractComponent {

    public Default(Posizione p){
        super(p);
    }

    @Override
    public void azione(Giocatore g) {
        g.setPosizione(this.getPosizione());
        this.setGiocatoreSuCella(g);
    }

    @Override
    public void stampa() {
        if(this.getGiocatore() != null)
            System.out.print(String.format("[ Vu[%d]ta ]", this.getGiocatore().getID()));
        System.out.print("[  Vuota  ]");
    }
}
