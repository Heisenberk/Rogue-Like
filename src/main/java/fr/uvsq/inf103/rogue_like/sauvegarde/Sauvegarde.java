package fr.uvsq.inf103.rogue_like.sauvegarde;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import fr.uvsq.inf103.rogue_like.screen.*;
import fr.uvsq.inf103.rogue_like.world.*;

public class Sauvegarde {
	
	private PlayScreen playscreen;

	public Sauvegarde(PlayScreen playscreen) {
		this.playscreen=playscreen;
		ecris_fichier();
	}
	public void ecris_fichier() {
		/*for(int i=0;i<90;i++) {		
			for(int j=0;j<32;j++) {
				if(world.getPosition(i, j)==Element.KEY) System.out.println("0");
				
			}
		}*/
		try{
			File ff=new File("resultat.txt"); // définir l'arborescence
			ff.createNewFile();
			//FileWriter ffw=new FileWriter(ff);
		    PrintWriter e =  new PrintWriter(new BufferedWriter
			   (new FileWriter(ff)));
		    /*e.println(playscreen.getNiveau()+" "+playscreen.getJoueur().getVie()+ " "+playscreen.getJoueur().getArgent());
		    e.println(playscreen.getJoueur().getArme());*/
			for(int i=0;i<90;i++) {
				for(int j=0;j<32;j++) {
				e.print(playscreen.getMonde().getElement(i,j).getCaractere());
				}
				e.print("\n");
			}
			e.close(); // fermer le fichier à la fin des traitements
			}
			catch (Exception e) {}
			
			
	
}
}
