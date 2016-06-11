package pl.edu.mimuw.forum.ui.controllers;

import java.util.Date;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import pl.edu.mimuw.forum.data.*;
import pl.edu.mimuw.forum.ui.models.NodeViewModel;

public class AddDialogController {
	
    @FXML 
    private Dialog<NodeViewModel> dialog;
	
    @FXML 
    private ToggleGroup myToggleGroup;
        
	@FXML
	private TextField userField;

	@FXML
	private TextArea commentField;


    public void initialize() {
    	
        dialog.getDialogPane().getButtonTypes().addAll(
                ButtonType.OK, ButtonType.CANCEL
        );
        
        Node okButton = dialog.getDialogPane().lookupButton(ButtonType.OK);
        
        okButton.disableProperty().bind(
                Bindings.isNull(
                        myToggleGroup.selectedToggleProperty()
                ));
    		
        dialog.setResultConverter(this::convertDialogResult);
    }

    private NodeViewModel convertDialogResult(ButtonType buttonType) {
    	if (ButtonType.OK.equals(buttonType)) {
            return getSelectedToggleValue();
        } 
        else {
            return null;
        }
    }

    private NodeViewModel getSelectedToggleValue() {
        String author = userField.getText();
        String content = commentField.getText();
        
        if (author.equals(""))
        	author = "Anonymous";
        
        RadioButton selectedRadio = (RadioButton) myToggleGroup.getSelectedToggle();
        if (selectedRadio == null) {
            return null;
        }
        
        
        if (selectedRadio.getText().equals("Comment")) 
        	return new Comment(content, author).getModel();
        else if (selectedRadio.getText().equals("Survey")) 
        	return new Survey(content, author).getModel();
        else if (selectedRadio.getText().equals("Suggestion")) 
        	return new Suggestion(content, author, "Feedback").getModel();
        else if (selectedRadio.getText().equals("Task")) 
        	return new Task(new Date(),content, author).getModel();
        
        return null;
    }
}