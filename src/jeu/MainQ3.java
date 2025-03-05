package jeu;

import common.plateau.JPlateau;
import echiquier.plateau.DelegatingEchiquier;
import echiquier.plateau.Echiquier;
import echiquier.plateau.ImplementingEchiquier;
import echiquier.roles.Joueur;
import echiquier.roles.Superviseur;

public class MainQ3 {
	
	public static void main(String[] args) {
		Echiquier echiquier = new ImplementingEchiquier();
//		Echiquier echiquier = new DelegatingEchiquier();
		
//		Joueur joueur1 = new Joueur(echiquier.getJPlateau());
//		Joueur joueur2 = new Joueur(echiquier.getJPlateau());
		
		JPlateau proxyTourRole = new TourRoleEchecPlateauProxy(echiquier.getJPlateau());
		
		Joueur joueurBlanc = new Joueur(proxyTourRole);
		Joueur joueurNoir = new Joueur(proxyTourRole);
		
		Superviseur superviseur = new Superviseur(echiquier.getSPlateau());
		
		joueurBlanc.play();
		joueurNoir.play();
		joueurNoir.play();

	}
}
