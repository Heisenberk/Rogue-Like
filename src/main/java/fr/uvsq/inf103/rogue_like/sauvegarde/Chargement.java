package fr.uvsq.inf103.rogue_like.sauvegarde;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.DataInputStream;
import java.io.BufferedInputStream;

import fr.uvsq.inf103.rogue_like.world.*;
import fr.uvsq.inf103.rogue_like.creature.*;

public class Chargement {

	private Element[][] element;
	public Chargement()  {
		lireSauvegarde();
	}

	public void lireSauvegarde(){
		element=new Element[90][32];
		try{
			DataInputStream out=new DataInputStream(new BufferedInputStream(new FileInputStream("save/save.txt")));
			int i=out.readInt();
			int nbPNJ;
			System.out.println("Level:"+i);
			i=out.readInt();
			System.out.println("Vie:"+i);
			i=out.readInt();
			System.out.println("Argent:"+i);
			i=out.readInt();
			System.out.println("Arme:"+Arme.values()[i]);
			i=out.readInt();
			System.out.println("Clef:"+i);
			i=out.readInt();
			System.out.println("Joueur X:"+i);
			i=out.readInt();
			System.out.println("Joueur Y:"+i);
			i=out.readInt();
			System.out.println("Difficulte:"+Difficulte.values()[i]);
			nbPNJ=out.readInt();
			System.out.println("Nb PNJ:"+nbPNJ);
			for(int k=0;k<nbPNJ;k++){
				i=out.readInt();
				System.out.println("PNJ Classe:"+EnumPNJ.values()[i]);
				i=out.readInt();
				System.out.println("PNJ X:"+i);
				i=out.readInt();
				System.out.println("PNJ Y:"+i);
				i=out.readInt();
				System.out.println("PNJ Vie:"+i);
				i=out.readInt();
				System.out.println("PNJ VolonteArgent:"+i);
				i=out.readInt();
				System.out.println("PNJ Clef:"+i);
			}
			System.out.println("//////////////////////");
			char c; Element element=null;
			for(i=0;i<90;i++) {
				for(int j=0;j<32;j++) {
					c=out.readChar();
					for(Element e : Element.values()) {
						if(e.getCaractere()==c) element=e.valueOf(e.name());
					}

					System.out.println(element);
				}
			}




		}
		catch(Exception e){}

	}

}

