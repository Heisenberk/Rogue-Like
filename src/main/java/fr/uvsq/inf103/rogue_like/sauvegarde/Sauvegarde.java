package fr.uvsq.inf103.rogue_like.sauvegarde;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.DataOutputStream;

import java.io.IOException;
import java.io.FileNotFoundException;

import fr.uvsq.inf103.rogue_like.screen.*;
import fr.uvsq.inf103.rogue_like.world.*;
import fr.uvsq.inf103.rogue_like.creature.*;
import fr.uvsq.inf103.rogue_like.exception.*;

public class Sauvegarde {
	
	private PlayScreen playscreen;

	public Sauvegarde(PlayScreen playscreen) {
		this.playscreen=playscreen;
		try{
			sauvegardePartie();
		}
		catch(Exception exception){
			throw new SauvegardeException();
		}

	}
	public void sauvegardePartie() throws IOException, NullPointerException, FileNotFoundException{
		//DataInputStream out=new DataInputStream(new BufferedInputStream(new FileInputStream("save/save.txt")));
		DataOutputStream dataOut = new DataOutputStream(new FileOutputStream("save/save.txt"));


		//ecriture du monde
		int i;
		for(i=0;i<90;i++) {
			for(int j=0;j<32;j++) {
				dataOut.writeChar(playscreen.getMonde().getElement(i,j).getCaractere());
			}
		}

		/*
			[n°niveau du jeu] [vie joueur] [argent joueur] [n°arme joueur] [0 ou 1 si joueur a la clef]
			[joueur X] [joueur Y] [n°difficulte]
			[nb PNJ]
			[n°classe PNJ] [PNJ X] [PNJ Y] [PNJ vie] [PNJ volonteArgent] [0 ou 1 si PNJ a la clef]
		 */
		boolean testClef;
		dataOut.writeInt(playscreen.getNiveau());
		dataOut.writeInt(playscreen.getJoueur().getVie());
		dataOut.writeInt(playscreen.getJoueur().getArgent());
		dataOut.writeInt(playscreen.getJoueur().getArme().ordinal());
		testClef=playscreen.getJoueur().getClef();
		if(testClef==true)dataOut.writeInt(1);
		else dataOut.writeInt(0);
		dataOut.writeInt(playscreen.getJoueur().x);
		dataOut.writeInt(playscreen.getJoueur().y);
		dataOut.writeInt(playscreen.getDifficulte().ordinal());
		dataOut.writeInt(playscreen.getListePNJ().size());
		//int i;
		PNJ pnj;
		for(i=0;i<playscreen.getListePNJ().size();i++){
			pnj=playscreen.getListePNJ().get(i);
			dataOut.writeInt(pnj.getClasse().ordinal());
			dataOut.writeInt(pnj.x);
			dataOut.writeInt(pnj.y);
			dataOut.writeInt(pnj.getVie());
			dataOut.writeInt(pnj.getVolonteArgent());
			testClef=pnj.testPossedeClef();
			if(testClef==true)dataOut.writeInt(1);
			else dataOut.writeInt(0);
		}

	}
}
