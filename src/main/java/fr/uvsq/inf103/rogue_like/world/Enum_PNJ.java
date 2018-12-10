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
    VILLAGEOIS('V',"Villageois", AsciiPanel.green, 4, 0),
    ZOMBIE('Z', "Zombie", AsciiPanel.brightRed, 5, 1),
    SORCIER('S', "Sorcier", AsciiPanel.brightRed, 7, 3),
    NB_ENUM_PNJ('X', "null", AsciiPanel.white, 0, 0);

    /**
     * Caractere representant le PNJ.
     */
    private char caractere;

    private String nom;

    public String getNom(){
        return this.nom;
    }

    /**
     * Couleur representant le PNJ.
     */
    private Color color;

    /**
     * Nombre de vies pour le PNJ.
     */
    private int vie;

    private int degats;

    /**
     * Constructeur de l'enumeration.
     * @param caractere du PNJ.
     * @param color du PNJ.
     * @param vie du PNJ.
     */
    Enum_PNJ(char caractere, String nom, Color color, int vie, int degats){
        this.caractere=caractere;
        this.nom=nom;
        this.color=color;
        this.vie=vie;
        this.degats=degats;
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

    public int getDegats() {
        return this.degats;
    }

}