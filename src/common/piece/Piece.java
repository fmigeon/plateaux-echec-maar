package common.piece;

import common.plateau.Coordonnees;

public interface Piece {

	boolean valideDeplacement(Coordonnees from, Coordonnees to);

}
