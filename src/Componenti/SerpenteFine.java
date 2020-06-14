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
        if(getGiocatore() != null)
            System.out.print(String.format("[ Se[%d]Fi ]", getGiocatore().getID()));
        System.out.print("[  SerFi  ]");
    }
}
