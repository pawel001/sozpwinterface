package pl.edu.pw.mini.sozpw.webinterface.ui.pages;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ScrollPanel;

public class MainPageGenerated extends Composite {
	private Button filtersButton;
	private FlowPanel mapPanel;
	private ScrollPanel scrollPanel;
	private FlowPanel notesPanel;

	public MainPageGenerated() {

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		initWidget(horizontalPanel);

		mapPanel = new FlowPanel();
		mapPanel.setStyleName("gwt-mapCanvas");
		horizontalPanel.add(mapPanel);
		mapPanel.setSize("700px", "560px");

		AbsolutePanel absolutePanel = new AbsolutePanel();
		horizontalPanel.add(absolutePanel);
		horizontalPanel.setCellHorizontalAlignment(absolutePanel, HasHorizontalAlignment.ALIGN_CENTER);
		absolutePanel.setSize("324px", "560px");

		filtersButton = new Button("Filtruj wiadomości");
		filtersButton.setText("Filtruj wiadomości");
		filtersButton.setStyleName("gwt-ButtonCustom");
		absolutePanel.add(filtersButton, 10, 10);
		filtersButton.setSize("304px", "30px");
		
		scrollPanel = new ScrollPanel();
		absolutePanel.add(scrollPanel, 10, 46);
		scrollPanel.setSize("304px", "484px");
		
		notesPanel = new FlowPanel();
		scrollPanel.setWidget(notesPanel);
		notesPanel.setSize("284px", "100%");
		notesPanel.setStyleName("gwt-MainNotePanel");
	}

	protected Button getFiltersButton() {
		return filtersButton;
	}

	protected FlowPanel getMapPanel() {
		return mapPanel;
	}

	public ScrollPanel getScrollPanel() {
		return scrollPanel;
	}
	public FlowPanel getNotesPanel() {
		return notesPanel;
	}
}
