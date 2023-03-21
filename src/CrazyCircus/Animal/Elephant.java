package CrazyCircus.Animal;

// Classe enfant de la classe Animal
public class Elephant extends Animal{
    protected String nom = "ELEPHANT";

    /**
     * @brief Getter du nom de l'animal
     * @return le nom de l'animal
     */
    public String recupereNom(){
        return this.nom;
    }
}
