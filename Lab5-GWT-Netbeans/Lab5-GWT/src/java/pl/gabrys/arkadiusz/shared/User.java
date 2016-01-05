package pl.gabrys.arkadiusz.shared;

import java.io.Serializable;

/**
 * Class represents single User
 * @author arkad_000
 */
public class User implements Serializable {
    
    /**
     * User name
     */
    private String name;
    
    /**
     * User password
     */
    private String password;
    
    /**
     * User default constructor
     */
    public User() {
        this.name = new String();
        this.password = new String();
    }
    
    /**
     * User constructor
     * @param name the user name
     * @param password the user password
     */
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    /**
     * Returns class string representation
     * @return class string representation
     */
    @Override
    public String toString() {
        return this.name;
    }

    /**
     * Returns class hash code
     * @return class hash code
     */
    @Override
    public int hashCode() {
        return toString().hashCode();
    }
    
    
}
