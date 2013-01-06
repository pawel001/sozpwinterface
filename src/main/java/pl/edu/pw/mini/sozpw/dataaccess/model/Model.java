package pl.edu.pw.mini.sozpw.dataaccess.model;

import java.util.List;

import pl.edu.pw.mini.sozpw.webinterface.dataobjects.Comment;
import pl.edu.pw.mini.sozpw.webinterface.dataobjects.Note;
import pl.edu.pw.mini.sozpw.webinterface.dataobjects.User;

public interface Model {
	
	User loginUser(String username, String pass);
	
	String registerUser(String username, String pass, String mail);
	
	boolean confirmRegistration(String key);
	
	List<Note> getNotes(String user);
	
	Integer addNote(Note note, byte[] attachment);
	
	boolean addComment(int noteId, Comment comment);
	
	boolean editNote(Note note, byte[] attachment);
	
	boolean deleteNote(Integer noteId);
	
	List<String> getDedicationHints(String query, int count);

}
