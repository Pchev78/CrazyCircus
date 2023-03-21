package CrazyCircus.Animal;

// Classe enfant de la classe Animal
public class Ours extends Animal{
    protected String nom = "OURS";

    /**
     * @brief Getter du nom de l'animal
     * @return le nom de l'animal
     */
    public String recupereNom(){
        return this.nom;
    }
}
