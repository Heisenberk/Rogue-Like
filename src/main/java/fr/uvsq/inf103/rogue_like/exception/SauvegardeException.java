package fr.uvsq.inf103.rogue_like.exception;

public class SauvegardeException extends RuntimeException{
    public SauvegardeException(){
        super("Impossible de sauvegarder la partie. ");
    }
}