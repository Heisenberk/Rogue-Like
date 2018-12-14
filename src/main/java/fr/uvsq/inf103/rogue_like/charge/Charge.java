package fr.uvsq.inf103.rogue_like.charge;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import fr.uvsq.inf103.rogue_like.world.Element;

public class Charge {

	private Element[][] element;
	public Charge()  {
		Lire();
	}
	public   void Lire()   {
		element =new Element[92][30];
        BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("resultat.txt"));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		char c=250;
		Element e1 = null;
		for(int i=0;i<90;i++) {
			for(int j=0;j<32;j++) {
		for(Element e : Element.values()) {
			try {
				if(e.getCaractere()==br.read())
					//element[i][j]=e.valueOf(e.name());
					System.out.println(e.valueOf(e.name()));
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}	
	}
}			
		//}
        /*try {
        	for(int i=0;i<1;i++) {
        		for(int j=0;j<1;j++) {
        	// AU LIEU D'ECRIRE LE NOM DE LA CLASSE
        	//System.out.println(Element.values()[br.read()]);
         br.read();
        	//System.out.print(e1.getElement(br.read()));
        	
        		}
        	}
		} catch (IOException e) {

			e.printStackTrace();
		}
		*/

	}
}
