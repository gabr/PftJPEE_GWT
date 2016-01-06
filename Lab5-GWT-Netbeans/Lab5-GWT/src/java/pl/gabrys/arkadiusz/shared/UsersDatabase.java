package pl.gabrys.arkadiusz.shared;

import java.util.ArrayList;

/**
 *  Class for storing users
 * 
 * @author arkad_000
 * @versino 1.0
 */
public class UsersDatabase {
    
    /**
     * List of all users
     */
    private static ArrayList<User> users = new ArrayList<>();
    
    /**
     * Adds givne user to the database if not null
     * @param user the user object to add
     */
    public static void addUser(User user) {
        if (user != null) {
            users.add(user);
        }
    }
    
    /**
     * Returns the list of users
     * @return 
     */
    public static ArrayList<User> getUsers() {
        return (ArrayList<User>)users.clone();
    }
}
