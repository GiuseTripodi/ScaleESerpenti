package GiocoEtabellone;

import Componenti.ContextState;
import Componenti.StateComponent;
import SupportClass.Posizione;

public interface Tabellone {

    /**
     * metodo invocato per aggiungere un particolare stato al componente
     *
     * @param component
     * @return
     */
    public boolean add(StateComponent component);

    /**
     * Il metodo serve a rimuovere un particolare componente dal tabellon,
     * ripristina lo stato di default.
     * Si usa nei casi in cui un aggiunta non va a buon fine e bisogna rimuovere
     * il componente
     * @param component
     */
    public void remove(StateComponent component);


    /**
     * Il metodo restituisce il componente associato ad una particolare posizione
     *
     * @param indiceRiga
     * @param indiceColonna
     * @return
     */
    public ContextState getCella(int indiceRiga, int indiceColonna);


    public int getNumeroCelle();

    public int getNumRighe();

    public int getNumColonne();

    public void stampa();

}
