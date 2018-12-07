package fr.uvsq.inf103.rogue_like.screen;

import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;
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
	public PlayScreen(int level, Arme arme, Sort sort, Difficulte difficulte, int vie, int argent){
		screenWidth = 80;
		screenHeight = 21;
		niveau=level;

		createWorld();
		joueur=new Player(world,arme, sort, vie, argent);
		//CREATION DES MONSTRES (ATTENTION DE NE PAS LES METTRE LES UNS SUR LES AUTRES) (modifier addAtEmptyLocation)

		createPNJ(world, difficulte); //les pnj sont crees mais x et y ne sont pas positionnes et pnj n'apparait pas

	}

	private boolean testSpawnPossible(int x, int y, int rang){
		if((this.joueur.x==x)&&(this.joueur.y==y)) return false;
		else{
			ListIterator i1=this.listePNJ.listIterator();
			for(int i=0; i<rang; i++){
				if((this.listePNJ.get(i).x==x)&&(this.listePNJ.get(i).y==y)) return false;
			}
		}
		return true;
	}

	//modifier cette fonction car il est possible de generer des PNJ sur d'autres
	private void spawnPNJ(){
		ListIterator i1=this.listePNJ.listIterator();
		for(int i=0; i<this.listePNJ.size(); i++){
			int x;
			int y;

			do {
				x = (int)(Math.random() * world.getWidth());
				y = (int)(Math.random() * world.getHeight());
			}
			while ((!world.tile(x,y).isGround())||(!testSpawnPossible(x,y,i)));

			this.listePNJ.get(i).x = x;
			this.listePNJ.get(i).y = y;
		}
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
			this.listePNJ.add(new PNJ(world, pnj_cree));
		}
		this.listePNJ.add(new PNJ(world,Enum_PNJ.VILLAGEOIS));
		spawnPNJ();

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
		
		displayTilesCreatures(terminal, left, top);
		
		terminal.write(joueur.getGlyph(), joueur.x - left, joueur.y - top, joueur.getColor());

		terminal.write((char)3, 1, 0, AsciiPanel.brightRed);
		terminal.write(""+joueur.getVie()+"/10", 3, 0);
		terminal.write(joueur.getArme().getNom()+ " - " + joueur.getSort().getNom(), 0, 21);
		terminal.write("$" , 0, 22, AsciiPanel.brightGreen);
		terminal.write(""+this.joueur.getArgent() , 2, 22);
		if(joueur.getClef()==true) terminal.write((char)213, 0, 23, AsciiPanel.brightYellow);
		terminal.writeCenter("Level "+this.niveau, 21, AsciiPanel.blue);
	}

	/**
	 * Affichage des élements. 
	 * @param terminal ou les elements sont affiches;
	 * @param left longueur de la fenetre.
	 * @param top hauteur de la fenetre.
	 */
	private void displayTilesCreatures(AsciiPanel terminal, int left, int top) {
		ListIterator i=this.listePNJ.listIterator();
		PNJ pnj; int xx; int yy;
		for (int x = 0; x < screenWidth; x++){
			for (int y = 0; y < screenHeight; y++){
				int wx = x + left;
				int wy = y + top;

				terminal.write(world.glyph(wx, wy), x, y, world.color(wx, wy));
				for(int ii=0;ii<this.listePNJ.size();ii++){
					pnj=this.listePNJ.get(ii);
					if(((x+left)==pnj.x)&&((y+top)==pnj.y)){ //mettre x+left et y+top
						terminal.write(pnj.getClasse().getCaractere(), x, y, pnj.getClasse().getColor());
					}

				}

			}
		}


	}

	private boolean testChangerNiveau(){
		if(joueur.getClef()){
			//ATTENTION AUX BORDS DE LA MAP
			boolean test=false;
			if(world.tile(joueur.x+1,joueur.y)==Element.DOOR){
				test=true;
			}
			else if(world.tile(joueur.x,joueur.y+1)==Element.DOOR){
				test=true;
			}
			else if(world.tile(joueur.x,joueur.y-1)==Element.DOOR){
				test=true;
			}
			else if(world.tile(joueur.x-1,joueur.y)==Element.DOOR){
				test=true;
			}
			if(test==true){
				joueur.laisserClef();
				return true;
			}

		}
		return false;
	}

	
	/**
     * Methode qui permet a l'utilisateur d'interagir avec l'utilisateur.
     * @param key touche que l'utilisateur tape sur le clavier.
     * @return nouvel ecran a afficher apres l'interaction avec l'utilisateur.
     */
	//@Override
	public Screen respondToUserInput(KeyEvent key) {
		switch (key.getKeyCode()){
			case KeyEvent.VK_ESCAPE: return new LoseScreen(); // a enlever
			case KeyEvent.VK_ENTER: return new WinScreen(); //a enlever
			case KeyEvent.VK_LEFT: joueur.moveBy(-1, 0); break;
			case KeyEvent.VK_RIGHT: joueur.moveBy( 1, 0); break;
			case KeyEvent.VK_UP: joueur.moveBy( 0,-1); break;
			case KeyEvent.VK_DOWN: joueur.moveBy( 0, 1); break;
			case KeyEvent.VK_R: joueur.ramasserObjet(world); break;
			case KeyEvent.VK_O:
				if(testChangerNiveau()) return new PlayScreen(niveau+1, joueur.getArme(), joueur.getSort(), this.difficulte, joueur.getVie(), joueur.getArgent());
		}
		
		return this;
	}
}
