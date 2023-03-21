package CrazyCircus.Animal;

// Classe enfant de la classe Animal
public class Lion extends Animal{
    protected String nom = "LION";

    /**
     * @brief Getter du nom de l'animal
     * @return le nom de l'animal
     */
    public String recupereNom(){
        return this.nom;
    }
}
