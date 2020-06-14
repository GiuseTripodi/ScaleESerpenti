package Componenti;

import Giocatore.Giocatore;
import SupportClass.Posizione;

public class ScalaInizio extends AbstractComponent{
    private ScalaFine scalaFine;

    public ScalaInizio(Posizione p, ScalaFine scalaFine){
        super(p);
        this.scalaFine = scalaFine;
    }

    @Override
    public void azione(Giocatore g) {
        scalaFine.azione(g);
        //g.setPosizione(scalaFine.getPosizione());
        //scalaFine.setGiocatoreSuCella();

    }

    @Override
    public void stampa() {
        if(getGiocatore() != null)
            System.out.print(String.format("[ Sc[%d]In ]", getGiocatore().getID()));
        System.out.print("[  ScaIn  ]");
    }
}
