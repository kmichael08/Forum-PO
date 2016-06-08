package pl.edu.mimuw.forum.ui.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import pl.edu.mimuw.forum.ui.models.NodeViewModel;

public class ContentPaneController extends BasePaneController {
	
	private NodeViewModel model;
	
	@FXML
	private TextField userField;

	@FXML
	private TextArea commentField;
	
	public void setModel(NodeViewModel model) {
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
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		super.initialize(location, resources);
		
		userProperty().addListener((observable, oldValue, newValue) -> {
			System.out.println("Changing user name: " + oldValue + "->" + newValue);
		});
		
		commentProperty().addListener((observable, oldValue, newValue) -> {
			System.out.println("Changing comment: " + oldValue + "->" + newValue);
		});
	}
	
	public StringProperty userProperty() {
		return userField.textProperty();
	}
	
	public StringProperty commentProperty() {
		return commentField.textProperty();
	}
	
}
