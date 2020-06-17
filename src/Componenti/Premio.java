package Componenti;

import Giocatore.Giocatore;
import SupportClass.Posizione;

public class Premio  extends AbstractComponent{
    public enum TipoPremio {DADI, MOLLA}; //renderlo privato per il rilascio finale
    private TipoPremio tipoPremio;

    public Premio(Posizione p, TipoPremio tipoPremio){
        super(p);
        this.tipoPremio = tipoPremio;
    }

    @Override
    public void stampa() {
        if(! this.getGiocatoriSuCella().isEmpty())
            System.out.print(String.format("[ Pr[%d]mi ]", this.getGiocatoriSuCella().getFirst().getID()));
        else System.out.print("[  Premi  ]");
    }

    @Override
    public void azione(Giocatore g) {
        super.azione(g);
        g.assegnaPremio(this);
        System.out.printf("Il giocatore %d ha ricevuto un premio di tipo " + tipoPremio + "\n", g.getID());

    }

    public TipoPremio getTipoPremio() {
        return tipoPremio;
    }

    @Override
    public String toString() {
        return String.format("Componente 'Premio' di tipo %s' in posizione " + getPosizione(),tipoPremio.toString());
    }
}
