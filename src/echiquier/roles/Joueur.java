package echiquier.roles;

import common.plateau.Coordonnees;
import common.plateau.JPlateau;

public class Joueur {

	private JPlateau plateauEchecs;

	public Joueur(JPlateau plateauEchecs) {
		super();
		this.plateauEchecs = plateauEchecs;
	}
	
	public void play() {
		Coordonnees startCoordinates = startCoordinatesChoice();
		Coordonnees endCoordinates = endCoordinatesChoice();
		plateauEchecs.deplacer(startCoordinates, endCoordinates);
	}

	private Coordonnees endCoordinatesChoice() {
		return null;
	}

	private Coordonnees startCoordinatesChoice() {
		return null;
	}
}
