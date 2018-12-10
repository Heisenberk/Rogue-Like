package fr.uvsq.inf103.rogue_like.world;

import asciiPanel.AsciiPanel;

import java.util.ArrayList;
import java.util.ListIterator;

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

    public boolean etreAttaque(Player joueur){
        if(this.vie-joueur.getArme().getDegats()<=0) return false;
        else{
            this.vie-=joueur.getArme().getDegats();
            return true;
        }
    }

    // retourne false si il est mort et true si il n'est pas mort
    private boolean frapperJoueur(Player joueur){
        joueur.etreAttaque(this);
        if(joueur.getVie()-this.getClasse().getDegats()==0){
            return false;
        }
        else{
            return true;
        }
    }

    public void attaquerJoueur(Player joueur){
        boolean attaque=false;
        if((this.x==joueur.x+1)&&(this.y==joueur.y)){
            attaque=true;
        }
        else if((this.x==joueur.x)&&(this.y==joueur.y+1)){
            attaque=true;
        }
        else if((this.x==joueur.x-1)&&(this.y==joueur.y)){
            attaque=true;
        }
        else if((this.x==joueur.x)&&(this.y==joueur.y-1)){
            attaque=true;
        }
        if(attaque==true){
            this.frapperJoueur(joueur);
        }
    }


    //zone autour du PNJ ou il est attire par le joueur
    private boolean etreAttire(Player joueur){
        if((Math.abs(joueur.x-this.x)<=6)&&(Math.abs(joueur.y-this.y)<=6)){
            return true;
        }
        return false;
    }

    public void seDeplacer(Player joueur, ArrayList<PNJ> listePNJ){
        int mx, my; mx=my=0;
        if((this.etreAttire(joueur))&&(this.getClasse()!=Enum_PNJ.VILLAGEOIS)){ //le pnj le suit

            if((Math.abs(joueur.y-this.y)<=6)&&(joueur.y<this.y)&&(Math.abs(joueur.x-this.x)<=1)){ //zone 4
                mx=0; my=-1;
                //System.out.print("H-");
            }
            else if((Math.abs(joueur.y-this.y)<=6)&&(joueur.y>this.y)&&(Math.abs(joueur.x-this.x)<=1)){ //zone 2
                mx=0; my=1;
                //System.out.print("B-");
            }
            else if((Math.abs(joueur.x-this.x)<=6)&&(joueur.x>this.x)){ //zone 3
                mx=1; my=0;
                //System.out.print("D-");
            }
            else if((Math.abs(joueur.x-this.x)<=6)&&(joueur.x<this.x)){ //zone 1
                mx=-1; my=0;
                //System.out.print("G-");
            }
        }
        else{ //deplacement aleatoire
            int deplacement = (int)(Math.random() * 4);
            if(deplacement==0) { mx=0; my=1;}
            else if(deplacement==1) {mx=0; my=-1;}
            else if(deplacement==2) {mx=1; my=0;}
            else if(deplacement==3) {mx=-1; my=0;}
        }


        boolean test=true;
        for(int i=0; i<listePNJ.size(); i++){
            if(listePNJ.get(i)!=this){
                if((listePNJ.get(i).x==x+mx)&&(listePNJ.get(i).y==y+my)){
                    test=false;
                }
            }
        }
        // si le joueur est a portee du pnj
        if((joueur.x==x+mx)&&(joueur.y==y+my)){

            test=false;
        }
        if(test==true) onEnter(x+mx, y+my, this.world.tile(x+mx, y+my));
        if(this.getClasse()!=Enum_PNJ.VILLAGEOIS) this.attaquerJoueur(joueur);

    }

}