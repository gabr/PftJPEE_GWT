package pl.gabrys.arkadiusz.client.authorization;

import com.google.gwt.core.client.GWT;

import com.google.gwt.user.client.rpc.AsyncCallback;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import pl.gabrys.arkadiusz.shared.ResultDialogBox;
import pl.gabrys.arkadiusz.shared.User;

/**
 * Ussage of the Login service
 * @author arkad_000
 * @version 1.0
 */
public class LoginUsage extends VerticalPanel {

    /**
     * Label for user name
     */
    private Label lblLogin = new Label("Name: ");
    
    /**
     * Label for user password
     */
    private Label lblPass = new Label("Password: ");
    
    /**
     * Label for login validatino messages
     */
    private Label lblLoginValidation = new Label();
    
    /**
     * Label for password validation messages
     */
    private Label lblPasswordValidation = new Label();
    
    /**
     * Text box for user name
     */
    private TextBox txtLogin = new TextBox();
    
    /**
     * Text box for user password
     */
    private TextBox txtPass = new TextBox();
    
    /**
     * Submit button
     */
    private Button btnSend = new Button("Register new user");
    
    /**
     * Class default constructor.
     * Creates interactive register form.
     */
    public LoginUsage() {
        add(lblLogin);
        add(lblLoginValidation);
        add(txtLogin);
        add(lblPass);
        add(lblPasswordValidation);
        add(txtPass);
        add(btnSend);
        
        lblLoginValidation.setVisible(false);
        lblLoginValidation.getElement().getStyle().setColor("red");
        lblPasswordValidation.setVisible(false);
        lblPasswordValidation.getElement().getStyle().setColor("red");

        final AsyncCallback<String> callback = new AsyncCallback<String>() {
            @Override
            public void onSuccess(String result) {
                
                if (!result.equals("")) {
                    ResultDialogBox dialog = new ResultDialogBox(result);
                    dialog.show();
                    return;
                }
                
                ResultDialogBox dialog = new ResultDialogBox("Registered in");
                dialog.show();
            }
            
            @Override
            public void onFailure(Throwable caught) {
                ResultDialogBox dialog = new ResultDialogBox(caught.getMessage());
                dialog.show();
            }
        };

        btnSend.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                lblLoginValidation.setVisible(false);
                lblPasswordValidation.setVisible(false);
        
                String name = txtLogin.getText();
                
                if (name.trim().isEmpty()) {
                    lblLoginValidation.setVisible(true);
                    lblLoginValidation.setText("Cannot be empty!");
                    return;
                }
                
                String password = txtPass.getText();
                
                if (password.trim().isEmpty()) {
                    lblPasswordValidation.setVisible(true);
                    lblPasswordValidation.setText("Cannot be empty!");
                    return;
                }
                
                User user = new User(name, password);
                getService().login(user, callback);
            }
        });
    }
    
    /**
     * Gets service object
     * @return Login service object
     */
    public static LoginAsync getService() {
        return GWT.create(Login.class);
    }
}
