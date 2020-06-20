package Componenti;

import Giocatore.Giocatore;
import SupportClass.Posizione;

public class Sosta extends AbstractComponent {
    //turni di stop panchina = 1; turni di stop locanda = 3
    public enum TipoSosta {PANCHINA, LOCANDA}
    private TipoSosta tipoSosta;
    private int turniStop;

    public Sosta(Posizione p,TipoSosta tipoSosta ){
        super(p);
        this.tipoSosta = tipoSosta;
        if(tipoSosta == TipoSosta.PANCHINA)turniStop = 1;
        if(tipoSosta == TipoSosta.LOCANDA)turniStop = 3;

    }

    @Override
    public void azione(Giocatore g) {
        super.azione(g);
        //verifico se il giocatore ha memorizzato al suo interno una carta divieto di sosta
        if(! g.getCartaDivietoDiSosta()){
            g.setTurniStop(turniStop);
            System.out.printf("Il giocatore %d ha ricevuto %d turni di stop", g.getID(), turniStop);
        }
        //consumo la carta divieto di sosta
        g.consumaCartaDivietoDiSosta();

    }

    @Override
    public void stampa() {
        if(! this.getGiocatoriSuCella().isEmpty())
            System.out.print(String.format("[ So[%d]ta ]", this.getGiocatoriSuCella().getFirst().getID()));
        else System.out.print("[  Sosta  ]");
    }

    @Override
    public String toString() {
        return String.format("Componente 'Sosta di tipo %s' in posizione " + getPosizione(),tipoSosta.toString());
    }
}
