package pl.edu.pw.mini.sozpw.webinterface.ui.dialogs;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.DialogBox;

public class RegisterDialog extends RegisterDialogGenerated {
	
	public RegisterDialog(final DialogBox parent){
		
		getOkButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				parent.hide();
			}
		});
		
	}

}
