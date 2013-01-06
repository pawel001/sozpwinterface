package pl.edu.pw.mini.sozpw.webinterface.ui.elements;

import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.event.logical.shared.OpenEvent;
import com.google.gwt.event.logical.shared.OpenHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ValueBoxBase.TextAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class NoteWidgetGenerated extends Composite {
	private Button editButton;
	private TextBox commentTextBox;
	private Label topicLabel;
	private Button markerButton;
	private Label contentLabel;
	private Button deleteButton;
	private Label usernameLabel;
	private VerticalPanel commentPanel;
	private Button detailsButton;
	private HorizontalPanel horizontalPanel;
	private Button addCommentButton;
	private HorizontalPanel horizontalPanel_1;
	private HorizontalPanel horizontalPanel_2;
	private DisclosurePanel disclosurePanel;

	public NoteWidgetGenerated() {
		
		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.setStyleName("gwt-Note");
		initWidget(verticalPanel);
		
		horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1.setStyleName("gwt-NoteMainHeaderHighlight");
		verticalPanel.add(horizontalPanel_1);
		horizontalPanel_1.setWidth("100%");
		
		horizontalPanel_2 = new HorizontalPanel();
		horizontalPanel_1.add(horizontalPanel_2);
		horizontalPanel_2.setSize("80px", "18px");
		
		detailsButton = new Button("Szczegóły");
		horizontalPanel_2.add(detailsButton);
		detailsButton.setStyleName("gwt-NoteButtonDetails");
		detailsButton.setText("");
		detailsButton.setSize("18px", "18px");
		
		markerButton = new Button("Znajdź na mapie");
		horizontalPanel_2.add(markerButton);
		markerButton.setStyleName("gwt-NoteButtonMarker");
		markerButton.setText("");
		markerButton.setSize("18px", "18px");
		
		editButton = new Button("Edytuj");
		horizontalPanel_2.add(editButton);
		editButton.setStyleName("gwt-NoteButtonEdit");
		editButton.setText("");
		editButton.setSize("18px", "18px");
		
		deleteButton = new Button("Usuń");
		horizontalPanel_2.add(deleteButton);
		deleteButton.setStyleName("gwt-NoteButtonDelete");
		deleteButton.setText("");
		deleteButton.setSize("18px", "18px");
		
		usernameLabel = new Label("Username");
		verticalPanel.add(usernameLabel);
		usernameLabel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		horizontalPanel_1.setCellHorizontalAlignment(usernameLabel, HasHorizontalAlignment.ALIGN_RIGHT);
		horizontalPanel_1.setCellVerticalAlignment(usernameLabel, HasVerticalAlignment.ALIGN_MIDDLE);
		usernameLabel.setStyleName("gwt-NoteUsername");
		usernameLabel.setSize("276px", "18px");
		
		topicLabel = new Label("Temat");
		topicLabel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		topicLabel.setStyleName("gwt-NoteTopic");
		verticalPanel.add(topicLabel);
		topicLabel.setWidth("276px");
		
		contentLabel = new Label("Treść");
		contentLabel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		contentLabel.setStyleName("gwt-NoteContent");
		verticalPanel.add(contentLabel);
		contentLabel.setWidth("276px");
		
		disclosurePanel = new DisclosurePanel("Komentarze");
		disclosurePanel.setAnimationEnabled(true);
		disclosurePanel.setStyleName("gwt-DisclosurePanelC");
		disclosurePanel.setHeader(new CommentsDisclosureHeader("Pokaż komentarze"));
		disclosurePanel.addOpenHandler(new OpenHandler<DisclosurePanel>() {
			@Override
			public void onOpen(OpenEvent<DisclosurePanel> event) {
				disclosurePanel.setHeader(new CommentsDisclosureHeader("Schowaj komentarze"));		
			}
		});
		disclosurePanel.addCloseHandler(new CloseHandler<DisclosurePanel>() {
			
			@Override
			public void onClose(CloseEvent<DisclosurePanel> event) {
				disclosurePanel.setHeader(new CommentsDisclosureHeader("Pokaż komentarze"));
			}
		});
		verticalPanel.add(disclosurePanel);
		verticalPanel.setCellHorizontalAlignment(disclosurePanel, HasHorizontalAlignment.ALIGN_CENTER);
		
		FlowPanel flowPanel = new FlowPanel();
		flowPanel.setStyleName("gwt-CommentDisclosurePanel");
		disclosurePanel.setContent(flowPanel);
		flowPanel.setWidth("276px");
		
		commentPanel = new VerticalPanel();
		flowPanel.add(commentPanel);
		commentPanel.setWidth("100%");
		commentPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		
		horizontalPanel = new HorizontalPanel();
		horizontalPanel.setStyleName("gwt-CommentDisclosureHorizontal");
		horizontalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		flowPanel.add(horizontalPanel);
		horizontalPanel.setWidth("100%");
		
		commentTextBox = new TextBox();
		commentTextBox.setAlignment(TextAlignment.LEFT);
		commentTextBox.setStyleName("gwt-CommentTextBox");
		horizontalPanel.add(commentTextBox);
		horizontalPanel.setCellHorizontalAlignment(commentTextBox, HasHorizontalAlignment.ALIGN_CENTER);
		commentTextBox.setWidth("251px");
		
		addCommentButton = new Button("New button");
		addCommentButton.setStyleName("gwt-NoteButtonComment");
		addCommentButton.setText("");
		horizontalPanel.add(addCommentButton);
		addCommentButton.setSize("23px", "23px");
	}
	public Button getEditButton() {
		return editButton;
	}
	public TextBox getCommentTextBox() {
		return commentTextBox;
	}
	public Label getTopicLabel() {
		return topicLabel;
	}
	public Button getMarkerButton() {
		return markerButton;
	}
	public Label getContentLabel() {
		return contentLabel;
	}
	public Button getDeleteButton() {
		return deleteButton;
	}
	public Label getUsernameLabel() {
		return usernameLabel;
	}
	public VerticalPanel getCommentPanel() {
		return commentPanel;
	}
	public Button getDetailsButton() {
		return detailsButton;
	}
	protected DisclosurePanel getDisclosurePanel() {
		return disclosurePanel;
	}
	public Button getAddCommentButton() {
		return addCommentButton;
	}
}
