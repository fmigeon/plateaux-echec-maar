package common.plateau;

import java.util.Collection;

import common.piece.Piece;

public interface SPlateau {

	public <Disposition extends Collection<Piece>> void initialiser(Disposition disposition);
	public Collection<Piece>  extraire();
	public <Disposition extends Collection<Piece>> void disposer(Disposition disposition);
}
