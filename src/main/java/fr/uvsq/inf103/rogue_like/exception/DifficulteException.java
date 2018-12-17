package fr.uvsq.inf103.rogue_like.exception;

/**
 * Classe DifficulteException qui est une exception particuliere.
 */
public class DifficulteException extends RuntimeException{
	
	/**
     * Constructeur de DifficulteException.
     */
    public DifficulteException(){
        super("Difficulte non reconnue. ");
    }
}
