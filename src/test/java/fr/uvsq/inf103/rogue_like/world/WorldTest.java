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
	/*@Test
	public void ElementIsEquals() {
		w.dig(80,80);
		assertEquals("that be should equals",w.dig(80,80),Element.BOUNDS);
		
	}*/
	@Test
	public void ElementLengthAbscisse() {
		int lenght=w.GetElement().length;
		assertEquals("length x",lenght,50);
	}
	
	@Test
	public void ElementLenghtOrdonne() {
		int length=w.GetElement()[0].length;
		assertEquals("length y",length,70);
	}

}
