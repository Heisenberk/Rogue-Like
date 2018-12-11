package fr.uvsq.inf103.rogue_like.world;

import fr.uvsq.inf103.rogue_like.creature.*;

import java.awt.Color;

/**
 * Classe World representant la map sur laquelle joue l'utilisateur.
 */
public class Monde {

    /**
     * Matrice representant la map du jeu.
     */
    private Element[][] element;

    /**
     * Longueur de la map.
     */
    private int width;

    /**
     * Largeur de la map.
     */
    private int height;

    /**
     * Accesseur de la longueur de la map.
     * @return longueur de la map.
     */
    public int getWidth() { return width; }

    /**
     * Accesseur de la largeur de la map.
     * @return largeur de la map.
     */
    public int getHeight() { return height; }

    /**
     * Constructeur de Monde.
     * @param elements matrice representant le mode a creer.
     */
    public Monde(Element[][] elements){
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
    public Element getElement(int x, int y){
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
	public char getCaractere(int x, int y){
        return getElement(x, y).getCaractere();
    }


    /**
     * Methode retournant la couleur de la case (x,y).
     * @param x abscisse de la case.
     * @param y ordonnee de la case.
     * @return couleur de la case.
     */
	public Color getColor(int x, int y){
        return getElement(x, y).getColor();
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
        while (!getElement(x,y).isGround());

        creature.x = x;
        creature.y = y;
    }

    /**
     * Methode permettant de modifier la nature d'une case de la map.
     * @param x abscisse de la case a modifier.
     * @param y ordonnee de la case a modifier.
     * @param e nature de la future case a modifier.
     */
    public void setElement(int x,int y,Element e)
    {
    	element[x][y]=e;
    }

}

