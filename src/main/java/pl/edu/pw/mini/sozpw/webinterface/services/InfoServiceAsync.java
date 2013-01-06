package pl.edu.pw.mini.sozpw.webinterface.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface InfoServiceAsync {

	void getInfo(String username, AsyncCallback<String> callback);

}
