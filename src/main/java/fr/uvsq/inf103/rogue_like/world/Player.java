package fr.uvsq.inf103.rogue_like.world;

import asciiPanel.AsciiPanel;

public class Player extends Creature{
	
	private Arme arme;
	private Sort sort;
	private int vie;
	private int argent;


	public Player(World world, Arme arme, Sort sort){

		super(world, '@', AsciiPanel.brightWhite);
		this.arme=arme;
		this.sort=sort;
		this.vie=10;
		this.argent=0;
	}

	public Arme getArme(){
		return this.arme;
	}

	public Sort getSort(){
		return this.sort;
	}

	public int getVie(){
		return this.vie;
	}

	public int getArgent(){
		return this.argent;
	}

}
