/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.gabrys.arkadiusz.server.authorization;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.util.ArrayList;

import pl.gabrys.arkadiusz.client.authorization.Login;
import pl.gabrys.arkadiusz.shared.User;

/**
 * Servlet class handling Login action
 * @author arkad_000
 */
public class LoginImpl extends RemoteServiceServlet implements Login {
    
    private static ArrayList<User> users;

    public String login(User user) {
        return user.getName() + " " + user.getPassword();
    }
}
