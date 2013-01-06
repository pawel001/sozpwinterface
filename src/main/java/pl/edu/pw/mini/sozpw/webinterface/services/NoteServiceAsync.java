package pl.edu.pw.mini.sozpw.webinterface.services;

import java.util.List;

import pl.edu.pw.mini.sozpw.webinterface.dataobjects.Comment;
import pl.edu.pw.mini.sozpw.webinterface.dataobjects.Note;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface NoteServiceAsync {

	void processNote(Note note, AsyncCallback<Integer> callback);

	void getNotes(String username, AsyncCallback<List<Note>> callback);

	void deleteNote(Integer noteId, AsyncCallback<Boolean> callback);

	void addComment(Integer noteId, Comment comment, AsyncCallback<Boolean> callback);

}
