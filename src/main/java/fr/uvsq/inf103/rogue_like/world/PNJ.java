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

    private int vie;

    private int volonteArgent;

    private boolean possedeClef;

    public boolean testPossedeClef(){
        return this.possedeClef;
    }

    public void setPossedeClef(boolean cond){
        this.possedeClef=cond;
    }

    public Enum_PNJ getClasse(){
        return this.classe;
    }

    public int getVolonteArgent(){
        return this.volonteArgent;
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
        this.vie=classe.getVie();
        if(classe_pnj==Enum_PNJ.VILLAGEOIS){
            int argent_voulu=(int)(Math.random() * 7)+1;
            this.volonteArgent=argent_voulu;
            this.possedeClef=true;
        }
        else{
            this.volonteArgent=-1; //EXCEPTION A LANCER SI IL REUSSIT A PARLER AVEC UN PNJ AGRESSIF
            this.possedeClef=false;
        }
    }

    // retourne false si il est mort et true si il n'est pas mort
    public boolean EtreAttaque(Player joueur){
        if(this.vie-joueur.getArme().getDegats()<=0) return false;
        else{
            this.vie-=joueur.getArme().getDegats();
            return true;
        }
    }

}