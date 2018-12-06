package fr.uvsq.inf103.rogue_like.world;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WorldBuilderTest {

	private WorldBuilder w;
	@Before
	public void initialize() {
		w = new WorldBuilder(50,50);
	}
	@Test
	public void testConstructeur() {
		assertNotNull(w.getElement());
		
	}
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
	
	@Test
	public void testBuildWall() {
		int nbmur=0;
		w.WorldMakeMur(0, 0);
		for(int i=0;i<3;i++) {
			for (int j=0;j<3;j++) {
				if(w.getPosition(i, j)==Element.WALL)
				nbmur++;
			}
		}
		assertNotEquals(nbmur,0);
	}
	

}
