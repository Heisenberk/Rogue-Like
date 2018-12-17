package fr.uvsq.inf103.rogue_like.creature;

import fr.uvsq.inf103.rogue_like.world.*;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import java.awt.Color;

/**
 * Tests unitaires sur la classe Creature.
 */
public class CreatureTest {

	/**
	 * Monde pour la classe Test.
	 */
	private	Monde w;

	/**
	 * Tableau d'elements contenant les cases du monde.
	 */
	private Element[][] e;

	/**
	 * Creature a initialiser et a tester.
	 */
	private Creature c;

	/**
	 * Permet d'initialiser les variables que l'on va tester. 
	 */
	@Before 
	public void initialize() {
		e = new Element[70][70];
		w= new Monde(e);
		
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
	 * Test d'affectation de Couleur.
	 */
	@Test
	public void testGetCouleur() {
		assertEquals(c.getCouleur(),Color.BLACK);
	}

	/**
	 * Test d'affectation de Caractere.
	 */
	@Test
	public void testGetCaractere() {
		assertEquals(c.getCaractere(),'J');
	}

	/**
	 * Test de fonction qui cherche si un déplacement est possible.
	 */
	@Test
	public void testTesterDeplacement() {
		assertEquals(c.testerDeplacement(1, 0, e[0][1]),true);
		assertEquals(c.getWorld().getElement(0,1),Element.FLOOR);
	}	
}


