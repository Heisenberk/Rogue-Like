package fr.uvsq.inf103.rogue_like.world;

/**
 * Enumeration Sort qui est une caracteristique a choisir
 * pour le joueur.
 */
public enum Sort{
	AUCUN_SORT("Aucun sort"),
	INVISIBILITE("Invisibilite"), 
	FORCE("Force");

	/**
	 * Attribut Nom permettant de l'écrire dans le jeu
	 */
	private String nom;

	/**
	 * Accesseur de nom
	 * @return nom de l'arme
	 */
	public String getNom(){
		return nom;
	}

	/**
	 * Constructeur de Sort
	 * @param nom de l'arme
	 */
	private Sort(String nom){
		this.nom=nom;
	}
}
