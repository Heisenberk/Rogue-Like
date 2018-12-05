package fr.uvsq.inf103.rogue_like.world;

import asciiPanel.AsciiPanel;

/**
 * Classe Joueur de Rogue Like.
 */
public class Player extends Creature{

	/**
	 * Arme du joueur.
	 */
	private Arme arme;

	/**
	 * Sort du joueur.
	 */
	private Sort sort;

	/**
	 * Nombre de vies du joueur.
	 */
	private int vie;

	/**
	 * Argent possede par le joueur.
	 */
	private int argent;

	/**
	 * Constructeur de Player.
	 * @param world monde dans lequel joue l'utilisateur.
	 * @param arme du joueur.
	 * @param sort du joueur.
	 */
	public Player(World world, Arme arme, Sort sort){
		super(world, '@', AsciiPanel.brightWhite);
		this.arme=arme;
		this.sort=sort;
		this.vie=10;
		this.argent=0;
	}

	/**
	 * Accesseur de l'arme du joueur.
	 * @return arme du joueur.
	 */
	public Arme getArme(){
		return this.arme;
	}

	/**
	 * Accesseur du sort du joueur.
	 * @return sort du joueur.
	 */
	public Sort getSort(){
		return this.sort;
	}

	/**
	 * Accesseur du nombre de vies du joueur.
	 * @return nombre de vies du joueur.
	 */
	public int getVie(){
		return this.vie;
	}

	/**
	 * Accesseur du nombre de pieces que le joueur detient.
	 * @return nombre de pieces du joueur.
	 */
	public int getArgent(){
		return this.argent;
	}

}
