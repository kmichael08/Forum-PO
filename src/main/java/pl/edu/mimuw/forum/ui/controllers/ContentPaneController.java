package pl.edu.mimuw.forum.ui.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import pl.edu.mimuw.forum.data.EdycjaAutora;
import pl.edu.mimuw.forum.data.EdycjaTresci;
import pl.edu.mimuw.forum.data.ListaOperacji;
import pl.edu.mimuw.forum.ui.models.NodeViewModel;

public class ContentPaneController extends BasePaneController {
	
	private NodeViewModel model;
	
	@FXML
	private TextField userField;

	@FXML
	private TextArea commentField;
	
	boolean zmiana = false;
	
	public void setModel(NodeViewModel model) {
		zmiana = true;
		if (this.model != null) {
			userField.textProperty().unbindBidirectional(this.model.getAuthor());
			commentField.textProperty().unbindBidirectional(this.model.getContent());
		}

		this.model = model;
		
		if (this.model != null) {
			userField.textProperty().bindBidirectional(this.model.getAuthor());
			commentField.textProperty().bindBidirectional(this.model.getContent());
		}
				
		setHasModel(this.model != null);
		zmiana = false;
	}
			
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		super.initialize(location, resources);

		userProperty().addListener((observable, oldValue, newValue) -> {
			
				if (zmiana == false) {
						// System.out.println("Changing user name: " + oldValue + "->" + newValue);
						ListaOperacji.add(new EdycjaAutora(model, newValue, oldValue));
				}
		});
		
		commentProperty().addListener((observable, oldValue, newValue) -> {
				if (zmiana == false) {
					// System.out.println("Changing comment: " + oldValue + "->" + newValue);
					ListaOperacji.add(new EdycjaTresci(model, newValue, oldValue));
				}
		});
		
	}
	
	public StringProperty userProperty() {
		return userField.textProperty();
	}
	
	public StringProperty commentProperty() {
		return commentField.textProperty();
	}
	
}
