package pl.edu.pw.mini.sozpw.webinterface.ui.elements;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

public class UploadComposite extends Composite {
	private FlowPanel flowPanel;
	private FormPanel formPanel;
	private HorizontalPanel horizontalPanel;
	private FileUpload fileUpload;
	private Button addButton;
	private Label statusLabel;

	public UploadComposite() {
		
		flowPanel = new FlowPanel();
		initWidget(flowPanel);
		
		formPanel = new FormPanel();
		formPanel.setMethod(FormPanel.METHOD_POST);
		formPanel.setEncoding(FormPanel.ENCODING_MULTIPART);
		formPanel.setAction(GWT.getHostPageBaseURL() + "FileUploadServlet");
		flowPanel.add(formPanel);
		
		horizontalPanel = new HorizontalPanel();
		formPanel.setWidget(horizontalPanel);
		horizontalPanel.setSize("100%", "30px");
		
		fileUpload = new FileUpload();
		horizontalPanel.add(fileUpload);
		fileUpload.setSize("250px", "");
		
		addButton = new Button("Dodaj");
		addButton.setStyleName("gwt-ButtonCustomFile");
		horizontalPanel.add(addButton);
		addButton.setSize("56px", "24px");
		
		statusLabel = new Label("");
		statusLabel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		statusLabel.setStyleName("gwt-LabelErr");
		flowPanel.add(statusLabel);
		statusLabel.setSize("100%", "20px");
	}
	protected FormPanel getFormPanel() {
		return formPanel;
	}
	protected Button getAddButton() {
		return addButton;
	}
	public FileUpload getFileUpload() {
		return fileUpload;
	}
	public Label getStatusLabel() {
		return statusLabel;
	}
}
