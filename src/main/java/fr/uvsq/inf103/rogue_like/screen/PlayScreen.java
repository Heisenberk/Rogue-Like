package fr.uvsq.inf103.rogue_like.screen;

import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;
import fr.uvsq.inf103.rogue_like.sauvegarde.Sauvegarde;
import fr.uvsq.inf103.rogue_like.world.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Classe PlayScreen qui s'affichera quand l'utilisateur sera en train de jouer.
 */
public class PlayScreen implements Screen {
	
	
	/**
	 * Map du monde Rogue Like.
	 */
	private World world;
	
	/**
	 * Difficulte du jeu choisie par le joueur.
	 */
	private Difficulte difficulte;
	
	/**
	 * PJ representant le joueur en train de jouer.
	 */
	private Player joueur;
	
	/**
	 * Liste de PNJ (pacifiques ou non).
	 */
	private ArrayList <PNJ> listePNJ;
	
	/**
	 * Level de la partie.
	 */
	private int niveau;
	
	/**
	 * Longueur de la fenetre de jeu.
	 */
	private int screenWidth;
	
	/**
	 * Largeur de la fenetre de jeu.
	 */
	private int screenHeight;
	
	/**
	 * Constructeur de PlayScreen qui permet de generer la map, le joueur et les PNJ.
	 * @param arme du joueur.
	 * @param sort du joueur.
	 * @param difficulte du joueur. 
	 */
	public PlayScreen(Arme arme, Sort sort, Difficulte difficulte){
		screenWidth = 80;
		screenHeight = 21;
		niveau=1;

		createWorld();
		joueur=new Player(world,arme, sort);
		//CREATION DES MONSTRES (ATTENTION DE NE PAS LES METTRE LES UNS SUR LES AUTRES) (modifier addAtEmptyLocation)

		createPNJ(world, difficulte); //les pnj sont crees mais x et y ne sont pas positionnes et pnj n'apparait pas

	}

	private void createPNJ(World world, Difficulte difficulte){
		this.listePNJ=new ArrayList<PNJ>();
		int nb_pnj_agressifs;
		if(difficulte==Difficulte.FACILE) nb_pnj_agressifs=5;
		else if(difficulte==Difficulte.INTERMEDIAIRE) nb_pnj_agressifs=7;
		else if(difficulte==Difficulte.DIFFICILE) nb_pnj_agressifs=10;
		else if(difficulte==Difficulte.HARDCORE) nb_pnj_agressifs=20;
		else {
			nb_pnj_agressifs=0;
			System.out.println("EXCEPTION A LANCER");
		}

		// ajout des PNJ agressifs
		Enum_PNJ pnj_cree; int type_pnj; PNJ pnj;
		for(int i=0;i<nb_pnj_agressifs;i++){
			type_pnj=(int)(Math.random() * Enum_PNJ.NB_ENUM_PNJ.ordinal()); // ordinal recupere le nombre d'enum
			if(type_pnj==0) type_pnj=1;
			pnj_cree=Enum_PNJ.values()[type_pnj];
			//pnj=new PNJ(world, pnj_cree);
			this.listePNJ.add(new PNJ(world, pnj_cree));
		}

		this.listePNJ.add(new PNJ(world,Enum_PNJ.VILLAGEOIS));

	}


	/**
	 * Methode privee permettant de generer le monde.
	 */
	private void createWorld(){
		world = new WorldBuilder(90, 32)
					.makeCaves()
					.build();
	}
	
	/**
	 * Methode de point de vue de la camera sur l'axe de la longueur.
	 * @return position de la camera en longueur.
	 */
	public int getScrollX() { return Math.max(0, Math.min(joueur.x - screenWidth / 2, world.getWidth() - screenWidth)); }
	
	/**
	 * Methode de point de vue de la camera sur l'axe de la largeur.
	 * @return position de la camera en largeur.
	 */
	public int getScrollY() { return Math.max(0, Math.min(joueur.y - screenHeight / 2, world.getHeight() - screenHeight)); }
	
	/**
     * Methode qui affiche les interactions possibles avec l'utilisateur.
     * @param terminal represente l'ecran du jeu.
     */
	//@Override
	public void displayOutput(AsciiPanel terminal) {
		
		int left = getScrollX();
		int top = getScrollY(); 
		
		displayTiles(terminal, left, top);
		
		terminal.write(joueur.getGlyph(), joueur.x - left, joueur.y - top, joueur.getColor());

		terminal.write((char)3, 1, 0, AsciiPanel.brightRed);
		terminal.write(""+joueur.getVie()+"/10", 3, 0);
		terminal.write(joueur.getArme().getNom()+ " - " + joueur.getSort().getNom(), 0, 22);
		terminal.write("$" , 0, 23, AsciiPanel.brightGreen);
		terminal.write(""+this.joueur.getArgent() , 2, 23);
		terminal.writeCenter("Level "+this.niveau, 0, AsciiPanel.blue);
	}

	/**
	 * Affichage des élements. 
	 * @param terminal ou les elements sont affiches;
	 * @param left longueur de la fenetre.
	 * @param top hauteur de la fenetre.
	 */
	private void displayTiles(AsciiPanel terminal, int left, int top) {
		for (int x = 0; x < screenWidth; x++){
			for (int y = 0; y < screenHeight; y++){
				int wx = x + left;
				int wy = y + top;

				terminal.write(world.glyph(wx, wy), x, y, world.color(wx, wy));
			}
		}
	}
	
	/**
     * Methode qui permet a l'utilisateur d'interagir avec l'utilisateur.
     * @param key touche que l'utilisateur tape sur le clavier.
     * @return nouvel ecran a afficher apres l'interaction avec l'utilisateur.
     */
	//@Override
	public Screen respondToUserInput(KeyEvent key) {
		switch (key.getKeyCode()){
		case KeyEvent.VK_ESCAPE: return new LoseScreen();
		case KeyEvent.VK_ENTER: return new WinScreen();
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_Q: joueur.moveBy(-1, 0); break;
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_D: joueur.moveBy( 1, 0); break;
		case KeyEvent.VK_UP:
		case KeyEvent.VK_Z: joueur.moveBy( 0,-1); break;
		case KeyEvent.VK_DOWN: joueur.moveBy( 0, 1); break;
		case KeyEvent.VK_S: new Sauvegarde(world); break;
		}
		
		return this;
	}
    public World getWorld() {
    	return world;
    }
}
