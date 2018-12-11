package fr.uvsq.inf103.rogue_like.exception;

public class DifficulteException extends RuntimeException{
    public DifficulteException(){
        super("Difficulte non reconnue. ");
    }
}