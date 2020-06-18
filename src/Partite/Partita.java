package Partite;

import GiocoEtabellone.Tabellone;

import java.io.File;
import java.io.IOException;

public interface Partita {

    /**
     * Il metodo fa partire una partita in modalità in maniera interattiva
     */
    void partitaInterattiva();

    /**
     * IL metodo fa iniziare una partita in modalità simulata
     */
    void partitaSimulata();

    /**
     * Il metodo serve a chidere all'utente tutte le informazioni inerenti alla
     * partita, quali ad esempio numero di giocatori, tipo di Gioco, numero
     * e tipo di componenti da aggiungere. In base a queste informazionoi
     * crea tutta la "struttura"
     */
    void chiediInformazioniSuPartita();


    /**
     * Con questo metodo si costruisce una partita con tutte le informazioni
     * di default(il tabellone). Quindi crea una configurazione del tabellone
     * con informazioni standard.
     */
    void costruisciPartitaStandard();

    /**
     * Con questo metodo carichiamo l'impostazione della partita su file. Carichiamo quindi tutte le informazioni
     * relative alla partita che ne definiscono la configurazione.
     * Al momento il file è caricato nella directory di progetto
     */
    boolean caricaSuFile(String nomeFile) throws IOException;

    /**
     * Carica l'impostazione della partita da un file, che si trova nella directory di progetto.
     * @return true se il caricamento della configurazione da file va a buon fine
     */
    boolean caricaDaFile(String nomeFile);


    Tabellone getTabellone();

}
