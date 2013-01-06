package pl.edu.pw.mini.sozpw.webinterface.ui;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MainUIGenerated extends Composite {
	private Hyperlink mainHyperlink;
	private Hyperlink settingsHyperlink;
	private Hyperlink groupsHyperlink;
	private VerticalPanel contentPanel;
	private Label usernameLabel;
	private Button logoutButton;

	public MainUIGenerated() {

		VerticalPanel verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);

		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setStyleName("gwt-menuPanel");
		verticalPanel.add(absolutePanel);
		absolutePanel.setSize("1024px", "40px");

		mainHyperlink = new Hyperlink("Strona główna", false, "main");
		mainHyperlink.setStyleName("gwt-HyperlinkCustomCurrent a:LINK");
		absolutePanel.add(mainHyperlink, 40, 10);

		groupsHyperlink = new Hyperlink("Grupy", false, "groups");
		groupsHyperlink.setStyleName("gwt-HyperlinkCustom");
		absolutePanel.add(groupsHyperlink, 148, 10);

		settingsHyperlink = new Hyperlink("Ustawienia", false, "settings");
		settingsHyperlink.setStyleName("gwt-HyperlinkCustom");
		absolutePanel.add(settingsHyperlink, 209, 10);
		
		usernameLabel = new Label("");
		usernameLabel.setStyleName("gwt-LabelUser");
		usernameLabel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		absolutePanel.add(usernameLabel, 555, 10);
		usernameLabel.setSize("300px", "18px");
		
		logoutButton = new Button("Wyloguj");
		logoutButton.setText("Wyloguj");
		logoutButton.setStyleName("gwt-ButtonLogout");
		absolutePanel.add(logoutButton, 931, 8);
		logoutButton.setSize("60px", "20px");
		
		Image image = new Image("images/separator.png");
		absolutePanel.add(image, 898, 7);
		image.setSize("1px", "26px");

		contentPanel = new VerticalPanel();
		contentPanel.setStyleName("gwt-contentPanel");
		contentPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.add(contentPanel);
		contentPanel.setSize("1024px", "560px");

	}

	public Hyperlink getMainHyperlink() {
		return mainHyperlink;
	}

	public Hyperlink getSettingsHyperlink() {
		return settingsHyperlink;
	}

	public Hyperlink getGroupsHyperlink() {
		return groupsHyperlink;
	}

	protected VerticalPanel getContentPanel() {
		return contentPanel;
	}
	protected Label getUsernameLabel() {
		return usernameLabel;
	}
	protected Button getLogoutButton() {
		return logoutButton;
	}
}
