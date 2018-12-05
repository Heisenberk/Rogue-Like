package fr.uvsq.inf103.rogue_like.world;

import java.awt.Color;

/**
 * Classe World representant la map sur laquelle joue l'utilisateur.
 */
public class World {

    /**
     * Matrice representant la map du jeu.
     */
    private Element[][] element;

    /**
     * Longueur de la map.
     */
    private int width;

    /**
     * Accesseur de la longueur de la map.
     * @return longueur de la map.
     */
    public int getWidth() { return width; }

    /**
     * Largeur de la map.
     */
    private int height;

    /**
     * Accesseur
     * @return
     */
    public int getHeight() { return height; }

    public World(Element[][] elements){
        this.element = elements;
        this.width = elements.length;
        this.height = elements[0].length;
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
        return tile(x, y).getColor();
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

    public Element getPosition(int x,int y)
    {
    	return element[x][y];
    }
    public Element[][] getElement()
    {
    	return element;
    }
    public void affectationElement(int x,int y,Element e)
    {
    	element[x][y]=e;
    }

}

