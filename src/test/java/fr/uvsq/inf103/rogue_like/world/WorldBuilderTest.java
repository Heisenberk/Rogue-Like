package fr.uvsq.inf103.rogue_like.world;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WorldBuilderTest {

	private WorldBuilder w;
	/**
	 * Permet d'initialiser les variables que l'on va tester. 
	 */
	@Before
	public void initialize() {
		w = new WorldBuilder(50,50);
	}
	/**
	 * Tests si l'élément est pas null.
	 */
	@Test
	public void testConstructeur() {
		assertNotNull(w.getElement());
		
	}
	/**
	 * Tests si il existe de l'argent dans la map.
	 */
	@Test
	public void testExistMoney() {
		int nbmoney=0;
		w.makeCaves();
		for(int i=0;i<50;i++) {
			for (int j=0;j<50;j++) {
				if(w.getPosition(i, j)==Element.MONEY)
				nbmoney++;
			}
		}
		assertNotEquals(nbmoney,0);
	}
	
	/**
	 * Tests si il existe une porte dans la map.
	 */
	@Test
	public void testBuildWall() {
		int porte=0;
		w.makeCaves();
		for(int i=0;i<50;i++) {
			for (int j=0;j<50;j++) {
				if(w.getPosition(i, j)==Element.DOOR)
				porte++;
			}
		}
		assertNotEquals(porte,0);
	}
	

}
