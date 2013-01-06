package pl.edu.pw.mini.sozpw.webinterface.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("infoservice")
public interface InfoService extends RemoteService {
	
	String getInfo(String username);

}
