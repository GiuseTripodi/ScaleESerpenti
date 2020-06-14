package Componenti;

import Giocatore.Giocatore;
import SupportClass.Posizione;

public abstract class AbstractComponent implements StateComponent {
    private Giocatore giocatore; //se è diverso da null indica che sullo specifico componente è presente un giocatore
    private Posizione posizione;

    public AbstractComponent(Posizione p){
        this.posizione = p;
        this.giocatore = null;
    }

    @Override
    public void setGiocatoreSuCella(Giocatore g) {
        giocatore = g;
    }

    @Override
    public Giocatore getGiocatore(){
        return giocatore  ;
    }

    @Override
    public void removeGiocatoreDaCella() {
        giocatore = null;
    }

    @Override
    public void azione(Giocatore g) {
        g.setPosizione(this.getPosizione());
        this.setGiocatoreSuCella(g);
    }

    public Posizione getPosizione(){
        return this.posizione;
    }

    public String toString(){
        return "Il componente si trova in posizione " + posizione;
    }


}
