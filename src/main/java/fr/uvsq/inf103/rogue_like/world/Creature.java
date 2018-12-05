package fr.uvsq.inf103.rogue_like.world;

import java.awt.Color;

public class Creature {
	private World world;
	
	public int x;
	public int y;
	
	private char glyph;
	public char glyph() { return glyph; }
	
	private Color color;
	public Color color() { return color; }

	/*private CreatureAi ai;
	public void setCreatureAi(CreatureAi ai) { this.ai = ai; }*/
	
	public Creature(World world, char glyph, Color color){
		this.world = world;
		this.glyph = glyph;
		this.color = color;
		world.addAtEmptyLocation(this);
	}

	public void onEnter(int x, int y, Element tile){
		if (tile.isGround()){
			this.x = x;
			this.y = y;
		} /*else if (tile.isDiggable()) {
			creature.dig(x, y);
		}*/
	}
	
	public void moveBy(int mx, int my){
		onEnter(x+mx, y+my, world.tile(x+mx, y+my));
	}


	/*public void dig(int wx, int wy) {
		world.dig(wx, wy);
	}*/
}
