package fr.uvsq.inf103.rogue_like.world;

/**
 * Enumeration Difficulte qui est une caracteristique a choisir
 * pour le joueur.
 */
public enum Difficulte{
	FACILE("Facile"), 
	INTERMEDIAIRE("Intermediaire"), 
	DIFFICILE("Difficile"), 
	HARDCORE("Hardcore");

	/**
	 * Attribut Nom permettant de l'écrire dans le jeu
	 */
	private String nom;

	/**
	 * Accesseur de nom
	 * @return nom de la difficulte
	 */
	public String getNom(){
		return nom;
	}

	/**
	 * Constructeur de Difficulte
	 * @param nom de la difficulte
	 */
	private Difficulte(String nom){
		this.nom=nom;
	}
}
