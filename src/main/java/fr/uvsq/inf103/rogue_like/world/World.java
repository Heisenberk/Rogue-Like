package fr.uvsq.inf103.rogue_like.world;

import java.awt.Color;

public class World {
    private Element[][] element;
    private int width;
    public int width() { return width; }

    private int height;
    public int height() { return height; }

    public World(Element[][] tiles){
        this.element = tiles;
        this.width = tiles.length;
        this.height = tiles[0].length;
    }
    
    public Element tile(int x, int y){
        if (x < 0 || x >= width || y < 0 || y >= height)
            return Element.BOUNDS;
        else
            return element[x][y];
    }


	public char glyph(int x, int y){
        return tile(x, y).getCaractere();
    }


	public Color color(int x, int y){
        return tile(x, y).color();
    }

    public void addAtEmptyLocation(Creature creature){
        int x;
        int y;

        do {
            x = (int)(Math.random() * width);
            y = (int)(Math.random() * height);
        }
        while (!tile(x,y).isGround());

        creature.x = x;
        creature.y = y;
    }

    public void dig(int x, int y) {
        if (tile(x,y).isDiggable())
            element[x][y] = Element.FLOOR;
    }

}

