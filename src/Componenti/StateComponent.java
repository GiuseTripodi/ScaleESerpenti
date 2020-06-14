package Componenti;

import Giocatore.Giocatore;
import SupportClass.Posizione;

/**
 * L'interfaccia definisce la struttura base dei componenti, con le funzioni che dovono implementare
 */
public interface StateComponent {


    /**
     * Il metodo implementa la logia di gioco propia dello specifico componente
     * @param g
     */
    public void azione(Giocatore g);

    /**
     * Il metodo imposta il fatto che sulla cella attualmente è collocato un giocatore
     */
    public void setGiocatoreSuCella(Giocatore giocatore);

    /**
     * Rimuove il giocatore dalla cella
     */
    public void removeGiocatoreDaCella();

    public Giocatore getGiocatore();

    /**
     * Il metodo stampa in un particolare modo uno specifico componente è
     * usato per la stampa del tabellone, dove serve una particolare rappresentazione
     * del tabellone
     * @return
     */
    public void stampa();

    /**
     *
     * @return Restituisce la posizione del componente
     */
    public Posizione getPosizione();


}
