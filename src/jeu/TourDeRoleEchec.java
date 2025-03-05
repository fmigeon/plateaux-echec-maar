package jeu;

import common.plateau.JPlateau;
import echiquier.roles.Joueur;

public class TourDeRoleEchec implements ATourDeRole {

	private JPlateau plateau;
	private Tour tourPrecedent = Tour.NOIR;
	private Tour tourCourant = Tour.BLANC;
	private boolean premierTour = true;

	@Override
	public boolean isTourValidated() {
		return (isPremierTour() || isValidRoundRobin());
		}

	private boolean isValidRoundRobin() {
		return tourPrecedent!=tourCourant;
	}

	private boolean isPremierTour() {
		return premierTour;
	}

	private void toggleJoueur() {
		premierTour = false;
		Tour rr = tourPrecedent;
		tourPrecedent = tourCourant;
		tourCourant = rr;
	}

	protected void alterneTour() {
		// TODO Auto-generated method stub
		
	}
	
}
