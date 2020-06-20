package GiocoEtabellone;

import Componenti.*;
import Giocatore.Giocatore;
import SupportClass.Posizione;
import Componenti.Sosta.*;
import Componenti.Premio.*;

public  abstract class AbstractGioco implements Gioco {
    protected Tabellone tabellone;

    public AbstractGioco(Tabellone tabellone){
        this.tabellone = tabellone;
    }

    public String toString(){
        return tabellone.toString();
    }

    /**
     * Il metodo serve a rimuovere il giocatore dall'ultima cella in
     * cui si trovava
     * @param giocatore
     */
    protected void rimuoviDaUltimaCella(Giocatore giocatore){
        tabellone.getCella(giocatore.getPosizione().getIndiceRiga(),giocatore.getPosizione().getIndiceColonna()).removeGiocatoreDaCella(giocatore);
    }

    /**
     * Con questo metodo spostiamo il giocatore di un valore
     * pari all'esito del lancio dei dadi
     * @param giocatore
     * @param esitoLancio
     */
    protected void muovi(Giocatore giocatore,int esitoLancio){

        Posizione posGiocatore = giocatore.getPosizione();
        Posizione posDopoLancio = posGiocatore.posDopoLancio(esitoLancio);
        giocatore.setPosizione(posDopoLancio);

        //giocatore.getPosizione().posDopoLancio(esitoLancio);
        tabellone.getCella(giocatore.getPosizione().getIndiceRiga(),giocatore.getPosizione().getIndiceColonna()).gestisciComponente(giocatore);

    }

    /**
     * Questo metodo eseguito alla fine verifica se al giocatore
     * è stato assegnato qualche tipo di premio,ed in base a ciò
     * si comporta di conseguenza
     * @param giocatore
     * @param esitoLancio
     */
    protected void verificaPremio(Giocatore giocatore, int esitoLancio){
        if(giocatore.getPremio() != null){
            Premio premio = giocatore.getPremio();
            giocatore.consumaPremio();
            if(premio.getTipoPremio() == Premio.TipoPremio.DADI) mossa(giocatore);
            if(premio.getTipoPremio() == Premio.TipoPremio.MOLLA) {
                rimuoviDaUltimaCella(giocatore);
                muovi(giocatore, esitoLancio);
            }
        }
    }

    public int getNumeroCelleTabellone(){
        return tabellone.getNumeroCelle();
    }

    public int getNumeroRigheTabellone(){
        return tabellone.getNumRighe();
    }

    public int getNumeroColonneTabellone(){

        return tabellone.getNumColonne();
    }

}
