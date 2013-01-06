package pl.edu.pw.mini.sozpw.webinterface.client;

import pl.edu.pw.mini.sozpw.webinterface.services.LoginService;
import pl.edu.pw.mini.sozpw.webinterface.services.LoginServiceAsync;
import pl.edu.pw.mini.sozpw.webinterface.ui.LoginUI;
import pl.edu.pw.mini.sozpw.webinterface.ui.MainUI;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;

public class CoreView implements EntryPoint {

	LoginServiceAsync loginService;

	@Override
	public void onModuleLoad() {
		loginService = (LoginServiceAsync) GWT.create(LoginService.class);

		loginService.getUserFromSession(new AsyncCallback<String>() {

			@Override
			public void onSuccess(String result) {
				if (result != null) {
					RootPanel.get("mp_page_content_center").add(new MainUI(result));
				} else {
					RootPanel.get("mp_page_content_center").add(new LoginUI());
				}
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("RPC loginService.getUserFromSession() failed.");
			}
		});

	}

}
