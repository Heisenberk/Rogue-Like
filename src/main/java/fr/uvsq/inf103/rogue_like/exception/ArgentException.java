package fr.uvsq.inf103.rogue_like.exception;

public class ArgentException extends RuntimeException{
    public ArgentException(){
        super("Manque de l'argent sur la carte du jeu. ");
    }
}