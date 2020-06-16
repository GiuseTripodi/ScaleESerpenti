package GiocoEtabellone;

import Componenti.AbstractComponent;
import Componenti.ContextState;
import Componenti.Default;
import Componenti.StateComponent;
import SupportClass.Posizione;

/**
 * La classe implementa il tabellone sui cui si svolgerà il gioco, e sui cui saranno
 * poi aggiunti i vari componenti(Sfruttanto il builder)
 */
public class ConcreteTabellone implements Tabellone {
    private int numeroCelle; // per N celle, le celle sono numerate da 0 a N -1
    private int numRighe;
    private int numColonne;
    private ContextState[][] mappa;

    public ConcreteTabellone(){

    }

    public ConcreteTabellone(int numRighe, int numColonne,int numeroCelle){
        this.numeroCelle = numeroCelle;
        this.numRighe = numRighe;
        this.numColonne = numColonne;
        //creo il tabellone
        mappa = new ContextState[numRighe][numColonne];
        int numCella = 0;
        for(int i = 0; i < numRighe; i++){
            for(int j = 0; j < numColonne; j++){
                Posizione p = new Posizione(i,j,numCella);
                p.setInformazioniTabellone(numRighe,numColonne,numeroCelle);
                mappa[i][j] = new ContextState(p);
                numCella++;
            }
        }
    }


    /**
     * Dato un componente il metodo lo aggiunge allo specifico tabbellone
     * @param component, componente da aggiunger
     * @return true se si è riusciti ad aggiungere il componente
     */
    @Override
    public boolean add(StateComponent component) {
        int iR = component.getPosizione().getIndiceRiga();
        int iC = component.getPosizione().getIndiceColonna();
        /*
        verifico che il componente da aggiungere non venga aggiunto nell'ultima cella
        pechè cià per particolari componenti può portare il gioco a non terminare ed a entrare
        in loop

        */
        if(iR == this.numRighe-1 && iC == this.numColonne -1)
            return false;
        boolean ret = mappa[iR][iC].setState(component);
        return ret;
    }

    @Override
    public void remove(StateComponent component) {
        int iR = component.getPosizione().getIndiceRiga();
        int iC = component.getPosizione().getIndiceColonna();
        Posizione posizione = component.getPosizione();
        Default def = new Default(posizione);
        mappa[iR][iC].removeState(def);

    }

    @Override
    public ContextState getCella(int indiceRiga, int indiceColonna) {
        return mappa[indiceRiga][indiceColonna];
    }


    public void stampa(){
        for(int i = 0; i < numRighe; i++){
            for(int j = 0; j < numColonne; j++){
                mappa[i][j].stampa();
            }
            System.out.println("\n");
        }

    }


    @Override
    public int getNumeroCelle() {
        return numeroCelle;
    }

    @Override
    public int getNumRighe() {
        return numRighe;
    }

    @Override
    public int getNumColonne() {
        return numColonne;
    }
}
