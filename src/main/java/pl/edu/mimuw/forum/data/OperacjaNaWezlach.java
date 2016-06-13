package pl.edu.mimuw.forum.data;

import pl.edu.mimuw.forum.ui.models.NodeViewModel;

public abstract class OperacjaNaWezlach extends Operacja {

	protected NodeViewModel syn;
	
	protected NodeViewModel przodek;
		
	public OperacjaNaWezlach(NodeViewModel przodek, NodeViewModel syn) {
		this.przodek = przodek;
		this.syn = syn;
	}
	
	public NodeViewModel syn() {
		return syn;
	}
	
	public NodeViewModel przodek() {
		return przodek;
	}

}
