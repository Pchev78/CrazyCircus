package CrazyCircus;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.Math;
import CrazyCircus.Podium.Podium;


public class AfficheurTour {
    private final int TAILLE_CELLULE = 10;
    private final String SEPARATEUR_LIGNE = "-----";
    private final String SIGNE_VERS = "==>";

    private Tour tour;

    public AfficheurTour(Tour tour)
    {
        this.tour = tour;
    }

    public void afficher()
    {   
        String contenu = this.genererContenuSituation();

        System.out.println(contenu);
    }

    public void afficherAvecAide()
    {   
        String contenu = this.genererContenuSituation();
        contenu+="\n";
        contenu+=this.genererAide();

        System.out.println(contenu);
    }
    
    private String genererContenuSituation(){
        int nbLignesAnimaux = this.recupereNombreLignesAnimaux();
        
        String contenu = "";
        for (int i = 0; i < nbLignesAnimaux; i++) {
            contenu+= this.genererContenueDeLigneAvecAnimaux(i);
            contenu+="\n";
        }

        contenu+=this.genererLigneSeparateur();
        contenu+="\n";
        contenu+=this.genererLigneLibelle();
        
        return contenu;
    }
    
    private String genererAide() {
        String contenu = "";
        contenu+= "----------------------------------------------\n";
        contenu+= "KI : BLEU --> ROUGE\t\tNI : BLEU  ˆ\n";
        contenu+= "LO : BLEU <-- ROUGE\t\tMA : ROUGE ˆ\n";
        contenu+= "SO : BLEU <-> ROUGE";
        return contenu;
    }
    
    private int recupereNombreLignesAnimaux() {
        ArrayList<Integer> nbAnimaux = new ArrayList<Integer>();
        nbAnimaux.add(this.tour.recupereSituationDepart().recupererPodiumBleu().recupererAnimaux().size());
        nbAnimaux.add(this.tour.recupereSituationDepart().recupererPodiumRouge().recupererAnimaux().size());
        nbAnimaux.add(this.tour.recupereSituationArrivee().recupererPodiumBleu().recupererAnimaux().size());
        nbAnimaux.add(this.tour.recupereSituationArrivee().recupererPodiumRouge().recupererAnimaux().size());
        
        return Collections.max(nbAnimaux);
    }

    private String genererContenueDeLigneAvecAnimaux(int indexAnimal)
    {
        String contenu = "";

        contenu+=this.genererCeluleDePodiumPourAnimal(this.tour.recupereSituationDepart().recupererPodiumBleu(), indexAnimal);
        contenu+=this.genererCeluleDePodiumPourAnimal(this.tour.recupereSituationDepart().recupererPodiumRouge(), indexAnimal);
        contenu+=this.genererCeluleVide();
        contenu+=this.genererCeluleDePodiumPourAnimal(this.tour.recupereSituationArrivee().recupererPodiumBleu(), indexAnimal);
        contenu+=this.genererCeluleDePodiumPourAnimal(this.tour.recupereSituationArrivee().recupererPodiumRouge(), indexAnimal);

        return contenu;
    }

    private String genererLigneSeparateur()
    {
        String contenu = "";
        contenu+=this.formaterTexteTailleFixe(this.SEPARATEUR_LIGNE);
        contenu+=this.formaterTexteTailleFixe(this.SEPARATEUR_LIGNE);

        contenu+=this.formaterTexteTailleFixe(this.SIGNE_VERS);

        contenu+=this.formaterTexteTailleFixe(this.SEPARATEUR_LIGNE);
        contenu+=this.formaterTexteTailleFixe(this.SEPARATEUR_LIGNE);

        return contenu;
    }

    private String genererLigneLibelle()
    {
        String contenu = "";
        contenu+=this.formaterTexteTailleFixe(this.tour.recupereSituationDepart().recupererPodiumBleu().recupererNom());
        contenu+=this.formaterTexteTailleFixe(this.tour.recupereSituationDepart().recupererPodiumRouge().recupererNom());

        contenu+=this.genererCeluleVide();

        contenu+=this.formaterTexteTailleFixe(this.tour.recupereSituationArrivee().recupererPodiumBleu().recupererNom());
        contenu+=this.formaterTexteTailleFixe(this.tour.recupereSituationArrivee().recupererPodiumRouge().recupererNom());

        return contenu;
    }

    private String genererCeluleDePodiumPourAnimal(Podium podium, int indexAnimal)
    {
        if (indexAnimal < podium.recupererAnimaux().size()) {
            return this.formaterTexteTailleFixe(podium.recupererAnimaux().get(indexAnimal).recupereNom());
        }

        return this.genererCeluleVide();
    }

    private String genererCeluleVide()
    {
        return this.formaterTexteTailleFixe("");
    }

    private String formaterTexteTailleFixe(String texte)
    {
        return String.format("%1$-" + this.TAILLE_CELLULE + "s", texte);
    }
}
