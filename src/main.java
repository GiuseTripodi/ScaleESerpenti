import Partite.*;

/**
 * La classe indica tutte le possibili scelte per interagire con il sistema, solo a scopo indicativo. L'appicazione
 * effettiva si ottiene eseguendo la classe application
 */

public class main {
    public static void main(String ... args){

        //Accedo a tutte le funzioni solo con l'interfccia Partita
        Partita partita = new PartitaInterfacciaRigaDiComando();

        /*
        Faccio partire un funzionalità che permette all'utente di inserire la configurazione del sistema
         */
        //partita.chiediInformazioniSuPartita();

        /*
        La partita è costruita secondo una configurazione standard, con valori prestabiliti
         */
        //partita.costruisciPartitaStandard();

        /*
        La partita è fatta partire in modalità interattiva, con l'utente che seleziona l'avanzamento dei turni di gioco
         */
        //partita.partitaInterattiva();
        /*
        La partita è in modalità simulata
         */
        //partita.partitaSimulata();

        /*
        Si può scegliere di caricare la configurazione della partita su un file
         */
        //partita.caricaSuFile("configurazionePartita.txt");

        /*
        Si può scegliere di scegliere una configurazione precedentemente definita su un file
         */
        //partita.caricaDaFile("configurazionePartita.txt");


    }
}
