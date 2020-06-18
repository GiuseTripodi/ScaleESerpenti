package Partite;

import Builder.*;
import Giocatore.Giocatore;
import GiocoEtabellone.*;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public abstract class AbstractPartita implements Partita{
    protected Tabellone tabellone;
    protected Gioco gioco;
    protected LinkedList<Giocatore> giocatori;
    //informazioni sulla configurazione del gioco
    protected int numGiocatoriStandard;
    protected int nR ;
    protected int nC ;
    protected int nCelle ;
    protected int nScale ;
    protected int nSoste;
    protected int nSerpenti;
    protected int nPremi ;
    protected int nPesca ;
    protected int nPescaUlteriori;
    protected int numDadi = 2;
    protected int codiceDelTipoDiGioco;

    public AbstractPartita(){
    }

    public AbstractPartita(Tabellone tabellone, Gioco gioco, LinkedList<Giocatore> giocatori) {
        this.tabellone = tabellone;
        this.gioco = gioco;
        this.giocatori = giocatori;
    }

    @Override
    public boolean caricaDaFile(String nomeFile) {
        try {
            StringTokenizer st;
            BufferedReader bf = new BufferedReader(new FileReader(nomeFile));
            bf.readLine();bf.readLine();
            //Informazioni sul gioco
            st = new StringTokenizer(bf.readLine(), "=");st.nextToken();
            codiceDelTipoDiGioco = Integer.parseInt(st.nextToken().trim());
            if(codiceDelTipoDiGioco <1 || codiceDelTipoDiGioco >3)throw new ValoreNonConsentitoException("Valore di gioco non consentito");

            st = new StringTokenizer(bf.readLine(), "=");st.nextToken();
            numDadi = Integer.parseInt(st.nextToken().trim());
            if(numDadi < 1 || numDadi > 2)throw new ValoreNonConsentitoException("Valore di gioco non consentito");

            //Informazioni sul tabellone
            bf.readLine();

            st = new StringTokenizer(bf.readLine(), "=");st.nextToken();
            nR = Integer.parseInt(st.nextToken().trim());
            if(nR < 1 || nR > 100)throw new ValoreNonConsentitoException("Valore di gioco non consentito");

            st = new StringTokenizer(bf.readLine(), "=");st.nextToken();
            nC = Integer.parseInt(st.nextToken().trim());
            if(nC < 1 || nC > 100)throw new ValoreNonConsentitoException("Valore di gioco non consentito");

            nCelle = nR * nC;

            st = new StringTokenizer(bf.readLine(), "=");st.nextToken();
            nScale = Integer.parseInt(st.nextToken().trim());
            if(nScale < 0 || nScale > nCelle)throw new ValoreNonConsentitoException("Valore di gioco non consentito");

            st = new StringTokenizer(bf.readLine(), "=");st.nextToken();
            nSerpenti = Integer.parseInt(st.nextToken().trim());
            if(nSerpenti < 1 || nSerpenti > nCelle)throw new ValoreNonConsentitoException("Valore di gioco non consentito");

            st = new StringTokenizer(bf.readLine(), "=");st.nextToken();
            nSoste = Integer.parseInt(st.nextToken().trim());
            if(nSoste < 1 || nSoste > nCelle)throw new ValoreNonConsentitoException("Valore di gioco non consentito");

            st = new StringTokenizer(bf.readLine(), "=");st.nextToken();
            nPremi = Integer.parseInt(st.nextToken().trim());
            if(nPremi < 1 || nPremi > nCelle)throw new ValoreNonConsentitoException("Valore di gioco non consentito");

            st = new StringTokenizer(bf.readLine(), "=");st.nextToken();
            nPesca = Integer.parseInt(st.nextToken().trim());
            if(nPesca < 1 || nPesca > nCelle)throw new ValoreNonConsentitoException("Valore di gioco non consentito");

            st = new StringTokenizer(bf.readLine(), "=");st.nextToken();
            nPescaUlteriori = Integer.parseInt(st.nextToken().trim());
            if(nPescaUlteriori < 1 || nPescaUlteriori > nCelle)throw new ValoreNonConsentitoException("Valore di gioco non consentito");

            //informazioni sui giocatori
            bf.readLine();

            st = new StringTokenizer(bf.readLine(), "=");st.nextToken();
            numGiocatoriStandard = Integer.parseInt(st.nextToken().trim());
            if(numGiocatoriStandard < 1 || numGiocatoriStandard > 10)throw new ValoreNonConsentitoException("Valore di gioco non consentito");

            //Costruisco la struttura e la setto
            //costruisco il tabellone e lo setto
            Tabellone tabellone = costruisciTabelloneConParametri(nR,nC,nCelle,nScale,nSerpenti,nSoste,nPremi,nPesca,nPescaUlteriori);
            setTabellone(tabellone);
            //Costruisco il gioco e lo setto
            Gioco gioco = creaGiocoDaCodice(codiceDelTipoDiGioco);
            setGioco(gioco);

            //creo i Giocatorie e li imposto
            LinkedList<Giocatore> giocatori = creaGiocatoriConParametri(numGiocatoriStandard,gioco);
            setGiocatori(giocatori);




            return true;


        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
        catch (NumberFormatException e){
            System.out.println("Mi dispiace ma quelche valore inserito non è corretto");
            System.exit(1);
            return false;

        } catch (ValoreNonConsentitoException e) {
            System.out.println("Qualche valore inserito non è corretto per configurare il sistema");
            System.exit(1);
            return false;
        }


    }

    @Override
    public boolean caricaSuFile(String nomeFile){
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(nomeFile));
            pw.println("Configurazione partita Scale e Serpenti");
            pw.println("Informazioni Gioco");
            pw.println("Codice del tipo di Gioco = " + codiceDelTipoDiGioco);
            pw.println("Numero dadi = " + numDadi);
            pw.println("Informazioni Tabellone");
            pw.println("Numero righe = " + nR);
            pw.println("Numero Colonne = " + nC);
            pw.println("Numero Scale = " + nScale);
            pw.println("Numero Serpenti = " + nSerpenti);
            pw.println("Numero Soste = " + nSoste);
            pw.println("Numero Premi = " + nPremi);
            pw.println("Numero Pesca una carta = " + nPesca);
            pw.println("Numero Pesca una carta con ulteriori carte = " + nPescaUlteriori);
            pw.println("Informazioni sul numero di giocatori");
            pw.println("Numero Giocatori = " + numGiocatoriStandard);
            pw.close();
            return true;
        }catch (IOException e){
            e.printStackTrace();
            return false;

        }


    }


    /**
     * Il metodo dato alcuni parametri ricevuti che riguardano il tabellone , crea un builder
     * e con quello istanzioa un tabellone, che ha come parametri quelli ripostati nel metodo
     * è essenzialmente un metodo di supporto per la creazione
     * @param nR numero righe
     * @param nC numero colonne
     * @param nCelle numero Celle
     * @param nScale numero Scale
     * @param nSerpenti numero Serpenti
     * @param nSoste numero soste
     * @param nPremi numero Premi
     * @param nPesca numero di celle Pesca una carta
     * @param nPescaUlteriori numero di celle pesca una carta con l'opzioni di avere ulteriori carte
     * @return il tabellone costruito con gli specifici parametri indicati
     */
    protected Tabellone costruisciTabelloneConParametri(int nR, int nC, int nCelle, int nScale, int nSerpenti, int nSoste, int nPremi, int nPesca, int nPescaUlteriori){
        Builder builder = new ConcreteBuilder();
        builder.buildTabellone(nR,nC,nCelle);
        builder.buildCaselleScale(nScale);
        builder.buildCaselleSerpenti(nSerpenti);
        builder.buildCaselleSosta(nSoste);
        builder.buildCasellePremio(nPremi);
        builder.buildCasellePescaUnaCarta(nPesca);
        builder.buildCasellePescaUnaCartaConUlterioriCarte(nPescaUlteriori);
        return builder.getResult();
    }

    /**
     * Metodo di suppporto per creare i giocatori, dato il loro numero ed
     * il particolare tipo di gioco a cui si stanno riferendo
     * @param nGiocatori numero di giocatori da crare
     * @param gioco gioco a cui ci si sta riferendo
     * @return una linkedList con all'interno i giocatori creati
     */
    protected LinkedList<Giocatore> creaGiocatoriConParametri(int nGiocatori, Gioco gioco){
        LinkedList<Giocatore> giocatori = new LinkedList<Giocatore>();
        for(int i = 0; i< nGiocatori; i++){
            Giocatore g = new Giocatore(i,gioco);
            giocatori.add(g);
        }
        return giocatori;

    }

    protected Gioco creaGiocoDaCodice(int codiceDelTipoDiGioco){
        Gioco gioco = null;
        if(codiceDelTipoDiGioco == 1) { gioco = new GiocoNormale(tabellone,numDadi); }
        if(codiceDelTipoDiGioco == 2) { gioco = new GiocoDoppioSei(tabellone); }
        if(codiceDelTipoDiGioco == 3) { gioco = new GiocoUnSoloDadoFinale(tabellone); }
        return gioco;
    }

    /**
     * Metodo di supporto che serve a verificare se una partita è terminata
     * data la situazione dei giocatori verifica se uno dei giocatori ha terminato
     * la partita
     * @param terminatoGiocatori arrey con contenente la "situazione" dei giocator
     * @return true se la partita è terminata, false altrimenti
     */
    protected boolean partitaTerminata(boolean[] terminatoGiocatori){
        for(boolean giocatoreTerminato : terminatoGiocatori){
            if(giocatoreTerminato) return true;
        }
        return false;
    }


    public void setTabellone(Tabellone tabellone) {
        this.tabellone = tabellone;
    }

    public void setGioco(Gioco gioco) {
        this.gioco = gioco;
    }


    public void setGiocatori(LinkedList<Giocatore> giocatori) {
        this.giocatori = giocatori;
    }

    public Tabellone getTabellone() {
        return tabellone;
    }
}
