package pl.gabrys.arkadiusz.client.authorization;

import com.google.gwt.core.client.GWT;

import com.google.gwt.user.client.rpc.AsyncCallback;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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
     * Label for server reply
     */
    private Label lblServerReply = new Label();
    
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
    private Button btnSend = new Button("Register");
    
    /**
     * Class default constructor.
     * Creates interactive register form.
     */
    public LoginUsage() {
        add(lblServerReply);
        add(lblLogin);
        add(lblLoginValidation);
        add(txtLogin);
        add(lblPass);
        add(lblPasswordValidation);
        add(txtPass);
        add(btnSend);
        
        lblServerReply.setVisible(false);
        lblServerReply.getElement().getStyle().setColor("red");
        lblLoginValidation.setVisible(false);
        lblLoginValidation.getElement().getStyle().setColor("red");
        lblPasswordValidation.setVisible(false);
        lblPasswordValidation.getElement().getStyle().setColor("red");

        final AsyncCallback<String> callback = new AsyncCallback<String>() {
            @Override
            public void onSuccess(String result) {
                
                if (!result.equals("")) {
                    lblServerReply.setVisible(true);
                    lblServerReply.setText(result);
                    return;
                }
                
                lblServerReply.setVisible(true);
                lblServerReply.setText("Registered in");
                lblServerReply.getElement().getStyle().setColor("green");
                
                lblLogin.setVisible(false);
                lblLoginValidation.setVisible(false);
                txtLogin.setVisible(false);
                lblPass.setVisible(false);
                lblPasswordValidation.setVisible(false);
                txtPass.setVisible(false);
                btnSend.setVisible(false);
            }
            
            @Override
            public void onFailure(Throwable caught) {
                lblServerReply.setVisible(true);
                lblServerReply.setText(caught.getMessage());
            }
        };

        btnSend.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                lblServerReply.setVisible(false);
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
