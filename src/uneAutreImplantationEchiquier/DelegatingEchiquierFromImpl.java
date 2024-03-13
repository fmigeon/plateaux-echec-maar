package uneAutreImplantationEchiquier;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import common.piece.Piece;
import common.plateau.Coordonnees;
import common.plateau.JPlateau;
import common.plateau.SPlateau;
import echiquier.plateau.Echiquier;

public class DelegatingEchiquierFromImpl implements Echiquier {
	
	private SPlateau plateauSuperviseur = new EchiquierSuperviseurAdapter();
	private JPlateau plateauJoueur = new EchiquierJoueurAdapter();
	
	private UnEchiquierImpl autreEchiquier;
	
	private class EchiquierSuperviseurAdapter implements SPlateau {

		@Override
		public <Disposition extends Collection<Piece>> void initialiser(Disposition disposition) {
			autreEchiquier.init();
		}
		
		@Override
		public Collection<Piece>  extraire() {
			return autreEchiquier.extract();
		}

		@Override
		public <Disposition extends Collection<Piece>> void disposer(Disposition disposition) {
			autreEchiquier.dispatch();
		}
	}
	
	private class EchiquierJoueurAdapter implements JPlateau {

		@Override
		public Piece obtenir(Coordonnees coordonnees) {
			return autreEchiquier.obtain();
		}

		@Override
		public void deplacer(Coordonnees from, Coordonnees to) {
			autreEchiquier.move();
		}
		
	}
	
	public SPlateau getSPlateau() {
		return plateauSuperviseur;
	}

	public JPlateau getJPlateau() {
		return plateauJoueur;
	}

	@Override
	public Piece obtenir(Coordonnees coordonnees) {
		return plateauJoueur.obtenir(coordonnees);
	}

	@Override
	public void deplacer(Coordonnees from, Coordonnees to) {
		plateauJoueur.deplacer(from, to);
	}

	@Override
	public <Disposition extends Collection<Piece>> void initialiser(Disposition disposition) {
		plateauSuperviseur.initialiser(disposition);
	}

	@Override
	public Collection<Piece> extraire() {
		return plateauSuperviseur.extraire();
	}

	@Override
	public <Disposition extends Collection<Piece>> void disposer(Disposition disposition) {
		plateauSuperviseur.disposer(disposition);
	}


}
