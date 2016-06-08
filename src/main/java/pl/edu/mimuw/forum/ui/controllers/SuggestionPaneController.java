package pl.edu.mimuw.forum.ui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import jfxtras.styles.jmetro8.ToggleSwitch;
import pl.edu.mimuw.forum.ui.models.SuggestionViewModel;

public class SuggestionPaneController extends BasePaneController {

	private SuggestionViewModel model;

	@FXML
	private TextArea suggestionField;

	@FXML
	private ToggleSwitch acceptableField;

	public void setModel(SuggestionViewModel model) {
		if (this.model != null) {
			suggestionField.textProperty().unbindBidirectional(this.model.getResponse());
			acceptableField.selectedProperty().unbindBidirectional(this.model.getIsResponseAccepted());
		}

		this.model = model;

		if (this.model != null) {
			suggestionField.textProperty().bindBidirectional(this.model.getResponse());
			acceptableField.selectedProperty().bindBidirectional(this.model.getIsResponseAccepted());
		}

		setHasModel(model != null);
	}

}
