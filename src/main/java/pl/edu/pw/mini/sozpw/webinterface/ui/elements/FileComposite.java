package pl.edu.pw.mini.sozpw.webinterface.ui.elements;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

public class FileComposite extends Composite {
	private Label fileLabel;
	private Button deleteButton;

	public FileComposite() {
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		initWidget(horizontalPanel);
		horizontalPanel.setSize("100%", "50px");
		
		fileLabel = new Label("file name");
		fileLabel.setStyleName("gwt-LabelFile");
		horizontalPanel.add(fileLabel);
		fileLabel.setWidth("240px");
		
		deleteButton = new Button("Usuń");
		deleteButton.setStyleName("gwt-ButtonCustomFile");
		horizontalPanel.add(deleteButton);
		deleteButton.setSize("56px", "24px");

	}

	public Label getFileLabel() {
		return fileLabel;
	}
	public Button getDeleteButton() {
		return deleteButton;
	}
}
