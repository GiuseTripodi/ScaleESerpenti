package GiocoEtabellone;

import Componenti.ContextState;
import Componenti.StateComponent;
import SupportClass.Posizione;

public interface Tabellone {

    /**
     * metodo invocato per aggiungere un particolare stato al componente
     * @param component
     * @return
     */
    public boolean add(StateComponent component);


    /**
     * Il metodo restituisce il componente associato ad una particolare posizione
     * @param indiceRiga
     * @param indiceColonna
     * @return
     */
    public ContextState getCella(int indiceRiga, int indiceColonna);


    public int getNumeroCelle();
}
