package Builder;

import GiocoEtabellone.Tabellone;
import SupportClass.Posizione;

public interface Builder {

    /**
     * Costruisce un tabellone con le dimensioni indicate
     * @param numeroRighe
     * @param numeroColonne
     * @param numeroCelleTabellone
     */
    public void buildTabellone(int numeroRighe, int numeroColonne, int numeroCelleTabellone);

    /**
     * Costruisce il tabellone con le dimensioni di default.
     */
    public void buildTabellone();

    /**
     *
     * @return il tabellone costruito, al momento in cui è invocato il metodo,la posizione in cui vengono aggiunte è casuale
     */
    public Tabellone getResult();


    /**
     * Inserisce nel tabellone il numero di scale indicate,la posizione in cui vengono aggiunte è casuale
     * @param numeroCaselleScale
     */
    public void buildCaselleScale(int numeroCaselleScale);

    /**
     * Inserisce nel tabellone il numero di serpenti indicati,la posizione in cui vengono aggiunte è casuale
     * @param numeroCaselleSerpenti
     */
    public void buildCaselleSerpenti(int numeroCaselleSerpenti);

    /**
     * Inserisce nel tabellone il numero di caselle di tipo sosta indicate,la posizione in cui vengono aggiunte è casuale
     * @param numeroCaselleSoste
     */
    public void buildCaselleSosta(int numeroCaselleSoste);

    /**
     * Inserisce nel tabellone il numero di caselle di tipo premio indicate,la posizione in cui vengono aggiunte è casuale
     * @param numeroCasellePremio
     */
    public void buildCasellePremio(int numeroCasellePremio);

    /**
     * Inserisce nel tabellone il numero di caselle di tipo PescaUnaCarta indicate,
     * la posizione in cui vengono aggiunte è casuale
     * @param numeroCasellePescaUnaCarta
     */
    public void buildCasellePescaUnaCarta(int numeroCasellePescaUnaCarta);

    /**
     * Inserisce nel tabellone il numero di caselle di tipo PescaUnaCarta con impostata l'opzioni
     * di ulteriori carte, la posizione in cui vengono aggiunte è casuale
     * @param numeroCasellePescaUnaCartaConUlterioriCarte, numero di caselle da aggiungere
     */
    public void buildCasellePescaUnaCartaConUlterioriCarte(int numeroCasellePescaUnaCartaConUlterioriCarte);

    /**
     * Inserisce una caselle di tipo Scala nella posizione indicata
     * @param posizioneInizio, posizione iniziale della scala
     * @param posizioneFine, posizione finale della scala
     * @return true se l'aggiunta è andata a buon fine
     */
    public boolean buildScala(Posizione posizioneInizio, Posizione posizioneFine);


    /**
     * Inserisce una caselle di tipo Serpente nella posizione indicata
     * @param posizioneInizio, posizione iniziale del serpente, (quindi la testa)
     * @param posizioneFine, posizione finale del sepente (coda)
     * @return true se l'aggiunta è andata a buon fine
     */
    public boolean buildSerpente(Posizione posizioneInizio, Posizione posizioneFine);

    /**
     * Inserisce una caselle di tipo Sosta nella posizione indicata
     * @param posizione
     * @return true se l'aggiunta è andata a buon fine
     */
    public boolean buildCasellaSosta(Posizione posizione);

    /**
     * Inserisce una caselle di tipo Premio nella posizione indicata
     * @param posizione
     * @return true se l'aggiunta è andata a buon fine
     */
    public boolean buildCasellaPremio(Posizione posizione);

    /**
     * Inserisce una caselle di tipo PescaUnaCarta nella posizione indicata
     * @param posizione
     * @return true se l'aggiunta è andata a buon fine
     */
    public boolean buildCasellaPescaUnaCarta(Posizione posizione);

    /**
     * Inserisce una caselle di tipo PescaUnaCarta  con opzione
     * ultriori carte, nella posizione indicata
     * @param posizione
     * @return true se l'aggiunta è andata a buon fine
     */
    public boolean buildCasellaPescaUnaCartaConUlterioriCarte(Posizione posizione);

}
