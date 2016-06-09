package pl.edu.mimuw.forum.ui.controllers;

import java.util.Date;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import pl.edu.mimuw.forum.data.*;
import pl.edu.mimuw.forum.ui.models.NodeViewModel;

public class AddDialogController {
	
    @FXML private ToggleGroup myToggleGroup;
    
    @FXML private Dialog<NodeViewModel> dialog;

    public void initialize() {
    	
        dialog.getDialogPane().getButtonTypes().addAll(
                ButtonType.OK, ButtonType.CANCEL
        );

        Node okButton = dialog.getDialogPane().lookupButton(ButtonType.OK);
        
        okButton.disableProperty().bind(
                Bindings.isNull(
                        myToggleGroup.selectedToggleProperty()
                )
        );

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
        RadioButton selectedRadio = (RadioButton) myToggleGroup.getSelectedToggle();
        if (selectedRadio == null) {
            return null;
        }
        if (selectedRadio.getText().equals("Comment")) return new Comment("Some text", "Anonymous").getModel();
        else if (selectedRadio.getText().equals("Survey")) return new Survey("Some text", "Anonymous").getModel();
        else if (selectedRadio.getText().equals("Suggestion")) return new Suggestion("Some text", "Anonymous", "Feedback").getModel();
        else if (selectedRadio.getText().equals("Task")) return new Task(new Date(),"Some text", "Anonymous").getModel();
        return null;
    }
}