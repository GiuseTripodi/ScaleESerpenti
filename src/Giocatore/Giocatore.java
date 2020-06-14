package Giocatore;

import Componenti.Premio;
import GiocoEtabellone.Gioco;
import SupportClass.Posizione;

public class Giocatore {
    private int turniStop; //tuni di stop del giocatore
    private Posizione posizione; //posizione sul tabellone
    private Gioco gioco; //specifico Gioco a cui sta giocando
    private final int ID; //identificatore del giocatore
    private Premio premio; //eventuale premio ricevuto
    private boolean premioRicevuto;
    private boolean cartaDivietoDiSosta; //indica se il giocatore è in possesso di una carta di tipoDIvietoDiSosta

    public Giocatore(int ID, Gioco gioco){
        this.ID = ID;
        this.premioRicevuto = false;
        this.turniStop = 0;
        this.gioco = gioco;
        this.cartaDivietoDiSosta = false;
        this.posizione = new Posizione(0,0,0);
    }

    /**
     * Metodo invocato che indica che il giocatore ha vinto uno specifico premio
     * @param premio
     */
    public void assegnaPremio(Premio premio){
        this.premio = premio;
    }

    /**
     * Il metodo permette di indicare che il premio che era stato assegnato
     * per il giocatore è stato già speso.
     */
    public void consumaPremio(){
        this.premio = null;
    }

    /**
     * Indica se il giocatore ha vinto un particolare premio
     * @return
     */
    public Premio getPremio() {
        return premio;
    }

    /**
     * Il metodo indica che il giocatore è riuscito ad ottenere una carta
     * di tipo divieto di sosta
     */
    public void setCartaDivietoDiSosta(){
        this.cartaDivietoDiSosta = true;
    }

    /**
     * Il metodo indica che il giocatore ha usato la carta divietodiSosta
     * di cui era in possesso
     */
    public void consumaCartaDivietoDiSosta(){
        this.cartaDivietoDiSosta = false;

    }

    public boolean getCartaDivietoDiSosta(){
        return cartaDivietoDiSosta;
    }

    /**
     * Il metodo implenta la logica del lancio,
     */
    public void lancio(){
        if(turniStop != 0){
            turniStop -= 1;
            return;
        }
        gioco.mossa(this); //passo il giocatore stesso
    }

    public void setTurniStop(int turniStop) {
        this.turniStop = turniStop;
    }

    public void setPosizione(Posizione posizione) {
        this.posizione = posizione;
    }

    public Posizione getPosizione() {
        return posizione;
    }

    public String toString(){
        return String.format("Il giocatore %d si trova in posizione %d", ID, posizione.getNumeroCella());
    }

    public int getID() {
        return ID;
    }
}
