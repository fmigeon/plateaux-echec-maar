package uneAutreImplantationEchiquier;

import echiquier.plateau.DelegatingEchiquier;
import echiquier.plateau.Echiquier;
import echiquier.plateau.ImplementingEchiquier;
import echiquier.roles.Joueur;
import echiquier.roles.Superviseur;

public class MainQ2 {
	
	public static void main(String[] args) {
//		Echiquier echiquier = new ImplementingEchiquier();
//		Echiquier echiquier = new DelegatingEchiquier();
		Echiquier echiquier = new DelegatingEchiquierFromImpl();
		
		Joueur joueur1 = new Joueur(echiquier.getJPlateau());
		Joueur joueur2 = new Joueur(echiquier.getJPlateau());
		
		Superviseur superviseur = new Superviseur(echiquier.getSPlateau());

		joueur1.play();
		joueur2.play();
		joueur2.play();
		
	}
}
