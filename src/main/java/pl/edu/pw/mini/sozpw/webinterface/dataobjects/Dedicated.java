package pl.edu.pw.mini.sozpw.webinterface.dataobjects;

import com.google.gwt.core.client.JavaScriptObject;

public class Dedicated extends JavaScriptObject {

	protected Dedicated() {
	}

	public final native String getName() /*-{
		return this.name;
	}-*/;

	public final native int getId() /*-{
		return this.id;
	}-*/;

}
