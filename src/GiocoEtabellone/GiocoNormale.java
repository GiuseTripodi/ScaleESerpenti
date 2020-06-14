package GiocoEtabellone;

import Componenti.Premio;
import Giocatore.Giocatore;
/**
 *La classe implementa le funzionalità di una partita semplci, in cui
 * semplicemente un giocatore lancia i dadi ed in base all'esito si comporta
 * di conseguenza
 */
public class GiocoNormale extends AbstractGioco {
    private final int numDadi;

    public GiocoNormale(Tabellone tabellone, int numDadi){
        super(tabellone);
        this.numDadi = numDadi;

    }

    /**
     * Il metodo implementa la logica di una singola mossa fatta da un giocatore
     * g, in un gioco semplice.
     * @param giocatore, Giocatore che sta eseguendo la mossa
     */
    @Override
    public void mossa(Giocatore giocatore) {
        //rimuovo il giocatore dall'ultima cella in cui si trovava
        rimuoviDaUltimaCella(giocatore);
        //faccio la mossa
        int risLancio = this.lancio(numDadi);
        muovi(giocatore, risLancio);
        //verifico se il giocatore ha ottenuto un particolare premio
        verificaPremio(giocatore, risLancio);

    }//mossa



}
