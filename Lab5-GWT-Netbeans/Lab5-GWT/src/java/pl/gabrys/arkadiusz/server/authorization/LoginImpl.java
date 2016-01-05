package pl.gabrys.arkadiusz.server.authorization;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.util.ArrayList;

import pl.gabrys.arkadiusz.client.authorization.Login;
import pl.gabrys.arkadiusz.shared.User;

/**
 * Servlet class handling Login action
 * @author arkad_000
 * @version 1.0
 */
public class LoginImpl extends RemoteServiceServlet implements Login {
    
    /**
     * Users array
     */
    private static ArrayList<User> users = new ArrayList<User>();

    /**
     * Adds new user if not already exist
     * @param user the user to add
     * @return empty if success
     */
    @Override
    public String login(User user) {
        for (User u : users) {
            if (u.getName().equals(user.getName())) {
                return "User already exist";
            }
        }
        
        users.add(user);
        return "";
    }
}
