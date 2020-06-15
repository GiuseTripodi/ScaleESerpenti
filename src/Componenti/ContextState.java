package Componenti;

import Giocatore.Giocatore;
import SupportClass.Posizione;

import java.util.LinkedList;

/**
 * La classe ha la funzione della classe context nel Pattern State, ovvero è la classe che in base al suo stato
 * interno cambia il comportamento. Lo stato interno è di tipo State Component, la gestione dei metodi è dipendente
 * dallo stato interno
 */
public class ContextState {
    private StateComponent state;
    private Posizione posizione;


    public ContextState(Posizione posizione){
        this.posizione = posizione;
        /*
        Lo stato di Default di un componente è appunto quello di default
        che fa solo lo spostamento della posizione
         */
        this.state = new Default(posizione);
    }

    /**
     * Il metodo imposta lo stato del componente, se lo stato è quello di default significa
     * che si può sovrascrivere altrimenti uno stato è già stato impostato
     * @param state
     * @return true se lo stato è stato impostato, altrimenti se non si può impostare lo stato restitusisce false.
     */
    public boolean setState(StateComponent state){
        if(this.state instanceof Default){
            this.state = state;
            return true;
        }
        return false;
    }

    public void gestisciComponente(Giocatore giocatore){

        state.azione(giocatore);
    }

    public void stampa(){
         state.stampa();
    }

    public String toString(){
         return state.toString();
    }

    public void setGiocatoreSuCella(Giocatore g){
        state.setGiocatoreSuCella(g);
    }

    public LinkedList<Giocatore> getGiocatoriSuCella(){
        return state.getGiocatoriSuCella() ;
    }

    public void removeGiocatoreDaCella(Giocatore giocatore) {

        state.removeGiocatoreDaCella(giocatore);
    }




}
