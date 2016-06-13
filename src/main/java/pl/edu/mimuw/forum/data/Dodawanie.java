package pl.edu.mimuw.forum.data;

import pl.edu.mimuw.forum.ui.models.NodeViewModel;

public class Dodawanie extends OperacjaNaWezlach {
	
	public Dodawanie(NodeViewModel przodek, NodeViewModel syn) {
		super(przodek, syn);
	}
	
	public NodeViewModel syn() {
		return syn;
	}
	
	public NodeViewModel przodek() {
		return przodek;
	}
	
	public void dokonaj() {
		przodek.getChildren().add(syn);
	}
	
	public void cofnij() {
		przodek.getChildren().remove(syn);
	}
}
