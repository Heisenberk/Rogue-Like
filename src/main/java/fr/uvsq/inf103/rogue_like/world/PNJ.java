package fr.uvsq.inf103.rogue_like.world;

import asciiPanel.AsciiPanel;

public class PNJ extends Creature{

    private Enum_PNJ classe;
    private int vie;

    //mettre argent et ou clef


    public PNJ(World world, Enum_PNJ classe_pnj){
        super(world, classe_pnj.getCaractere(), classe_pnj.getColor());
        this.vie=classe_pnj.getVie();
    }

}