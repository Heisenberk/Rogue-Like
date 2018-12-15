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
import fr.uvsq.inf103.rogue_like.exception.*;

import java.util.ArrayList;

public class Chargement {

	//private Element[][] element; // a enlever

	private Monde monde;

	private int niveau;

	private Joueur joueur;

	private Difficulte difficulte;

	private ArrayList <PNJ> listePNJ;

	public Chargement() {
		try{
			this.lireSauvegarde();
		}
		catch(Exception e){
			throw new ChargementException();
		}
	}

	public Difficulte getDifficulte(){
		return this.difficulte;
	}

	public int getNiveau(){
		return this.niveau;
	}

	public Monde getMonde(){
		return this.monde;
	}

	public Joueur getJoueur(){
		return this.joueur;
	}

	public ArrayList <PNJ> getListePNJ(){
		return this.listePNJ;
	}

	// verifier les exceptions lancees
	public void lireSauvegarde() throws IOException, NullPointerException, FileNotFoundException{
		Element[][] element;
		element=new Element[90][32];
		DataInputStream out=new DataInputStream(new BufferedInputStream(new FileInputStream("save/save.txt")));

		//System.out.println("//////////////////////");
		char c;
		int i;
		for(i=0;i<90;i++) {
			for(int j=0;j<32;j++) {
				c=out.readChar();
				for(Element e : Element.values()) {
					if(e.getCaractere()==c) element[i][j]=e.valueOf(e.name());
				}

				//System.out.println(element[i][j]);
			}
		}
		this.monde=new Monde(element);

		int nbPNJ; int vieJoueur, argentJoueur, joueurX, joueurY;
		boolean clef; Arme armeJoueur;
		i=out.readInt(); this.niveau=i; //level initialise
		//System.out.println("Level:"+this.niveau);
		vieJoueur=out.readInt();
		argentJoueur=out.readInt();
		i=out.readInt(); armeJoueur=Arme.values()[i];
		i=out.readInt();
		if(i==0) clef=false; else clef=true;
		joueurX=out.readInt();
		joueurY=out.readInt();
		this.joueur=new Joueur(this.monde, armeJoueur, vieJoueur, argentJoueur, clef, joueurX, joueurY);
		/*System.out.println("Vie:"+joueur.getVie());
		System.out.println("Argent:"+joueur.getArgent());
		System.out.println("Arme:"+joueur.getArme());
		System.out.println("Clef:"+ joueur.getClef());
		System.out.println("Joueur X:"+joueur.x);
		System.out.println("Joueur Y:"+joueur.y);*/
		i=out.readInt(); this.difficulte=Difficulte.values()[i]; //difficulte initialise
		//System.out.println("Difficulte:"+this.difficulte);
		nbPNJ=out.readInt();
		this.listePNJ=new ArrayList<PNJ>();
		//System.out.println("Nb PNJ:"+nbPNJ);
		int classe, pnjX, pnjY, pnjVie, pnjVolonteArgent, pnjClef;
		for(int k=0;k<nbPNJ;k++){
			classe=out.readInt();

			pnjX=out.readInt();
			pnjY=out.readInt();

			pnjVie=out.readInt();
			//System.out.println("PNJ Vie:"+pnjVie);
			pnjVolonteArgent=out.readInt();
			//System.out.println("PNJ VolonteArgent:"+pnjVolonteArgent);
			pnjClef=out.readInt();
			if(pnjClef==0) clef=false; else clef=true;
			//System.out.println("PNJ:"+EnumPNJ.values()[classe]+" "+pnjX+" "+pnjY);
			//System.out.println("PNJ Clef:"+clef);

			this.listePNJ.add(new PNJ(this.monde, EnumPNJ.values()[classe], pnjX, pnjY, pnjVie, pnjVolonteArgent, clef));

		}
		
	}
}

