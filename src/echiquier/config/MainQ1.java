package echiquier.config;

import echiquier.plateau.DelegatingEchiquier;
import echiquier.plateau.Echiquier;
import echiquier.plateau.ImplementingEchiquier;
import echiquier.roles.Joueur;
import echiquier.roles.Superviseur;

public class MainQ1 {
	
	public static void main(String[] args) {
//		Echiquier echiquier = new ImplementingEchiquier();
		Echiquier echiquier = new DelegatingEchiquier();
		
		Joueur joueur1 = new Joueur(echiquier.getJPlateau());
		Joueur joueur2 = new Joueur(echiquier.getJPlateau());
		
		Superviseur superviseur = new Superviseur(echiquier.getSPlateau());
		
	}
}
