package Partite;

import Builder.*;
import Giocatore.Giocatore;
import GiocoEtabellone.*;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class PartitaInterfacciaRigaDiComando extends AbstractPartita {


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
        try {
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
            if(codiceDelTipoDiGioco <1 || codiceDelTipoDiGioco >3)throw new ValoreNonConsentitoException("Valore di gioco non consentito");

            //faccio inserire il numero di dadi
            if (codiceDelTipoDiGioco == 1) {
                System.out.println("Inserisci il numero di dadi con cui giocare");
                numDadi = Integer.parseInt(scanner.nextLine().trim());
                if(numDadi < 1 || numDadi > 2)throw new ValoreNonConsentitoException("Valore di gioco non consentito");
            }
            System.out.println("------------------------------------------------");
            System.out.println("----Inserisci le impostazioni del tabellone----");

            System.out.println("Inserisci il numero di righe:");
            nR = Integer.parseInt(scanner.nextLine().trim());
            if(nR < 1 || nR > 100)throw new ValoreNonConsentitoException("Valore di gioco non consentito");

            System.out.println("Inserisci il numero di colonne:");
            nC = Integer.parseInt(scanner.nextLine().trim());
            if(nC < 1 || nC > 100)throw new ValoreNonConsentitoException("Valore di gioco non consentito");

            //costruisco il numero di celle
            nCelle = nC * nR;

            System.out.println("Inserisci il numero di scale che vuoi inserire:");
            nScale = Integer.parseInt(scanner.nextLine().trim());
            if(nScale < 0 || nScale > nCelle)throw new ValoreNonConsentitoException("Valore di gioco non consentito");

            System.out.println("Inserisci il numero di Serpenti che vuoi inserire:");
            nSerpenti = Integer.parseInt(scanner.nextLine().trim());
            if(nSerpenti < 0 || nSerpenti > nCelle)throw new ValoreNonConsentitoException("Valore di gioco non consentito");

            System.out.println("Inserisci il numero di caselle di sosta che vuoi inserire:");
            nSoste = Integer.parseInt(scanner.nextLine().trim());
            if(nSoste < 0 || nSoste > nCelle)throw new ValoreNonConsentitoException("Valore di gioco non consentito");

            System.out.println("Inserisci il numero di caselle con premi che vuoi inserire:");
            nPremi = Integer.parseInt(scanner.nextLine().trim());
            if(nPremi < 0 || nPremi > nCelle)throw new ValoreNonConsentitoException("Valore di gioco non consentito");

            System.out.println("Inserisci il numero di caselle pesca una carta che vuoi inserire:");
            nPesca = Integer.parseInt(scanner.nextLine().trim());
            if(nPesca < 0 || nPesca > nCelle)throw new ValoreNonConsentitoException("Valore di gioco non consentito");

            System.out.println("Inserisci il numero di caselle pesca una carta con ulteriori carte che vuoi inserire:");
            nPescaUlteriori = Integer.parseInt(scanner.nextLine().trim());
            if(nPescaUlteriori < 0 || nPescaUlteriori > nCelle)throw new ValoreNonConsentitoException("Valore di gioco non consentito");

            System.out.println("------------------------------------------------");

            System.out.println("Inserisci il numero di giocatori che possono partecipare la gioco");
            numGiocatoriStandard = Integer.parseInt(scanner.nextLine().trim());
            if(numGiocatoriStandard < 1 || numGiocatoriStandard > 10)throw new ValoreNonConsentitoException("Valore di gioco non consentito");

            System.out.println("------------------------------------------------");

            //costruisco il tabellone
            Tabellone tabellone = costruisciTabelloneConParametri(nR,nC,nCelle,nScale,nSerpenti,nSoste,nPremi,nPesca,nPescaUlteriori);
            setTabellone(tabellone);

            //Costruisco il gioco
            Gioco gioco = creaGiocoDaCodice(codiceDelTipoDiGioco);
            setGioco(gioco);

            //creo i Giocatori
            LinkedList<Giocatore> giocatori = creaGiocatoriConParametri(numGiocatoriStandard,gioco);
            setGiocatori(giocatori);


        } catch (ValoreNonConsentitoException e) {
            System.out.println("Qualche valore inserito non è corretto per configurare il sistema");
            System.exit(1);


        }catch (NumberFormatException e) {
            System.out.println("Ha inserito qualche valore non corretto");
            System.exit(1);

        }


    }//chiedi informazioni su partita

    @Override
    public void costruisciPartitaStandard() {
        //informazioni standard
        this.numGiocatoriStandard = 4;
        this.numDadi = 2;
        this.nR = 10;
        this.nC = 10;
        this.nCelle = 100;
        this.nScale = 5;
        this.nSoste = 5;
        this.nSerpenti = 5;
        this.nPremi = 5;
        this.nPesca = 5;
        this.nPescaUlteriori = 5;
        this.codiceDelTipoDiGioco = 1;

        //costruisco il tabellone
        Tabellone tabellone = costruisciTabelloneConParametri(nR,nC,nCelle,nScale,nSerpenti,nSoste,nPremi,nPesca,nPescaUlteriori);

        //costruisco un Gioco normale
        Gioco gioco = new GiocoNormale(tabellone,numDadi);

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
