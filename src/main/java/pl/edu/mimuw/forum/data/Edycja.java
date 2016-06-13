package pl.edu.mimuw.forum.data;

import pl.edu.mimuw.forum.ui.models.NodeViewModel;

public abstract class Edycja extends Operacja {
	protected String nowyTekst;
	protected String staryTekst;
	protected NodeViewModel edited;
	
	public Edycja(NodeViewModel edited, String nowyTekst, String staryTekst) {
		this.edited = edited;
		this.nowyTekst = nowyTekst;
		this.staryTekst = staryTekst;
	}

	public abstract void dokonaj();
		

	public abstract void cofnij();
}
