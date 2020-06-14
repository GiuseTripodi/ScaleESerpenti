package GiocoEtabellone;

import Componenti.AbstractComponent;
import Componenti.ContextState;
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

    public ConcreteTabellone(int numeroCelle,int numRighe, int numColonne ){
        this.numeroCelle = numeroCelle;
        this.numRighe = numRighe;
        this.numColonne = numColonne;
        //creo il tabellone
        mappa = new ContextState[numRighe][numColonne];
        int numCella = 0;
        for(int i = 0; i < numRighe; i++){
            for(int j = 0; j < numColonne; j++){
                mappa[i][j] = new ContextState(new Posizione(i,j,numCella));
                numCella++;
            }
        }
    }


    //@Override
    public boolean add(StateComponent component) {
        int iR = component.getPosizione().getIndiceRiga();
        int iC = component.getPosizione().getIndiceColonna();
        return mappa[iR][iC].setState(component);
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
}
