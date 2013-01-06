package pl.edu.pw.mini.sozpw.webinterface.ui.elements;

import pl.edu.pw.mini.sozpw.webinterface.utils.FileUploadProperties;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
import com.google.gwt.user.client.ui.VerticalPanel;

public class UploadWidget extends Composite {

	private VerticalPanel panel;
	private UploadComposite uploadComposite;
	private FileComposite fileComposite;

	public UploadWidget() {

		panel = new VerticalPanel();
		initWidget(panel);
		initComposites();

		panel.add(uploadComposite);
	}

	public UploadWidget(String filename) {

		panel = new VerticalPanel();
		initWidget(panel);
		initComposites();

		if (filename.equals("")) {
			panel.add(uploadComposite);
		} else {
			fileComposite.getFileLabel().setText(filename);
			panel.add(fileComposite);
		}
	}

	private void initComposites() {

		uploadComposite = new UploadComposite();
		uploadComposite.getFileUpload().setName("fileUploadField");

		uploadComposite.getAddButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (Cookies.isCookieEnabled()) {
					uploadComposite.getFormPanel().submit();
				} else {
					Window.alert("Aby dodać załącznik do notatki, włącz obsługę ciasteczek w przeglądarce");
				}
			}
		});

		uploadComposite.getFormPanel().addSubmitHandler(new FormPanel.SubmitHandler() {
			public void onSubmit(SubmitEvent event) {
				uploadComposite.getAddButton().setEnabled(false);
				uploadComposite.getStatusLabel().setText("");
			}
		});

		fileComposite = new FileComposite();
		fileComposite.getDeleteButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				panel.clear();
				uploadComposite.getAddButton().setEnabled(true);
				uploadComposite.getFormPanel().reset();
				panel.add(uploadComposite);

			}
		});

		uploadComposite.getFormPanel().addSubmitCompleteHandler(
				new FormPanel.SubmitCompleteHandler() {
					public void onSubmitComplete(SubmitCompleteEvent event) {

						if (event.getResults() != null
								&& event.getResults().equals(FileUploadProperties.SUBMIT_SUCCESS)) {
							panel.clear();
							fileComposite.getFileLabel().setText(UploadWidget.this.getFilename());
							panel.add(fileComposite);
							return;
						}

						uploadComposite.getAddButton().setEnabled(true);
						uploadComposite.getFormPanel().reset();

						if (event.getResults() == null) {
							uploadComposite.getStatusLabel().setText(
									"Wystąpił błąd podczas przesyłania pliku");

						} else if (event.getResults().equals(FileUploadProperties.SUBMIT_TOO_LARGE)) {
							uploadComposite.getStatusLabel().setText("Plik zbyt duży");
						} else {
							uploadComposite.getStatusLabel().setText("Nieznany błąd");
						}

					}
				});
	}

	public String getFilename() {
		return uploadComposite.getFileUpload().getFilename().replaceAll("^.*[\\\\/]", "");
	}

}
