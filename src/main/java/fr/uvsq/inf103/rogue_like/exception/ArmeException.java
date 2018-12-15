package fr.uvsq.inf103.rogue_like.exception;

public class ArmeException extends RuntimeException{
    public ArmeException(){
        super("Manque une arme sur la carte du jeu. ");
    }
}