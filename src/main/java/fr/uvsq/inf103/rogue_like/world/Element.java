package fr.uvsq.inf103.rogue_like.world;

import java.awt.Color;
import asciiPanel.AsciiPanel;

/**
 * Element possible dans un monde cree dans Rogue Like.
 */
public enum Element {
    /**
     * Element representant le sol.
     */
    FLOOR((char)32, AsciiPanel.yellow),

    /**
     * Element representant les murs.
     */
    WALL((char)177, AsciiPanel.yellow),
    BOUNDS('x', AsciiPanel.brightBlack);

    /**
     * Representation ASCII de cet element.
     */
    private char caractere;

    /**
     * Accesseur de la representation ASCII de l'element
     * @return char representant le caractere ASCII de l'element a afficher.
     */
    public char getCaractere() { return caractere; }

    /**
     * Couleur de l'element.
     */
    private Color color;

    /**
     * Accesseur de la couleur de l'element.
     * @return couleur de l'element.
     */
    public Color color() { return color; }

    /**
     * Constructeur de l'element
     * @param caractere ASCII de l'element.
     * @param color couleur de l'element.
     */
    Element(char caractere, Color color){
        this.caractere = caractere;
        this.color = color;
    }

    public boolean isDiggable() {
        return this == Element.WALL;
    }

    public boolean isGround() {
        return this != WALL && this != BOUNDS;
    }
}
