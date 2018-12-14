package fr.uvsq.inf103.rogue_like.charge;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import fr.uvsq.inf103.rogue_like.world.Element;

public class Charge {

	private Element[][] element;
	public Charge()  {
		Lire();
	}
	public   void Lire()   {
		element =new Element[90][32];
        BufferedReader br = null;
		try {
			  InputStream stream = new FileInputStream("resultat.txt");
			  Reader rawReader = new InputStreamReader(stream, "utf-8");
			  br = new BufferedReader(rawReader);
			//br = new BufferedReader(new FileReader("resultat.txt"));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		char c=250;
		int num=0;
		Element e1 = null;
		for(int i=0;i<90;i++) {
			for(int j=0;j<32;j++) {
				try {
					num=br.read();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				for(Element e : Element.values()) {

					if(e.getCaractere()==num)
						element[i][j]=e.valueOf(e.name());
						System.out.println(element[i][j] +""+i+j);
					//element[i][j]=e.valueOf(e.name());
					

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

