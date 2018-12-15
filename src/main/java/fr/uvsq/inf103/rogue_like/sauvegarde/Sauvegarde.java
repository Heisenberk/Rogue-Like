package fr.uvsq.inf103.rogue_like.sauvegarde;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.DataOutputStream;

import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.ArrayList;

import fr.uvsq.inf103.rogue_like.screen.*;
import fr.uvsq.inf103.rogue_like.world.*;
import fr.uvsq.inf103.rogue_like.creature.*;
import fr.uvsq.inf103.rogue_like.exception.*;

public class Sauvegarde {
	
	private PlayScreen playscreen;

	public Sauvegarde(){
		this.playscreen=null;
	}

	public Sauvegarde(PlayScreen playscreen) {
		this.playscreen=playscreen;
		//try{
			sauvegarderPartie("save/save.txt");
		/*}
		catch(Exception exception){
			throw new SauvegardeException();
		}*/
	}



	public void sauvegarderPartie(String fileName){
		sauvegarderPartie(fileName, playscreen.getDifficulte(), playscreen.getMonde(), playscreen.getNiveau(),
				playscreen.getJoueur(), playscreen.getListePNJ());

	}

	public void sauvegarderPartie(String fileName, Difficulte difficulte, Monde monde, int niveau, Joueur joueur,
								 ArrayList <PNJ> listePNJ){
		//DataInputStream out=new DataInputStream(new BufferedInputStream(new FileInputStream("save/save.txt")));
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(fileName);
			DataOutputStream dataOut = new DataOutputStream(fileOutputStream);
			//ecriture du monde
			int i;
			for(i=0;i<90;i++) {
				for(int j=0;j<32;j++) {
					dataOut.writeChar(monde.getElement(i,j).getCaractere());
				}
			}

		/*
			[n°niveau du jeu] [vie joueur] [argent joueur] [n°arme joueur] [0 ou 1 si joueur a la clef]
			[joueur X] [joueur Y] [n°difficulte]
			[nb PNJ]
			[n°classe PNJ] [PNJ X] [PNJ Y] [PNJ vie] [PNJ volonteArgent] [0 ou 1 si PNJ a la clef]
		 */
			boolean testClef;
			dataOut.writeInt(niveau);
			dataOut.writeInt(joueur.getVie());
			dataOut.writeInt(joueur.getArgent());
			dataOut.writeInt(joueur.getArme().ordinal());
			testClef=joueur.getClef();
			if(testClef==true)dataOut.writeInt(1);
			else dataOut.writeInt(0);
			dataOut.writeInt(joueur.x);
			dataOut.writeInt(joueur.y);
			dataOut.writeInt(difficulte.ordinal());
			dataOut.writeInt(listePNJ.size());
			//int i;
			PNJ pnj;
			for(i=0;i<listePNJ.size();i++){
				pnj=listePNJ.get(i);
				dataOut.writeInt(pnj.getClasse().ordinal());
				dataOut.writeInt(pnj.x);
				dataOut.writeInt(pnj.y);
				dataOut.writeInt(pnj.getVie());
				dataOut.writeInt(pnj.getVolonteArgent());
				testClef=pnj.testPossedeClef();
				if(testClef==true)dataOut.writeInt(1);
				else dataOut.writeInt(0);
			}

			fileOutputStream.close();
		}
		catch(Exception e){
			throw new SauvegardeException();
		}


	}
}
