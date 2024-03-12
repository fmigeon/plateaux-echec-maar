package echiquier.plateau;

import common.piece.Piece;
import common.plateau.Coordonnees;

public enum PieceEchec implements Piece {
	ROI, REINE, FOU, CAVALIER, TOUR, PION,  VIDE;

	@Override
	public boolean valideDeplacement(Coordonnees from, Coordonnees to) {
		return true;
	}
}
