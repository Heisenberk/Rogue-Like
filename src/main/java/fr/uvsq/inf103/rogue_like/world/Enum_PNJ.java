package fr.uvsq.inf103.rogue_like.world;

import asciiPanel.AsciiPanel;
import java.awt.Color;

/**
 * Enumerations des differentes classes de PNJ possible.
 */
public enum Enum_PNJ{

    /**
     * Un PNJ peut etre agressif (zombie ou sorcier) ou pacifique (villageois)
     */
    VILLAGEOIS('V', AsciiPanel.brightGreen, 4),
    ZOMBIE('Z', AsciiPanel.brightRed, 5),
    SORCIER('S', AsciiPanel.brightRed, 7),
    NB_ENUM_PNJ('X', AsciiPanel.white, 0);

    /**
     * Caractere representant le PNJ.
     */
    private char caractere;

    /**
     * Couleur representant le PNJ.
     */
    private Color color;

    /**
     * Nombre de vies pour le PNJ.
     */
    private int vie;

    /**
     * Constructeur de l'enumeration.
     * @param caractere du PNJ.
     * @param color du PNJ.
     * @param vie du PNJ.
     */
    Enum_PNJ(char caractere, Color color, int vie){
        this.caractere=caractere;
        this.color=color;
        this.vie=vie;
    }

    /**
     * Accesseur du caractere ASCII du PNJ.
     * @return caractere representant le PNJ.
     */
    public char getCaractere(){
        return this.caractere;
    }

    /**
     * Accesseur de la couleur de PNJ.
     * @return couleur du PNJ.
     */
    public Color getColor(){
        return this.color;
    }

    /**
     * Accesseur du nombre de vies du PNJ.
     * @return nombre de vies du PNJ.
     */
    public int getVie(){
        return this.vie;
    }

}