package fr.uvsq.inf103.rogue_like.world;

import asciiPanel.AsciiPanel;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Classe Joueur de Rogue Like.
 */
public class Player extends Creature{

	/**
	 * Arme du joueur.
	 */
	private Arme arme;

	/**
	 * Sort du joueur.
	 */
	private Sort sort;

	/**
	 * Nombre de vies du joueur.
	 */
	private int vie;

	/**
	 * Argent possede par le joueur.
	 */
	private int argent;

	private boolean clef;

	/**
	 * Constructeur de Player.
	 * @param world monde dans lequel joue l'utilisateur.
	 * @param arme du joueur.
	 * @param sort du joueur.
	 */
	public Player(World world, Arme arme, Sort sort, int vie, int argent){
		super(world, '@', AsciiPanel.brightWhite);
		this.arme=arme;
		this.sort=sort;
		this.vie=vie;
		this.argent=argent;
		this.clef=false;
	}

	/**
	 * Accesseur de l'arme du joueur.
	 * @return arme du joueur.
	 */
	public Arme getArme(){
		return this.arme;
	}

	/**
	 * Accesseur du sort du joueur.
	 * @return sort du joueur.
	 */
	public Sort getSort(){
		return this.sort;
	}

	/**
	 * Accesseur du nombre de vies du joueur.
	 * @return nombre de vies du joueur.
	 */
	public int getVie(){
		return this.vie;
	}

	/**
	 * Accesseur du nombre de pieces que le joueur detient.
	 * @return nombre de pieces du joueur.
	 */
	public int getArgent(){
		return this.argent;
	}

	public boolean getClef(){
		return this.clef;
	}

	public void laisserClef(){ this.clef=false;}

	//renvoie le PNJ villageois et null sinon
	private PNJ demanderEchangeAlentour(ArrayList <PNJ> listePNJ) {
		PNJ pnj;
		boolean echangePossible = false;
		ListIterator i1 = listePNJ.listIterator();
		for (int i = 0; i < listePNJ.size(); i++) {
			pnj = listePNJ.get(i);
			if ((pnj.getClasse() == EnumPNJ.VILLAGEOIS) && (pnj.x == x + 1) && (pnj.y == y)) return pnj;
			else if ((pnj.getClasse() == EnumPNJ.VILLAGEOIS) && (pnj.x == x - 1) && (pnj.y == y))
				return pnj;
			else if ((pnj.getClasse() == EnumPNJ.VILLAGEOIS) && (pnj.x == x) && (pnj.y == y + 1))
				return pnj;
			else if ((pnj.getClasse() == EnumPNJ.VILLAGEOIS) && (pnj.x == x) && (pnj.y == y - 1))
				return pnj;
		}
		return null;
	}

	public String faireEchangeVillageois(ArrayList <PNJ> listePNJ){
		PNJ pnj=demanderEchangeAlentour(listePNJ);
		if(pnj==null) return null;

		if(pnj.getClasse()!=EnumPNJ.VILLAGEOIS){ //si c'est un PNJ agressif
			// affichage qu'on ne peut pas parler avec un PNJ agressif
			return null;
		}
		else { //si c'est un villageois
			int volonteArgent=pnj.getVolonteArgent();
			if(pnj.testPossedeClef()){ //si le villageois possede la clef
				if(volonteArgent<=this.getArgent()){ // si le joueur a assez d'argent
					//affichage echange effectue
					this.argent-=volonteArgent;
					this.clef=true;
					pnj.setPossedeClef(false);
					return ("Echange effectue : "+volonteArgent+" $ contre la clef.");
				}
				else { //si le joueur n'a pas assez d'argent
					//affichage joueur n'a pas assez d'argent
					return ("Il faut "+volonteArgent+" $ pour avoir la clef.");
				}
			}
			else{ //si le villageois ne possede plus la clef
				//affichage villageois ne possede pas la clef
				return ("Le villageois n'a plus de clef.");
			}

		}

	}

	// retourne false si il est mort et true si il n'est pas mort
	public boolean etreAttaque(PNJ pnj){
		if(this.vie-pnj.getClasse().getDegats()<=0){
			this.vie=0;
			return false;
		}
		else{
			this.vie-=pnj.getClasse().getDegats();
			return true;
		}
	}

	public String attaquerPNJ(ArrayList <PNJ> listePNJ){
		PNJ pnj;
		boolean estAttaque=false;
		ListIterator i1 = listePNJ.listIterator();
		for (int i = 0; i < listePNJ.size(); i++) {
			pnj = listePNJ.get(i);
			if((pnj.x==this.x+1)&&(pnj.y==this.y)){
				estAttaque=true;
			}
			else if((pnj.x==this.x)&&(pnj.y==this.y+1)){
				estAttaque=true;
			}
			else if((pnj.x==this.x-1)&&(pnj.y==this.y)){
				estAttaque=true;
			}
			else if((pnj.x==this.x)&&(pnj.y==this.y-1)){
				estAttaque=true;
			}
			if(estAttaque==true){
				if(pnj.etreAttaque(this)==false){
					listePNJ.remove(pnj);
					return pnj.getClasse().getNom()+" mort.";
				}
			}
			estAttaque=false;
		}
		return null;
	}

	public void ramasserObjet(World world){
		Element element=world.tile(this.x, this.y);
		if(element==Element.MONEY){
			world.affectationElement(this.x, this.y, Element.FLOOR);
			this.argent++;
		}
		else if((element==Element.LIFE)&&(this.vie<10)){
			world.affectationElement(this.x, this.y, Element.FLOOR);
			this.vie++;
		}
		else if((element==Element.KEY&&(this.clef==false))){
			world.affectationElement(this.x, this.y, Element.FLOOR);
			this.clef=true;
		}
		else if((element==Element.BATTE_BASEBALL)||(element==Element.COUTEAU)||(element==Element.EPEE)){
				Arme arme_deja_possede=this.arme;
				// si il y a une batte par terre on la ramasse
				if(world.tile(this.x, this.y)==Element.BATTE_BASEBALL){
					this.arme=Arme.BATTE_BASEBALL;
					world.affectationElement(this.x, this.y, Element.FLOOR);
				}
				// si il y a un couteau par terre on la ramasse
				else if (world.tile(this.x, this.y)==Element.COUTEAU){
					this.arme=Arme.COUTEAU;
					world.affectationElement(this.x, this.y, Element.FLOOR);
				}
				// si il y a un epee par terre on la ramasse
				else if (world.tile(this.x, this.y)==Element.EPEE){
					this.arme=Arme.EPEE;
					world.affectationElement(this.x, this.y, Element.FLOOR);
				}
				// si l'arme anciennement possedee etait une batte on la pose par terre
				if(arme_deja_possede==Arme.BATTE_BASEBALL){
					world.affectationElement(this.x, this.y, Element.BATTE_BASEBALL);
				}
				// si l'arme anciennement possedee etait un couteau on la pose par terre
				else if(arme_deja_possede==Arme.COUTEAU){
					world.affectationElement(this.x, this.y, Element.COUTEAU);
				}
				// si l'arme anciennement possedee etait une epee on la pose par terre
				else if(arme_deja_possede==Arme.EPEE){
					world.affectationElement(this.x, this.y, Element.EPEE);
				}

		}
	}

	//CHANGER LE NOM ET ENLEVER PLAYER DE PLAYERMOVEBY
	//mettre ca dans Player et pas ds Creature
	public void playerMoveBy(int mx, int my, ArrayList<PNJ> listePNJ){
		ListIterator i1=listePNJ.listIterator();
		boolean test=true;
		for(int i=0; i<listePNJ.size(); i++){
			if((listePNJ.get(i).x==x+mx)&&(listePNJ.get(i).y==y+my)){
				test=false;
			}
		}
		if(test==true) onEnter(x+mx, y+my, this.world.tile(x+mx, y+my));
	}

}
