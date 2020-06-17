package Partite;

import Builder.*;
import Giocatore.Giocatore;
import GiocoEtabellone.*;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class PartitaInterfacciaRigaDiComando extends AbstractPartita {

    //decidere se cancellare il costruttore, per dare l'accesso solo con i metodi che creano una partita standard o con parametri indicati dall'utente
    public PartitaInterfacciaRigaDiComando(Tabellone tabellone, Gioco gioco, Builder builder, LinkedList<Giocatore> giocatori) {
        super(tabellone, gioco, builder, giocatori);
    }

    public PartitaInterfacciaRigaDiComando(){
        super();
    }


    @Override
    public void partitaInterattiva() {
        boolean[] terminatoGiocatore = new boolean[giocatori.size()];
        for (int i = 0; i < giocatori.size(); i++) terminatoGiocatore[i] = false;
        int numeroTurno = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Premi invio per fare andare avanti il gioco....");
        while(scanner.nextLine() != null){
            if(! partitaTerminata(terminatoGiocatore)) {
                System.out.println("****************************");
                System.out.printf("***** Turno numero : %d ***** \n", numeroTurno);
                System.out.println("****************************");
                for (int i = 0; i < giocatori.size(); i++) {
                    Giocatore giocatore = giocatori.get(i);
                    System.out.println("------------------------------------------------");
                    System.out.println("Giocatore n :  " + giocatore.getID() +" ; Posizione Prima del lancio " + giocatore.getPosizione());
                    terminatoGiocatore[i] = giocatore.lancio();
                    System.out.println("Giocatore n :  " + giocatore.getID() +" ; Posizione Dopo il lancio " + giocatore.getPosizione());
                }
                numeroTurno++;
                System.out.println("------------------------------------------------");
                tabellone.stampa();
            }
            else {
                System.out.println("****PARTITA TERMINATA****");
                scanner.close();
                return;

            }

        }//while

    }

    @Override
    public void partitaSimulata() {
        boolean[] terminatoGiocatore = new boolean[giocatori.size()];
        for (int i = 0; i < giocatori.size(); i++) terminatoGiocatore[i] = false;

        int numeroTurno = 0;
        while (! partitaTerminata(terminatoGiocatore)) {
            System.out.println("****************************");
            System.out.printf("***** Turno numero : %d ***** \n", numeroTurno);
            System.out.println("****************************");
            for (int i = 0; i < giocatori.size(); i++) {
                Giocatore giocatore = giocatori.get(i);
                System.out.println("------------------------------------------------");
                System.out.println("Giocatore n :  " + giocatore.getID() +" ; Posizione Prima del lancio " + giocatore.getPosizione());
                terminatoGiocatore[i] = giocatore.lancio();
                System.out.println("Giocatore n :  " + giocatore.getID() +" ; Posizione Dopo il lancio " + giocatore.getPosizione());
            }
            numeroTurno++;
        }
        System.out.println("****PARTITA TERMINATA****");
    }

    /**
     * Da notare che quest implementazione al momento non fa alcun controllo
     * sui valori inseriti dall'utente.
     */
    @Override
    public void chiediInformazioniSuPartita() {
        int numGiocatoriStandard;
        int numDadiStandard;
        int nR ;
        int nC ;
        int nCelle ;
        int nScale ;
        int nSoste;
        int nSerpenti;
        int nPremi ;
        int nPesca ;
        int nPescaUlteriori;

        int numDadi = 2;

        int codiceDelTipoDiGioco;

        Scanner scanner = new Scanner(System.in);
        //chiedo le informazioni
        System.out.println("*********************************");
        System.out.println("*      Scale e Serpenti         *");
        System.out.println("*********************************");
        //chiedo le informazioni sul tabellone
        System.out.println("------------------------------------------------");
        System.out.println("-----Sceglio il tipo di gioco-----\n" +
                "Inserisci il numero corrispondente al gioco \n" +
                "1. Gioco Normale \n" +
                "2. Gioco con impostazione doppio sei \n" +
                "3. Gioco con un solo dado nelle mosse finali");
        codiceDelTipoDiGioco = Integer.parseInt(scanner.nextLine().trim());
        //faccio inserire il numero di dadi
        if(codiceDelTipoDiGioco == 1){
            System.out.println("Inserisci il numero di dadi con cui giocare");
            numDadi = Integer.parseInt(scanner.nextLine().trim());
        }
        System.out.println("------------------------------------------------");
        System.out.println("----Inserisci le impostazioni del tabellone----");
        System.out.println("Inserisci il numero di righe:");
        nR = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("Inserisci il numero di colonne:");
        nC = Integer.parseInt(scanner.nextLine().trim());
        //costruisco il numero di celle
        nCelle = nC * nR;
        System.out.println("Inserisci il numero di scale che vuoi inserire:");
        nScale = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("Inserisci il numero di Serpenti che vuoi inserire:");
        nSerpenti = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("Inserisci il numero di caselle di sosta che vuoi inserire:");
        nSoste = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("Inserisci il numero di caselle con premi che vuoi inserire:");
        nPremi = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("Inserisci il numero di caselle pesca una carta che vuoi inserire:");
        nPesca = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("Inserisci il numero di caselle pesca una carta con ulteriori carte che vuoi inserire:");
        nPescaUlteriori = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("------------------------------------------------");
        System.out.println("Inserisci il numero di giocatori che possono partecipare la gioco");
        numGiocatoriStandard = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("------------------------------------------------");

        //costruisco il tabellone
        Tabellone tabellone = costruisciTabelloneConParametri(nR,nC,nCelle,nScale,nSerpenti,nSoste,nPremi,nPesca,nPescaUlteriori);
        //Costruisco il gioco
        Gioco gioco = null;
        if(codiceDelTipoDiGioco == 1) { gioco = new GiocoNormale(tabellone,numDadi); }
        if(codiceDelTipoDiGioco == 2) { gioco = new GiocoDoppioSei(tabellone); }
        if(codiceDelTipoDiGioco == 3) { gioco = new GiocoUnSoloDadoFinale(tabellone); }
        //creo i Giocatori
        LinkedList<Giocatore> giocatori = creaGiocatoriConParametri(numGiocatoriStandard,gioco);

        //imposto le informazioni nella partita
        setTabellone(tabellone);
        setGioco(gioco);
        setGiocatori(giocatori);
        
    }//chiedi informazioni su partita

    @Override
    public void costruisciPartitaStandard() {
        //informazioni standard
        int numGiocatoriStandard = 4;
        int numDadiStandard = 2;
        int nR = 10;
        int nC = 10;
        int nCelle = 100;
        int nScale = 5;
        int nSoste = 5;
        int nSerpenti = 5;
        int nPremi = 5;
        int nPesca = 5;
        int nPescaUlteriori = 5;

        //costruisco il tabellone
        Tabellone tabellone = costruisciTabelloneConParametri(nR,nC,nCelle,nScale,nSerpenti,nSoste,nPremi,nPesca,nPescaUlteriori);

        //costruisco un Gioco normale
        Gioco gioco = new GiocoNormale(tabellone,numDadiStandard);

        //creo i Giocatori
        LinkedList<Giocatore> giocatori = creaGiocatoriConParametri(numGiocatoriStandard,gioco);

        //imposto le informazioni nella partita
        setTabellone(tabellone);
        setGioco(gioco);
        setGiocatori(giocatori);


    }//costruisci partita standard

    @Override
    public Tabellone getTabellone() {
        return super.getTabellone();
    }
}
