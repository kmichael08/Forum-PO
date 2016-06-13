package pl.edu.mimuw.forum.data;

import pl.edu.mimuw.forum.ui.models.NodeViewModel;

public class EdycjaAutora extends Edycja {
	public EdycjaAutora(NodeViewModel edited, String nowyTekst, String staryTekst) {
		super(edited, nowyTekst, staryTekst);
	}

	@Override
	public void dokonaj() {
		edited.getAuthor().set(nowyTekst);
		ListaOperacji.increase();
	}

	@Override
	public void cofnij() {
		edited.getAuthor().set(staryTekst);
		ListaOperacji.decrease();
	}
	
}
