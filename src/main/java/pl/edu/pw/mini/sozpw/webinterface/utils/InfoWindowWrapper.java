package pl.edu.pw.mini.sozpw.webinterface.utils;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.maps.gwt.client.GoogleMap;
import com.google.maps.gwt.client.InfoWindow;
import com.google.maps.gwt.client.LatLng;

public class InfoWindowWrapper {

	static class FakePanel extends ComplexPanel {
		public FakePanel(Widget w) {
			w.removeFromParent();
			getChildren().add(w);
			adopt(w);
		}

		@Override
		public boolean isAttached() {
			return true;
		}

		public void detachWidget() {
			this.remove(0);
		}
	}

	private InfoWindow info;
	private IsWidget widgetContent = null;
	FakePanel widgetAttacher;
	
	private InfoWindowWrapper() {
	}

	public static InfoWindowWrapper create() {
		InfoWindowWrapper myInfo = new InfoWindowWrapper();
		myInfo.info = InfoWindow.create();
		return myInfo;
	};

	private void detachWidget() {
		if (this.widgetAttacher != null) {
			this.widgetAttacher.detachWidget();
			this.widgetAttacher = null;
		}
	}

	public void close() {
		info.close();
		detachWidget();
	}

	public void setPosition(LatLng posicao) {
		info.setPosition(posicao);
	}

	public void open(GoogleMap map) {
		info.open(map);
	}

	public void setContent(Widget value) {
		this.widgetContent = value;
		info.setContent(value.getElement());

		if (this.widgetAttacher == null) {
			addListener(info, "closeclick", new Runnable() {
				@Override
				public void run() {
					detachWidget();
				}
			});
			this.widgetAttacher = new FakePanel(value);
		} else if (this.widgetAttacher.getWidget(0) != value) {
			this.widgetAttacher.detachWidget();
			this.widgetAttacher = new FakePanel(value);
		}
	}

	private void setContent(Element element) {
		this.setContent(element);
	}

	public IsWidget getContentWidget() {
		return widgetContent;
	}

	public final native void addListener(JavaScriptObject jso, String whichEvent, Runnable handler)
	/*-{
		var that = jso;
		$wnd.google.maps.event.addListener(jso, whichEvent, function() {
			handler.@java.lang.Runnable::run()();
		});
	}-*/;
}