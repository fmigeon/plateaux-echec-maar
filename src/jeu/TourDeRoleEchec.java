package jeu;

import common.plateau.JPlateau;

public class TourDeRoleEchec implements ATourDeRole {

	private JeuEchec jeu;
	private boolean lesBlancsJouent = true;
	private boolean premierTour = true;

	@Override
	public void tour() {
		if (premierTour()) {
			jeu.getJoueurBlanc().deplacer(null, null);
			toggleJoueur();
		} else {
			JPlateau joueurCourant = tourDesBlancs() ? jeu.getJoueurBlanc() : jeu.getJoueurNoir();
			joueurCourant.deplacer(null, null);
		}
		
		
		}

	private boolean tourDesBlancs() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean premierTour() {
		return false;
	}

	private void toggleJoueur() {
		lesBlancsJouent = !lesBlancsJouent;
		premierTour = false;
	}

}
