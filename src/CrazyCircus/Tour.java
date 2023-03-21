package CrazyCircus;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Tour {
    private Situation depart;
    private Situation arrivee;
    private Joueur joueur;

    public Tour(Situation depart, Situation arrivee, Joueur joueur) {
        this.depart = depart;
        this.arrivee = arrivee;
        this.joueur = joueur;
    }

    public Situation recupereSituationDepart() {
        return this.depart;
    }

    public Situation recupereSituationArrivee() {
        return this.arrivee;
    }

    public String toString() {
        return "Joueur : " + this.joueur.getIdentifiant()
                + "\nSituation depart : \n" + this.depart.toString()
                + "\nSituation arrivee :\n" + this.arrivee.toString();
    }

    public boolean lancer() throws Exception {
        ArrayList<Ordres> ordres = this.joueur.recupererSequence().recupereOrdre();
        Situation situationPourJouer = this.depart;
        this.depart.executerOrdres(ordres);

        ComparateurSituations comparateur = new ComparateurSituations(situationPourJouer, this.arrivee);

        return comparateur.situationsSontIdentiques();
    }
}
