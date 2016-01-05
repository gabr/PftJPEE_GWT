/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.gabrys.arkadiusz.client.authorization;

import com.google.gwt.user.client.rpc.AsyncCallback;
import pl.gabrys.arkadiusz.shared.User;


/**
 * Login service local
 * @author arkad_000
 * @version 1.0
 */
public interface LoginAsync {

    /**
     * Adds user if not exists
     * @param user the user to add
     * @param callback the function on result
     */
    public void login(User user, AsyncCallback<String> callback);
}
