package common.plateau;

import common.piece.Piece;

public interface JPlateau {

	public Piece obtenir(Coordonnees coordonnees);
	public void deplacer(Coordonnees from, Coordonnees to);
	
}
