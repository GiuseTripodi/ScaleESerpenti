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
        System.out.println("Il giocatore è caduto nella cella " + this.getPosizione());
        System.out.println("Il giocatore sarà rimandato nella cella " + scalaFine.getPosizione());

        scalaFine.azione(g);
        //g.setPosizione(scalaFine.getPosizione());
        //scalaFine.setGiocatoreSuCella();

    }

    @Override
    public void stampa() {
        if(! this.getGiocatoriSuCella().isEmpty())
            System.out.print(String.format("[ Sc[%d]In ]", getGiocatoriSuCella().size()));
        else System.out.print("[  ScaIn  ]");
    }

    @Override
    public String toString() {
        return "Componente 'ScalaInizio' in posizione " + getPosizione();
    }
}
