package fr.uvsq.inf103.rogue_like.world;

import asciiPanel.AsciiPanel;

/**
 * Classe PNJ representant les creatures pacifiques et agressives.
 */
public class PNJ extends Creature{

    /**
     * Classe de la creature.
     */
    private Enum_PNJ classe;

    public Enum_PNJ getClasse(){
        return this.classe;
    }

    /**
     * Nombre de vie de la creature.
     */
    //private int vie;

    //mettre argent et ou clef


    /**
     * Constructeur de PNJ.
     * @param world dans lequel se trouve le PNJ.
     * @param classe_pnj classe du PNJ.
     */
    public PNJ(World world, Enum_PNJ classe_pnj){
        super(world, classe_pnj.getCaractere(), classe_pnj.getColor());
        this.classe=classe_pnj;
        //this.vie=classe_pnj.getVie();
    }

}