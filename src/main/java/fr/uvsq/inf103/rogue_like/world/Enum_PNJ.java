package fr.uvsq.inf103.rogue_like.world;

import asciiPanel.AsciiPanel;
import java.awt.Color;

public enum Enum_PNJ{

    ZOMBIE('Z', AsciiPanel.brightRed, 5),
    SORCIER('S', AsciiPanel.brightRed, 7),
    VILLAGEOIS('V', AsciiPanel.brightGreen, 4);

    private char caractere;
    private Color color;
    private int vie;

    Enum_PNJ(char caractere, Color color, int vie){
        this.caractere=caractere;
        this.color=color;
        this.vie=vie;
    }

    public char getCaractere(){
        return this.caractere;
    }

    public Color getColor(){
        return this.color;
    }

    public int getVie(){
        return this.vie;
    }



}