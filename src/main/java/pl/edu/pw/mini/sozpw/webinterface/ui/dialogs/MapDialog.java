package pl.edu.pw.mini.sozpw.webinterface.ui.dialogs;

import pl.edu.pw.mini.sozpw.webinterface.ui.pages.MainPage;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.maps.gwt.client.LatLng;

public class MapDialog extends MapDialogGenerated {

	private final MainPage mainPage;
	private final LatLng position;

	public MapDialog(MainPage mainPage, LatLng position) {

		this.mainPage = mainPage;
		this.position = position;

		this.getAddNoteButton().addClickHandler(new com.google.gwt.event.dom.client.ClickHandler() {
			@Override
			public void onClick(ClickEvent Event) {
				
				StyledDialogBox sdb = new StyledDialogBox("Dodaj notatkę");
				AddNoteDialog and = new AddNoteDialog(sdb, MapDialog.this, MapDialog.this.mainPage);
				sdb.add(and);
				sdb.center();
				and.setTokenInput();
			}
		});
		
	}

	public LatLng getPosition() {
		return position;
	}

}
