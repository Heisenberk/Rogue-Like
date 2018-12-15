package fr.uvsq.inf103.rogue_like.exception;

public class ChargementException extends RuntimeException{
    public ChargementException(){
        super("Impossible de charger la sauvegarde. ");
    }
}