package fr.uvsq.inf103.rogue_like.screen;

import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;
import fr.uvsq.inf103.rogue_like.world.*;

/**
 * Classe PlayScreen qui s'affichera quand l'utilisateur sera en train de jouer.
 */
public class PlayScreen implements Screen {
	private World world;
	private Player joueur;
	private int niveau;
	private int screenWidth;
	private int screenHeight;
	
	public PlayScreen(Arme arme, Sort sort){
		screenWidth = 80;
		screenHeight = 21;
		niveau=1;
		createWorld();

		joueur=new Player(world,arme, sort);
	}
	
	private void createWorld(){
		world = new WorldBuilder(90, 32)
					.makeCaves()
					.build();
	}
	
	public int getScrollX() { return Math.max(0, Math.min(joueur.x - screenWidth / 2, world.width() - screenWidth)); }
	
	public int getScrollY() { return Math.max(0, Math.min(joueur.y - screenHeight / 2, world.height() - screenHeight)); }
	
	/**
     * Methode qui affiche les interactions possibles avec l'utilisateur.
     * @param terminal represente l'ecran du jeu.
     */
	@Override
	public void displayOutput(AsciiPanel terminal) {
		
		int left = getScrollX();
		int top = getScrollY(); 
		
		displayTiles(terminal, left, top);
		
		terminal.write(joueur.glyph(), joueur.x - left, joueur.y - top, joueur.color());

		terminal.write((char)3, 1, 0, AsciiPanel.brightRed);
		terminal.write(""+joueur.getVie(), 3, 0);
		terminal.write(joueur.getArme().getNom()+ " - " + joueur.getSort().getNom(), 0, 22);
		terminal.write("$" , 0, 23, AsciiPanel.brightGreen);
		terminal.write(""+this.joueur.getArgent() , 2, 23);
		terminal.writeCenter("Level "+this.niveau, 0, AsciiPanel.blue);
	}

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
	@Override
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
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_S: joueur.moveBy( 0, 1); break;
		case KeyEvent.VK_Y: joueur.moveBy(-1,-1); break;
		case KeyEvent.VK_U: joueur.moveBy( 1,-1); break;
		case KeyEvent.VK_B: joueur.moveBy(-1, 1); break;
		case KeyEvent.VK_N: joueur.moveBy( 1, 1); break;
		}
		
		return this;
	}
}
