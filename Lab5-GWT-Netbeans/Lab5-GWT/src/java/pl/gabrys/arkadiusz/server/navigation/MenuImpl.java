package pl.gabrys.arkadiusz.server.navigation;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.util.ArrayList;

import pl.gabrys.arkadiusz.client.navigation.Menu;
import pl.gabrys.arkadiusz.shared.User;
import pl.gabrys.arkadiusz.shared.UsersDatabase;

/**
 * Class for managing server side tasks needed in menu
 * 
 * @author arkad_000
 * @version 1.0
 */
public class MenuImpl extends RemoteServiceServlet implements Menu {

    /**
     * Returns users names list
     * @return the users names list
     */
    @Override
    public ArrayList<String> getUsers() {
        ArrayList<String> usersNames = new ArrayList<>();
        
        for (User u :UsersDatabase.getUsers()) {
            usersNames.add(u.getName());
        }
        
        return usersNames;
    }
}
