package Componenti;

import Giocatore.Giocatore;
import SupportClass.Posizione;

public class DivietoDiSosta extends AbstractComponent {

    public DivietoDiSosta(Posizione p){
        super(p);
    }

    @Override
    public void azione(Giocatore g){
        super.azione(g);
        g.setCartaDivietoDiSosta();
    }

    @Override
    public void stampa() {
        if(this.getGiocatore() != null)
            System.out.print (String.format("[ Di[%d]So ]" , this.getGiocatore().getID()));
        System.out.print("[  DivSo  ]");
    }
}
