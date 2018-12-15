package fr.uvsq.inf103.rogue_like.exception;

public class SpawnException extends RuntimeException{
    public SpawnException(){
        super("Spawn de Joueur ou de PNJ invalide. ");
    }
}