package fr.uvsq.inf103.rogue_like.charge;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import fr.uvsq.inf103.rogue_like.world.Element;

public class Charge {
	
	public Charge()  {
		Lire();
	}
	public   void Lire()   {
        BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("resultat.txt"));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		Element e1 = null;
        try {
        	for(int i=0;i<30*92;i++)
			
        	// AU LIEU D'ECRIRE LE NOM DE LA CLASSE
        	//System.out.println(Element.values()[br.read()]);
        	br.read();
        	//System.out.print(e1.name()+" ");
        	
        	
		} catch (IOException e) {

			e.printStackTrace();
		}
		

	}
}
