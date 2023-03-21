package CrazyCircus;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        String identifiantsJoueurs = "";
        for (int i = 0; i < args.length; i++) {
            identifiantsJoueurs += args[i] + " ";
        }

        Partie partie = new Partie(identifiantsJoueurs);
        partie.lancerPartie();
//        ArrayList<Joueur> joueurs = partie.recupererJoueurs();
//        for (Joueur joueur : joueurs)
//            System.out.println(joueur.getIdentifiant());
    }
}