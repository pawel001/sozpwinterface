package pl.edu.pw.mini.sozpw.webinterface.server;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import pl.edu.pw.mini.sozpw.dataaccess.model.Model;
import pl.edu.pw.mini.sozpw.dataaccess.model.ModelImpl;
import pl.edu.pw.mini.sozpw.webinterface.dataobjects.Comment;
import pl.edu.pw.mini.sozpw.webinterface.dataobjects.Note;
import pl.edu.pw.mini.sozpw.webinterface.services.NoteService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class NoteServiceImpl extends RemoteServiceServlet implements NoteService {

	Model model = new ModelImpl();

	@Override
	public Integer processNote(Note note) {

		HttpServletRequest request = this.getThreadLocalRequest();
		byte[] attachment = (byte[]) request.getSession().getAttribute(note.getFilename());

//		if (attachment == null) {
//			System.out.println("NoteServiceImpl - no attachment stored in session");
//		}

		if (note.getId() == Note.NO_ID) {
			return model.addNote(note, attachment);
		}

		model.editNote(note, attachment);
		return note.getId();
	}

	@Override
	public List<Note> getNotes(String username) {
		return model.getNotes(username);
	}

	@Override
	public Boolean deleteNote(Integer noteId) {
		return model.deleteNote(noteId);
	}

	@Override
	public Boolean addComment(Integer noteId, Comment comment) {
		return model.addComment(noteId, comment);
	}

}
