package jeu;

import common.piece.Piece;
import common.plateau.Coordonnees;
import common.plateau.JPlateau;
import echiquier.roles.Joueur;

public class TourRoleEchecPlateauProxy extends TourDeRoleEchec implements JPlateau {

	private JPlateau realPlateau;
	
	public TourRoleEchecPlateauProxy(JPlateau realPlateau) {
		super();
		this.realPlateau = realPlateau;
	}

	@Override
	public Piece obtenir(Coordonnees coordonnees) {
		assert obtenirPolicyValidation();
		return realPlateau.obtenir(coordonnees);
	}

	@Override
	public void deplacer(Coordonnees from, Coordonnees to) {
		assert deplacerPolicyValidation();
		realPlateau.deplacer(from, to);
		super.alterneTour();
	}
	
	private boolean obtenirPolicyValidation() {
		return true;
	}

	private boolean deplacerPolicyValidation() {
		return super.isTourValidated();
	}
}
