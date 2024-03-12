package echiquier.plateau;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import common.piece.Piece;
import common.plateau.Coordonnees;
import common.plateau.JPlateau;
import common.plateau.SPlateau;

public class ImplementingEchiquier implements Echiquier {

	private Map<Coordonnees,Piece> plateauReel = new HashMap<>();
	
		@Override
		public <Disposition extends Collection<Piece>> void initialiser(Disposition disposition) {
			for(Piece piece : disposition)
					plateauReel.putIfAbsent(new Coordonnees() {}, piece);
		}
		
		@Override
		public Collection<Piece>  extraire() {
			return plateauReel.values();
		}

		@Override
		public <Disposition extends Collection<Piece>> void disposer(Disposition disposition) {
			for(Piece piece : disposition)
				plateauReel.putIfAbsent(new Coordonnees() {}, piece);
		}
	
		@Override
		public Piece obtenir(Coordonnees coordonnees) {
			return plateauReel.get(coordonnees);
		}

		@Override
		public void deplacer(Coordonnees from, Coordonnees to) {
			Piece pieceADeplacer = plateauReel.get(from);
			if (pieceADeplacer.valideDeplacement(from, to)) {
				plateauReel.put(to, pieceADeplacer);
				plateauReel.put(from, PieceEchec.VIDE);
			}
		}

}
