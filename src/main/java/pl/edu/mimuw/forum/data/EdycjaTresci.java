package pl.edu.mimuw.forum.data;

import pl.edu.mimuw.forum.ui.models.NodeViewModel;

public class EdycjaTresci extends Edycja {
	public EdycjaTresci(NodeViewModel edited, String nowyTekst, String staryTekst) {
		super(edited, nowyTekst, staryTekst);
	}

	@Override
	public void dokonaj() {
		edited.getContent().set(nowyTekst);
		ListaOperacji.increase();
	}

	@Override
	public void cofnij() {
		edited.getContent().set(staryTekst);
		ListaOperacji.decrease();
	}
}
