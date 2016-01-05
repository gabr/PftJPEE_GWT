/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.gabrys.arkadiusz.client.authorization;

import com.google.gwt.core.client.GWT;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import pl.gabrys.arkadiusz.shared.User;

/**
 * Example class using the Login service.
 *
 * @author arkad_000
 */
public class LoginUsage extends VerticalPanel {

    private Label lblLogin = new Label("Name: ");
    private Label lblPass = new Label("Password: ");
    private Label lblServerReply = new Label();
    private Label lblLoginValidation = new Label();
    private Label lblPasswordValidation = new Label();
    private TextBox txtLogin = new TextBox();
    private TextBox txtPass = new TextBox();
    private Button btnSend = new Button("Login");
    
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
            public void onSuccess(String result) {
                lblServerReply.setVisible(true);
                lblServerReply.setText("Logged in: " + result);
                lblServerReply.getElement().getStyle().setColor("green");
                
                lblLogin.setVisible(false);
                lblLoginValidation.setVisible(false);
                txtLogin.setVisible(false);
                lblPass.setVisible(false);
                lblPasswordValidation.setVisible(false);
                txtPass.setVisible(false);
                btnSend.setVisible(false);
            }
            
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
    
    public static LoginAsync getService() {
        return GWT.create(Login.class);
    }
}
