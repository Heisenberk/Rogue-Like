package fr.uvsq.inf103.rogue_like.world;

/**
 * Enumeration Arme qui est une caracteristique a choisir
 * pour le joueur.
 */
public enum Arme{
	/**
	 * Differents types d'armes.
	 */
	AUCUNE_ARME("Aucune arme"),
	COUTEAU("Couteau"),
	EPEE("Epee"), 
	BATTE_BASEBALL("Batte"),

	/**
	 * Enumeration supplementaire pour connaitre le nombre d'armes au total.
	 */
	NB_ARMES("null");

	/**
	 * Attribut Nom permettant de l'écrire dans le jeu.
	 */
	private String nom;

	/**
	 * Accesseur de nom.
	 * @return nom de l'arme.
	 */
	public String getNom(){
		return nom;
	}

	/**
	 * Constructeur de Arme.
	 * @param nom de l'arme.
	 */
	private Arme(String nom){
		this.nom=nom;
	}
}
