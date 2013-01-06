package pl.edu.pw.mini.sozpw.webinterface.server;

import pl.edu.pw.mini.sozpw.webinterface.services.InfoService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class InfoServiceImpl extends RemoteServiceServlet implements InfoService{

	@Override
	public String getInfo(String username) {
		return "bardzo swietny user";
	}

}
