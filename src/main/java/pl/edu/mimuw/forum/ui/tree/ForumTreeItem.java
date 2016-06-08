package pl.edu.mimuw.forum.ui.tree;

import javafx.collections.ListChangeListener;
import javafx.scene.control.TreeItem;
import pl.edu.mimuw.forum.ui.models.NodeViewModel;

public class ForumTreeItem extends TreeItem<NodeViewModel> {

	private ListChangeListener<NodeViewModel> listener;
	
	public ForumTreeItem(NodeViewModel node) {
		super(node);
	}

	public void setChildListener(ListChangeListener<NodeViewModel> childListener) {
		removeChildListener();
		listener = childListener;
		getValue().getChildren().addListener(childListener);
	}
	
	public void removeChildListener() {
		if (listener != null) {
			getValue().getChildren().removeListener(listener);
		}
	}
	
}
