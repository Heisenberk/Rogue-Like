package fr.uvsq.inf103.rogue_like.charge;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
		String[] line;

        try {
        	for(int i=0;i<30*92;i++)
			
		     
        	System.out.println(br.read());
		} catch (IOException e) {

			e.printStackTrace();
		}
		

	}
}
