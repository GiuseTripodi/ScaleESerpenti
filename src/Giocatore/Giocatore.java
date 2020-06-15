package Giocatore;

import Componenti.Premio;
import GiocoEtabellone.Gioco;
import SupportClass.Posizione;

import java.util.Objects;

public class Giocatore implements Cloneable{
    private int turniStop; //tuni di stop del giocatore
    private Posizione posizione; //posizione sul tabellone
    private Gioco gioco; //specifico Gioco a cui sta giocando
    private final int ID; //identificatore del giocatore
    private Premio premio; //eventuale premio ricevuto
    private boolean premioRicevuto;
    private boolean cartaDivietoDiSosta; //indica se il giocatore è in possesso di una carta di tipoDIvietoDiSosta

    //costruttore per test
    public Giocatore(){
        this.ID = 0;
    }


    public Giocatore(int ID, Gioco gioco){
        this.ID = ID;
        this.premioRicevuto = false;
        this.turniStop = 0;
        this.gioco = gioco;
        this.cartaDivietoDiSosta = false;
        this.posizione = new Posizione(0,0,0);
        //imposto le variabili del tabellone
        int nR = gioco.getNumeroRigheTabellone();
        int nC = gioco.getNumeroColonneTabellone();
        int nCelle = gioco.getNumeroCelleTabellone();
        //this.posizione.setInformazioniTabellone(4,5,20);
        this.posizione.setInformazioniTabellone(nR,nC,nCelle);
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
     * @return true se il giocatore è arrivato in ultima posizione, altrimenti restituisce false;
     */
    public boolean lancio(){
        if(turniStop != 0){
            turniStop -= 1;
            return false;
        }
        gioco.mossa(this); //passo il giocatore stesso
        //verifico se il giocatore è arrivato nella posizione finale
        if(this.posizione.getNumeroCella() == gioco.getNumeroCelleTabellone() -1){
            System.out.println("Il giocatore " + ID + " ha terminato il gioco");
            return true;
        }
        return false;
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


   public Giocatore clone(){
        try{
            Giocatore ret = (Giocatore)super.clone();
            return ret;

        }catch (CloneNotSupportedException e){
            throw new Error(e);
        }
   }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Giocatore giocatore = (Giocatore) o;
        return ID == giocatore.ID &&
                Objects.equals(posizione, giocatore.posizione);
    }

    @Override
    public int hashCode() {
        return Objects.hash(posizione, ID);
    }
}
