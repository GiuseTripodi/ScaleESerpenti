package Componenti;

import Giocatore.Giocatore;
import SupportClass.Posizione;

import java.util.LinkedList;

public abstract class AbstractComponent implements StateComponent {
    private LinkedList<Giocatore> giocatoriSuCella; //indica l'insieme di giocatori che sono presenti su una particolare cella
    private Posizione posizione;

    public AbstractComponent(Posizione p){
        this.posizione = p;
        this.giocatoriSuCella = new LinkedList<>();
    }

    @Override
    public void setGiocatoreSuCella(Giocatore g) {
        giocatoriSuCella.add(g.clone());
    }

    @Override
    public LinkedList<Giocatore> getGiocatoriSuCella(){
        return giocatoriSuCella  ;
    }

    @Override
    public void removeGiocatoreDaCella(Giocatore giocatore) {
        giocatoriSuCella.remove(giocatore);
    }

    @Override
    public void azione(Giocatore g) {
        g.setPosizione(this.posizione);
        this.setGiocatoreSuCella(g);
    }

    public Posizione getPosizione(){
        return this.posizione;
    }

    public String toString(){
        return "Il componente si trova in posizione " + posizione;
    }


}
