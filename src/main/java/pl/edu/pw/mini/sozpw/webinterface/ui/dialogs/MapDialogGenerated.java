package pl.edu.pw.mini.sozpw.webinterface.ui.dialogs;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MapDialogGenerated extends Composite {
	private Button addNoteButton;
	private TextBox locationTextBox;

	public MapDialogGenerated() {

		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
		verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		initWidget(verticalPanel);
		verticalPanel.setSize("151px", "82px");

		FlexTable flexTable = new FlexTable();
		verticalPanel.add(flexTable);

		locationTextBox = new TextBox();
		flexTable.setWidget(0, 0, locationTextBox);
		locationTextBox.setWidth("250px");

		addNoteButton = new Button("Dodaj notatkę");
		addNoteButton.setStyleName("gwt-ButtonCustom");
		flexTable.setWidget(1, 0, addNoteButton);
		addNoteButton.setSize("100%", "30px");
	}

	public Button getAddNoteButton() {
		return addNoteButton;
	}

	public TextBox getLocationTextBox() {
		return locationTextBox;
	}
}
