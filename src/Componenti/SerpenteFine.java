package Componenti;

import Giocatore.Giocatore;
import SupportClass.Posizione;

public class SerpenteFine extends AbstractComponent {
    private SerpenteInizio serpenteInizio;

    public SerpenteFine(Posizione p, SerpenteInizio serpenteInizio){
        super(p);
        this.serpenteInizio = serpenteInizio;
    }

    @Override
    public void azione(Giocatore g) {
        serpenteInizio.azione(g);

    }

    @Override
    public void stampa() {
        if(! this.getGiocatoriSuCella().isEmpty())
            System.out.print(String.format("[ Se[%d]Fi ]", getGiocatoriSuCella().size()));
        else System.out.print("[  SerFi  ]");
    }

    @Override
    public String toString() {
        return "Componente 'SerpenteFine' in posizione " + getPosizione();
    }
}
