package pl.edu.pw.mini.sozpw.webinterface.ui.elements;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CommentWidgetGenerated extends Composite {
	private Label commentLabel;
	private Label usernameLabel;

	public CommentWidgetGenerated() {
		
		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setStyleName("gwt-NoteComment");
		initWidget(verticalPanel);
		verticalPanel.setWidth("280px");
		
		usernameLabel = new Label("Username");
		verticalPanel.add(usernameLabel);
		usernameLabel.setStyleName("gwt-NoteUsername");
		usernameLabel.setWidth("276px");
		
		commentLabel = new Label("Comment");
		commentLabel.setStyleName("gwt-NoteContent");
		verticalPanel.add(commentLabel);
		commentLabel.setWidth("276px");
	}

	public Label getCommentLabel() {
		return commentLabel;
	}
	public Label getUsernameLabel() {
		return usernameLabel;
	}
}
