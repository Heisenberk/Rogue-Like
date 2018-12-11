package fr.uvsq.inf103.rogue_like.creature;

import fr.uvsq.inf103.rogue_like.world.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.awt.Color;
/**
 * Tests unitaires sur la classe Createur.
 */
public class CreatureTest {

	private	World w;
	private Element[][] e;
	private Creature c;
	/**
	 * Permet d'initialiser les variables que l'on va tester. 
	 */
	@Before 
	public void initialize() {
		e = new Element[70][70];
		w= new World(e);
		
		for(int i=0;i<70;i++) {
			for(int j=0;j<70;j++) {
				w.setElement(i,j,Element.FLOOR);
			}
		}
		c = new Creature(w,'J',Color.BLACK);
		c.x=0;
		c.y=0;
		
	}
	/**
	 * Tests accesseur Couleur.
	 */
	@Test
	public void testGetColor() {		
		assertEquals(c.getColor(),Color.BLACK);
	}
	/**
	 * Tests accesseur Glyph.
	 */
	@Test
	public void testGetGlyph() {
		assertEquals(c.getCaractere(),'J');
	}
	/**
	 * Tests fonction de déplacement de créature.
	 */
	@Test
	public void testDéplacement() {
		c.moveBy(5, 6);
		assertEquals(c.x,5);
	}
	/**
	 * Tests de fonction qui cherche si un déplacement est possible
	 */
	@Test
	public void testSiDeplacement() {
	c.onEnter(1,0,e[0][1]);	
		assertEquals(c.getWorld().getElement(0,1),Element.FLOOR);
	}	
}


