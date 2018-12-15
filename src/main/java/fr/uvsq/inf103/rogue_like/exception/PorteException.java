package fr.uvsq.inf103.rogue_like.exception;

public class PorteException extends RuntimeException{
    public PorteException(){
        super("Manque une porte pour acceder au niveau superieur. ");
    }
}