package pl.edu.pw.mini.sozpw.webinterface.ui.dialogs;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;

public class RegisterDialogGenerated extends Composite {
	private Button okButton;

	public RegisterDialogGenerated() {
		AbsolutePanel absolutePanel = new AbsolutePanel();
		initWidget(absolutePanel);
		absolutePanel.setSize("380px", "120px");
		
		Label label = new Label("Aby zakończyć proces sprawdź skrzynkę pocztową.");
		label.setStyleName("gwt-LabelCenter");
		absolutePanel.add(label, 10, 29);
		label.setSize("360px", "30px");
		
		okButton = new Button("Ok");
		okButton.setStyleName("gwt-ButtonCustom");
		absolutePanel.add(okButton, 10, 80);
		okButton.setSize("360px", "25px");
	}

	protected Button getOkButton() {
		return okButton;
	}
}
