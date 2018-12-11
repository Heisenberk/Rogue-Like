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
public Element[][] getElement(){
	return element;
}
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
     * Accesseur de la largeur de la map.
     * @return largeur de la map.
     */
    public int getHeight() { return height; }

    /**
     * Constructeur de World.
     * @param elements matrice representant le mode a creer.
     */
    public World(Element[][] elements){
        this.element = elements;
        this.width = elements.length;
        this.height = elements[0].length;
    }

    /**
     * Methode retournant la nature de la case en (x,y).
     * @param x abscisse de la case.
     * @param y ordonnee de la case.
     * @return Element representant la case.
     */
    public Element tile(int x, int y){
        if (x < 0 || x >= width || y < 0 || y >= height)
            return Element.BOUNDS;
        else
            return element[x][y];
    }

    /**
     * Methode retournant le caractere ASCII representant la case (x,y).
     * @param x abscisse de la case.
     * @param y ordonnee de la case.
     * @return char representant le caractere ASCII.
     */
	public char glyph(int x, int y){
        return tile(x, y).getCaractere();
    }


    /**
     * Methode retournant la couleur de la case (x,y).
     * @param x abscisse de la case.
     * @param y ordonnee de la case.
     * @return couleur de la case.
     */
	public Color color(int x, int y){
        return tile(x, y).getColor();
    }

    /**
     * Trouve des coordonnees pour la creature etant libre.
     * @param creature a rajouter sur la map.
     */
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
    /*public Element[][] getElement()
    {
    	return element;
    }*/
    public void affectationElement(int x,int y,Element e)
    {
    	element[x][y]=e;
    }

}

