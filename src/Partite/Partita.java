package Partite;

import GiocoEtabellone.Tabellone;

import java.io.File;

public interface Partita {

    /**
     * Il metodo fa partire una partita in modalità in maniera interattiva
     */
    public void partitaInterattiva();

    /**
     * IL metodo fa iniziare una partita in modalità simulata
     */
    public void partitaSimulata();

    /**
     * Il metodo serve a chidere all'utente tutte le informazioni inerenti alla
     * partita, quali ad esempio numero di giocatori, tipo di Gioco, numero
     * e tipo di componenti da aggiungere. In base a queste informazionoi
     * crea tutta la "struttura"
     */
    public void chiediInformazioniSuPartita();


    /**
     * Con questo metodo si costruisce una partita con tutte le informazioni
     * di default(il tabellone). Quindi crea una configurazione del tabellone
     * con informazioni standard.
     */
    public void costruisciPartitaStandard();

    /**
     * Con questo metodo carichiamo l'impostazione della partita su file
     */
    public boolean caricaSuFile();

    /**
     * Carica l'impostazione della partita da un file
     * @return
     */
    public boolean caricaDaFile(File file);


    public Tabellone getTabellone();

}
