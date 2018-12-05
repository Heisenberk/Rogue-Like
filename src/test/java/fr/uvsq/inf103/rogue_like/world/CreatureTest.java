package fr.uvsq.inf103.rogue_like.world;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CreatureTest {

	private	World w;
	private Element[][] e;
	private Creature c;
	
	@Before 
	public void initialize() {
		e = new Element[50][70];
		w= new World(e);
		
		
	}

}
