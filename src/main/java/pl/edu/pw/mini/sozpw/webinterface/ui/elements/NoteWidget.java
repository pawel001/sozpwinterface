package pl.edu.pw.mini.sozpw.webinterface.ui.elements;

import java.util.Date;

import pl.edu.pw.mini.sozpw.webinterface.dataobjects.Comment;
import pl.edu.pw.mini.sozpw.webinterface.dataobjects.Note;
import pl.edu.pw.mini.sozpw.webinterface.services.NoteService;
import pl.edu.pw.mini.sozpw.webinterface.services.NoteServiceAsync;
import pl.edu.pw.mini.sozpw.webinterface.ui.dialogs.AddNoteDialog;
import pl.edu.pw.mini.sozpw.webinterface.ui.dialogs.NoteDetails;
import pl.edu.pw.mini.sozpw.webinterface.ui.dialogs.StyledDialogBox;
import pl.edu.pw.mini.sozpw.webinterface.ui.pages.MainPage;
import pl.edu.pw.mini.sozpw.webinterface.utils.DateResolver;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.maps.gwt.client.Animation;
import com.google.maps.gwt.client.LatLng;
import com.google.maps.gwt.client.Marker;

public class NoteWidget extends NoteWidgetGenerated {

	private final Note note;
	private final Marker marker;
	private final MainPage mainPage;

	public NoteWidget(MainPage mainPage, Note note, Marker marker) {
		this.mainPage = mainPage;
		this.marker = marker;
		this.note = note;

		resolveNote(note);

		getAddCommentButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				addComment();
			}
		});

		getCommentTextBox().addKeyPressHandler(new KeyPressHandler() {

			@Override
			public void onKeyPress(KeyPressEvent event) {
				if (event.getNativeEvent().getKeyCode() == KeyCodes.KEY_ENTER) {
					addComment();
				}
			}
		});

		getMarkerButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				showOnMap();
			}
		});

		getDetailsButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				showDetails();
			}
		});

		getEditButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				StyledDialogBox sdb = new StyledDialogBox("Edytuj notatkę");
				AddNoteDialog and = new AddNoteDialog(sdb, NoteWidget.this.note, NoteWidget.this.mainPage);
				sdb.add(and);
				sdb.center();
				and.setTokenInput();
				for(String name : NoteWidget.this.note.getDedicationList()){
					and.addToken(name);
				}
			}
		});
		
		getDeleteButton().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				NoteWidget.this.mainPage.deleteNote(NoteWidget.this.note);
			}
		});
	}

	private void resolveNote(Note note) {
		updateVisibleAccordingToNote(note);
		resolveComments(note);
	}

	private void resolveComments(Note note) {
		for (Comment comment : note.getComments()) {
			getCommentPanel().add(new CommentWidget(comment));
		}
	}

	private void updateVisibleAccordingToNote(Note note) {
		getUsernameLabel().setText(
				note.getUsername() + ", " + DateResolver.resolveDate(note.getCreateDate()));
		getTopicLabel().setText(note.getTopic());
		getContentLabel().setText(note.getContent());
	}
	
	public void updateAccordingToNote(Note note){
		updateVisibleAccordingToNote(note);
		this.note.setAccordingToNote(note);
	}

	private void addComment() {
		if (getCommentTextBox().getValue() == "")
			return;

		final Comment comment = new Comment();
		comment.setUsername(mainPage.getUsername());
		comment.setComment(getCommentTextBox().getValue());
		comment.setDate(new Date().getTime());

		note.getComments().add(comment);

		NoteServiceAsync noteService = (NoteServiceAsync) GWT.create(NoteService.class);

		noteService.addComment(note.getId(), comment, new AsyncCallback<Boolean>() {

			@Override
			public void onSuccess(Boolean result) {
				if(result)
					getCommentPanel().add(new CommentWidget(comment));
			}

			@Override
			public void onFailure(Throwable caught) {
				note.getComments().remove(comment);
			}
		});

		getCommentTextBox().setText("");
	}

	private void showOnMap() {
		LatLng position = LatLng.create(note.getLatitude(), note.getLongitude());
		if (!mainPage.getMap().getBounds().contains(position)) {
			mainPage.getMap().setCenter(position);
		}

		marker.setAnimation(Animation.BOUNCE);
		(new Timer() {
			@Override
			public void run() {
				marker.setAnimation(null);
			}
		}).schedule(1400);
	}

	private void showDetails() {
		StyledDialogBox sdb = new StyledDialogBox("Szczegóły");
		sdb.add(new NoteDetails(sdb, note));
		sdb.center();
	}

	public void updateDateOnTimer() {
		getUsernameLabel().setText(
				note.getUsername() + ", " + DateResolver.resolveDate(note.getCreateDate()));
	}

	public void disableForEdit() {
		getEditButton().setEnabled(false);
		getEditButton().setStyleName("gwt-NoteButtonDisabled");
		getDeleteButton().setEnabled(false);
		getDeleteButton().setStyleName("gwt-NoteButtonDisabled");
	}

	public Note getNote() {
		return note;
	}

	public Marker getMarker() {
		return marker;
	}
	
	
}
