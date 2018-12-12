package fr.uvsq.inf103.rogue_like.sauvegarde;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import fr.uvsq.inf103.rogue_like.screen.PlayScreen;
import fr.uvsq.inf103.rogue_like.world.Arme;
import fr.uvsq.inf103.rogue_like.world.Difficulte;
import fr.uvsq.inf103.rogue_like.world.Element;
import fr.uvsq.inf103.rogue_like.world.Sort;
import fr.uvsq.inf103.rogue_like.world.World;

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
				/*if(world.getPosition(i, j)==Element.KEY) {
					e.print("1 ");
				}
				if(world.getPosition(i, j)==Element.FLOOR)
					e.print("0 ");
				
			*/
				/*switch(world.getElement(i, j)) {
				case FLOOR: e.print("0 "); break;
				case WALL:e.print("1 "); break;
				case MONEY:e.print("2 "); break;
				case LIFE: e.print("3 ");break;
				case BOUNDS:e.print("4 ");break;
				case COUTEAU:e.print("5 ");break;
				case EPEE:e.print("6 ");break;
				case BATTE_BASEBALL:e.print("7 ");break;
				case DOOR:e.print("8 ");break;
				default: e.print("9 ");break;
				}*/
				e.print(playscreen.getWorld().getElement(i,j).getCaractere());
			}
				e.print("\n");	
		}
			e.close(); // fermer le fichier à la fin des traitements


		   
		   /* ecrivain.println("bonjour, comment cela va-t-il ?");
		    ecrivain.println("un peu difficile ?");
		    ecrivain.print("On peut mettre des entiers : ");
		    ecrivain.println(n);
		    ecrivain.print("On peut mettre des instances de Object : ");
		    ecrivain.println(new Integer(36));
		    ecrivain.close();
		    */
			} catch (Exception e) {}
			
			
	
}
}
