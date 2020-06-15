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
        System.out.printf("Il giocatore %d ha ricevuto una carta divieto di sosta", g.getID());
    }

    @Override
    public void stampa() {
        if(! this.getGiocatoriSuCella().isEmpty())
            System.out.print (String.format("[ Di[%d]So ]" , this.getGiocatoriSuCella().size()));
        else System.out.print("[  DivSo  ]");
    }

    @Override
    public String toString() {
        return "Componente 'Divieto di sosta' in posizione " + getPosizione();
    }
}
