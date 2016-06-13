package pl.edu.mimuw.forum.data;

import pl.edu.mimuw.forum.ui.models.NodeViewModel;

public class Usuwanie extends OperacjaNaWezlach {
	
	public Usuwanie(NodeViewModel przodek, NodeViewModel syn) {
		super(przodek, syn);
	}
	
	public NodeViewModel syn() {
		return syn;
	}
	
	public NodeViewModel przodek() {
		return przodek;
	}
	
	public void dokonaj() {
		przodek.getChildren().remove(syn);
	}
	
	public void cofnij() {
		przodek.getChildren().add(syn);
	}

}
