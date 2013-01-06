package pl.edu.pw.mini.sozpw.webinterface.services;

import java.util.List;

import pl.edu.pw.mini.sozpw.webinterface.dataobjects.Comment;
import pl.edu.pw.mini.sozpw.webinterface.dataobjects.Note;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("noteservice")
public interface NoteService extends RemoteService {
	
	Integer processNote(Note note);
	
	Boolean addComment(Integer noteId, Comment comment);
	
	Boolean deleteNote(Integer noteId);
	
	List<Note> getNotes(String username);

}