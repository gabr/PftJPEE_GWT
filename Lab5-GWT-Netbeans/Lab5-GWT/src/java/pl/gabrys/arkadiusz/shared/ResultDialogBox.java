package pl.gabrys.arkadiusz.shared;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Dialog box class for showing result in dialog box
 * 
 * @author arkad_000
 * @version 1.0
 */
public class ResultDialogBox extends DialogBox {
    
    /**
     * Creates result dialog box with given text
     * @param text the text to display
     */
    public ResultDialogBox(String text) {
        setText("Result");
        //setGlassEnabled(true);
        setAnimationEnabled(true);
        
        Button ok = new Button("OK");
        ok.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                ResultDialogBox.this.hide();
            }
        });
        
        Label label = new Label(text);
        VerticalPanel panel = new VerticalPanel();
        panel.setHeight("100");
        panel.setWidth("300");
        panel.setSpacing(10);
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        panel.add(label);
        panel.add(ok);
        
        setWidget(panel);
    }    
}
