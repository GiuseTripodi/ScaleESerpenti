package GiocoEtabellone;

import Giocatore.Giocatore;

import java.util.Random;

/**
 * Definisce l'interfaccia comune per le funzioni di un particolare
 * tipo di Gioco
 */
public interface Gioco {

    /**
     * Implementa la logica da seguire per il particolare tipo di gioco
     * @param g
     */
    public void mossa(Giocatore g);

    default int lancio(int numDadi) {
        int lancio = 0;
        Random r = new Random();
        for(int i = 0; i< numDadi; i++)
            lancio += r.nextInt(6) + 1; //il nexint calcola un numero da 0 ad N-1
        return lancio;


    }

    public int getNumeroCelleTabellone();

    public int getNumeroColonneTabellone();

    public int getNumeroRigheTabellone();




}
