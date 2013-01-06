package pl.edu.pw.mini.sozpw.webinterface.ui.elements;

import pl.edu.pw.mini.sozpw.webinterface.dataobjects.Comment;
import pl.edu.pw.mini.sozpw.webinterface.utils.DateResolver;

public class CommentWidget extends CommentWidgetGenerated {
	
	private final Comment comment;
	
	public CommentWidget(Comment comment) {
		this.comment = comment;
		
		getCommentLabel().setText(comment.getComment());
		getUsernameLabel().setText(
				comment.getUsername() + ", "
						+ DateResolver.resolveDate(comment.getDate()));
	}
	
	public void updateDateOnTimer(){
		getUsernameLabel().setText(
				comment.getUsername() + ", "
						+ DateResolver.resolveDate(comment.getDate()));
	}
}
