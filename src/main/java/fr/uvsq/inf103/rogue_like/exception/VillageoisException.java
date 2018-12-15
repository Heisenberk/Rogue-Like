package fr.uvsq.inf103.rogue_like.exception;

public class VillageoisException extends RuntimeException{
    public VillageoisException(){
        super("Manque un villageois pour avoir la clef et acceder au niveau superieur. ");
    }
}