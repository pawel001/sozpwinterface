package pl.edu.pw.mini.sozpw.webinterface.ui.dialogs;

import com.google.gwt.user.client.ui.DialogBox;

public class StyledDialogBox extends DialogBox {

	public StyledDialogBox(String title) {
		this.setStyleName("gwt-dialogBox");
		this.setText(title);
		this.setAnimationEnabled(true);
		this.setGlassEnabled(true);
		this.setModal(false);
	}

}
