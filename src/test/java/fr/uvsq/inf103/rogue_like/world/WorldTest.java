package fr.uvsq.inf103.rogue_like.world;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WorldTest {

	private	World w;
	private Element[][] e;
		  @Before 
		  public void initialize() {
			  e = new Element[50][70];
		       w= new World(e);
		  }
	@Test
	public void testAffectationElement() {
		w.affectationElement(1,1,Element.FLOOR);
		assertEquals(w.getPosition(1,1),Element.FLOOR);
	}

	@Test
	public void testElementLengthAbscisse() {
		int lenght=w.getElement().length;
		assertEquals(lenght,50);
	}
	
	@Test
	public void TestElementLenghtOrdonne() {
		int length=w.getElement()[0].length;
		assertEquals(length,70);
	}
	
	@Test
	public void testWidth() {
		assertEquals(w.getWidth(),50);
	}
	@Test
	public void testHeigth() {
		assertEquals(w.getHeight(),70);
	}
}
