package echiquier.plateau;

import common.plateau.JPlateau;
import common.plateau.SPlateau;

public interface Echiquier extends JPlateau, SPlateau {
	
	public default SPlateau getSPlateau() {
		return this;
	}

	public default JPlateau getJPlateau() {
		return this;
	}



}
