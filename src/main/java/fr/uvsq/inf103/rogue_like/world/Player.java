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

	private boolean clef;

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
		this.clef=false;
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

	public boolean getClef(){
		return this.clef;
	}

	public void ramasserObjet(World world){
		Element element=world.tile(this.x, this.y);
		if(element==Element.MONEY){
			world.affectationElement(this.x, this.y, Element.FLOOR);
			this.argent++;
		}
		else if((element==Element.LIFE)&&(this.vie<10)){
			world.affectationElement(this.x, this.y, Element.FLOOR);
			this.vie++;
		}
		else if((element==Element.KEY&&(this.clef==false))){
			world.affectationElement(this.x, this.y, Element.FLOOR);
			this.clef=true;
		}
		else if((element==Element.BATTE_BASEBALL)||(element==Element.COUTEAU)||(element==Element.EPEE)){
				Arme arme_deja_possede=this.arme;
				// si il y a une batte par terre on la ramasse
				if(world.tile(this.x, this.y)==Element.BATTE_BASEBALL){
					this.arme=Arme.BATTE_BASEBALL;
					world.affectationElement(this.x, this.y, Element.FLOOR);
				}
				// si il y a un couteau par terre on la ramasse
				else if (world.tile(this.x, this.y)==Element.COUTEAU){
					this.arme=Arme.COUTEAU;
					world.affectationElement(this.x, this.y, Element.FLOOR);
				}
				// si il y a un epee par terre on la ramasse
				else if (world.tile(this.x, this.y)==Element.EPEE){
					this.arme=Arme.EPEE;
					world.affectationElement(this.x, this.y, Element.FLOOR);
				}
				// si l'arme anciennement possedee etait une batte on la pose par terre
				if(arme_deja_possede==Arme.BATTE_BASEBALL){
					world.affectationElement(this.x, this.y, Element.BATTE_BASEBALL);
				}
				// si l'arme anciennement possedee etait un couteau on la pose par terre
				else if(arme_deja_possede==Arme.COUTEAU){
					world.affectationElement(this.x, this.y, Element.COUTEAU);
				}
				// si l'arme anciennement possedee etait une epee on la pose par terre
				else if(arme_deja_possede==Arme.EPEE){
					world.affectationElement(this.x, this.y, Element.EPEE);
				}

		}
	}

}
