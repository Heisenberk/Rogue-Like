package fr.uvsq.inf103.rogue_like.world;

import java.awt.Color;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Classe Creature representant le joueur et le PNJ.
 */
public class Creature {

	/**
	 * Monde dans lequel est le joueur ou le PNJ.
	 */
	private World world;

	/**
	 * Coordonnees en abscisse de la creature.
	 */
	public World getWorld() {return world;}
	
	public int x;

	/**
	 * Coordonnees en ordonnee de la creature.
	 */
	public int y;

	/**
	 * Caractere representant le joueur ou le PNJ.
	 */
	private char glyph;

	/**
	 * Accesseur du caractere de la creature.
	 * @return caractere representant la creature.
	 */
	public char getGlyph() { return glyph; }

	/**
	 * Couleur de la creature.
	 */
	private Color color;

	/**
	 * Accesseur de la couleur de la creature.
	 * @return couleur de la creature.
	 */
	public Color getColor() { return color; }

	/**
	 * Constructeur de Creature.
	 * @param world monde dans lequel la creature se trouve.
	 * @param glyph caractere de la creature.
	 * @param color couleur de la creature.
	 */
	public Creature(World world, char glyph, Color color){
		this.world = world;
		this.glyph = glyph;
		this.color = color;
		world.addAtEmptyLocation(this);
	}

	/**
	 * Methode de test pour le deplacement de la creature.
	 * @param x coordonnees des abscisses de la position de la case.
	 * @param y coordonnees des ordonnees de la position de la case.
	 * @param tile nature de la case.
	 */
	public void onEnter(int x, int y, Element tile){
		if (tile.isGround()){
			this.x = x;
			this.y = y;
		} /*else if (tile.isDiggable()) {
			creature.dig(x, y);
		}*/
	}

	public void playerMoveBy(int mx, int my, ArrayList<PNJ> listePNJ){
		ListIterator i1=listePNJ.listIterator();
		boolean test=true;
		for(int i=0; i<listePNJ.size(); i++){
			if((listePNJ.get(i).x==x+mx)&&(listePNJ.get(i).y==y+my)){
				test=false;
			}
		}
		if(test==true) onEnter(x+mx, y+my, world.tile(x+mx, y+my));
	}

	/**
	 * Deplacement de la creature.
	 * @param mx deplacement en abscisse de la creature.
	 * @param my deplacement en ordonnee de la creature.
	 */
	public void moveBy(int mx, int my){
		onEnter(x+mx, y+my, world.tile(x+mx, y+my));
	}

}
