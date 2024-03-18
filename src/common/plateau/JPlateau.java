package common.plateau;

import common.piece.Piece;

public interface JPlateau<TypePiece extends Piece> {

	public  TypePiece obtenir(Coordonnees coordonnees);
	public void deplacer(Coordonnees from, Coordonnees to);
	
}
