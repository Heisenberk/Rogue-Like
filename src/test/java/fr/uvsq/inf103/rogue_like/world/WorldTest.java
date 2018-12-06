package fr.uvsq.inf103.rogue_like.world;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests unitaires sur la classe World.
 */
public class WorldTest {

	private	World w;
	private Element[][] e;
	/**
	 * Permet d'initialiser les variables que l'on va tester. 
	 */
	@Before 
	public void initialize() {
		e = new Element[50][70];
		w= new World(e);
	}
	
	/**
	 * Tests l'affectation de l'enumeration FLOOR à un element.
	 */
	@Test
	public void testAffectationElement() {
		w.affectationElement(1,1,Element.FLOOR);
		assertEquals(w.getPosition(1,1),Element.FLOOR);
	}

	/**
	 * Tests accesseur Width.
	 */
	@Test
	public void testWidth() {
		assertEquals(w.getWidth(),50);
	}
	
	/**
	 * Tests acceseur Height.
	 */
	@Test
	public void testHeigth() {
		assertEquals(w.getHeight(),70);
	}
}
