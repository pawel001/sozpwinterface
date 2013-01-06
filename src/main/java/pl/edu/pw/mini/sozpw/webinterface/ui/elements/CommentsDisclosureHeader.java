package pl.edu.pw.mini.sozpw.webinterface.ui.elements;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CommentsDisclosureHeader extends Composite {

	public CommentsDisclosureHeader(String value) {
		
		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		initWidget(verticalPanel);
		verticalPanel.setWidth("276px");
		
		Label lblKomentarze = new Label(value);
		lblKomentarze.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		lblKomentarze.setStyleName("gwt-CommentDisclosureHeader");
		verticalPanel.add(lblKomentarze);
		verticalPanel.setCellHorizontalAlignment(lblKomentarze, HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.setCellVerticalAlignment(lblKomentarze, HasVerticalAlignment.ALIGN_MIDDLE);
		lblKomentarze.setWidth("276px");

	}

}
