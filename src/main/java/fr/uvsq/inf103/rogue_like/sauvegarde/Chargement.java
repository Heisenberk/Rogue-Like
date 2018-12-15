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

	public Chargement(String fileName){
		try{
			this.lireSauvegarde(fileName);
		}
		catch(SpawnException e){
			throw new SpawnException();
		}
		catch(PorteException e){
			throw new PorteException();
		}
		catch(Exception e){
			throw new ChargementException();
		}
	}

	public Chargement() {

			this.lireSauvegarde();

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
	public void lireSauvegarde(){
		lireSauvegarde("save/save.txt");

	}

	public void lireSauvegarde(String fileName){
		try{
			Element[][] element;
			int nbPNJ, vieJoueur, argentJoueur, joueurX, joueurY, i;
			int compteurPorte, compteurArgent, compteurArme;
			compteurPorte=compteurArgent=compteurArme=0;
			char c;
			boolean clef; Arme armeJoueur;
			element=new Element[90][32];
			FileInputStream file=new FileInputStream(fileName);
			DataInputStream out=new DataInputStream(new BufferedInputStream(file));

			for(i=0;i<90;i++) {
				for(int j=0;j<32;j++) {
					c=out.readChar();
					for(Element e : Element.values()) {
						if(e.getCaractere()==c){
							element[i][j]=e.valueOf(e.name());
							if(element[i][j]==Element.DOOR) compteurPorte++;
						}

					}
				}
			}
			if(compteurPorte!=1) throw new PorteException();
			this.monde=new Monde(element);

			i=out.readInt(); this.niveau=i; //level initialise
			vieJoueur=out.readInt();
			argentJoueur=out.readInt();
			i=out.readInt(); armeJoueur=Arme.values()[i];
			i=out.readInt();
			if(i==0) clef=false; else clef=true;
			joueurX=out.readInt();
			joueurY=out.readInt();
			if(element[joueurX][joueurY]==Element.WALL) throw new SpawnException(); // si le joueur spawn sur un mur
			if(element[joueurX][joueurY]==Element.DOOR) throw new SpawnException(); // si le joueur spawn sur une porte
			this.joueur=new Joueur(this.monde, armeJoueur, vieJoueur, argentJoueur, clef, joueurX, joueurY);
			i=out.readInt(); this.difficulte=Difficulte.values()[i]; //difficulte initialise
			nbPNJ=out.readInt();
			this.listePNJ=new ArrayList<PNJ>();
			int classe, pnjX, pnjY, pnjVie, pnjVolonteArgent, pnjClef;
			for(int k=0;k<nbPNJ;k++){
				classe=out.readInt();
				pnjX=out.readInt();
				pnjY=out.readInt();

				if(element[pnjX][pnjY]==Element.WALL) throw new SpawnException(); // si le pnj spawn sur un mur
				if(element[pnjX][pnjY]==Element.DOOR) throw new SpawnException(); // si le pnj spawn sur une porte
				if((joueurX==pnjX)&&(joueurY==pnjY)) throw new SpawnException(); // si le pnj spawn sur le joueur
				for(int l=0; l<k; l++){ // si le pnj spawn sur un autre pnj
					if((this.listePNJ.get(l).x==pnjX)&&(this.listePNJ.get(l).y==pnjY)) throw new SpawnException();
				}

				pnjVie=out.readInt();
				pnjVolonteArgent=out.readInt();
				pnjClef=out.readInt();
				if(pnjClef==0) clef=false; else clef=true;

				this.listePNJ.add(new PNJ(this.monde, EnumPNJ.values()[classe], pnjX, pnjY, pnjVie, pnjVolonteArgent, clef));

			}
			file.close();
		}
		catch(SpawnException e){
			throw new SpawnException();
		}
		catch(PorteException e){
			throw new PorteException();
		}
		catch(Exception e){
			throw new ChargementException();
		}

	}


}

