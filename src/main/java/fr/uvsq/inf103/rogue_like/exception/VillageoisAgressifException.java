package fr.uvsq.inf103.rogue_like.exception;

public class VillageoisAgressifException extends RuntimeException{
    public VillageoisAgressifException(){
        super("Le villageois ne doit pas attaquer le joueur. ");
    }
}