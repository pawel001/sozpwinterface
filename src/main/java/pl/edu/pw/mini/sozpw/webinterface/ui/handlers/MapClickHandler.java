package pl.edu.pw.mini.sozpw.webinterface.ui.handlers;

import pl.edu.pw.mini.sozpw.webinterface.ui.dialogs.MapDialog;
import pl.edu.pw.mini.sozpw.webinterface.ui.pages.MainPage;
import pl.edu.pw.mini.sozpw.webinterface.utils.Geolocalizator;
import pl.edu.pw.mini.sozpw.webinterface.utils.Geolocalizator.GeoCallback;
import pl.edu.pw.mini.sozpw.webinterface.utils.InfoWindowWrapper;

import com.google.maps.gwt.client.GoogleMap.ClickHandler;
import com.google.maps.gwt.client.LatLng;
import com.google.maps.gwt.client.MouseEvent;

public class MapClickHandler implements ClickHandler {

	private MainPage mainPage;

	public MapClickHandler(MainPage mainPage) {
		this.mainPage = mainPage;
	}

	@Override
	public void handle(MouseEvent event) {
		final InfoWindowWrapper infowindow = InfoWindowWrapper.create();
		final LatLng position = event.getLatLng();
		final MapDialog mapDialog = new MapDialog(mainPage, position);

		Geolocalizator.putStringLocation(position, new GeoCallback() {
			@Override
			public void geocodeSuccess(String location) {
				mapDialog.getLocationTextBox().setText(location);
			}
		});

		infowindow.setContent(mapDialog);
		infowindow.setPosition(position);
		infowindow.open(mainPage.getMap());

	}

}
