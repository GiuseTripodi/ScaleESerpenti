package Partite;

import Builder.*;
import Giocatore.Giocatore;
import GiocoEtabellone.Gioco;
import GiocoEtabellone.Tabellone;

import java.io.File;
import java.util.LinkedList;

public abstract class AbstractPartita implements Partita{
    protected Tabellone tabellone;
    protected Gioco gioco;
    private Builder builder;
    protected LinkedList<Giocatore> giocatori;

    public AbstractPartita(){
    }

    public AbstractPartita(Tabellone tabellone, Gioco gioco, Builder builder, LinkedList<Giocatore> giocatori) {
        this.tabellone = tabellone;
        this.gioco = gioco;
        this.builder = builder;
        this.giocatori = giocatori;
    }

    @Override
    public boolean caricaDaFile(File file) {
        return false;
    }

    @Override
    public boolean caricaSuFile() {
        return false;
    }


    /**
     * Il metodo dato alcuni parametri ricevuti che riguardano il tabellone , crea un builder
     * e con quello istanzioa un tabellone, che ha come parametri quelli ripostati nel metodo
     * è essenzialmente un metodo di supporto per la creazione
     * @param nR
     * @param nC
     * @param nCelle
     * @param nScale
     * @param nSerpenti
     * @param nSoste
     * @param nPremi
     * @param nPesca
     * @param nPescaUlteriori
     * @return
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
     * @param nGiocatori
     * @param gioco
     * @return
     */
    protected LinkedList<Giocatore> creaGiocatoriConParametri(int nGiocatori, Gioco gioco){
        LinkedList<Giocatore> giocatori = new LinkedList<Giocatore>();
        for(int i = 0; i< nGiocatori; i++){
            Giocatore g = new Giocatore(i,gioco);
            giocatori.add(g);
        }
        return giocatori;

    }

    /**
     * Metodo di supporto che serve a verificare se una partita è terminata
     * data la situazione dei giocatori verifica se uno dei giocatori ha terminato
     * la partita
     * @param terminatoGiocatori arrey con contenente la "situazione" dei giocator
     * @return true se la partita è terminata, false altrimenti
     */
    protected boolean partitaTerminata(boolean[] terminatoGiocatori){
        for(int i = 0; i < terminatoGiocatori.length; i++){
            if(terminatoGiocatori[i]) return true;
        }
        return false;
    }


    public void setTabellone(Tabellone tabellone) {
        this.tabellone = tabellone;
    }

    public void setGioco(Gioco gioco) {
        this.gioco = gioco;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public void setGiocatori(LinkedList<Giocatore> giocatori) {
        this.giocatori = giocatori;
    }

    public Tabellone getTabellone() {
        return tabellone;
    }
}
