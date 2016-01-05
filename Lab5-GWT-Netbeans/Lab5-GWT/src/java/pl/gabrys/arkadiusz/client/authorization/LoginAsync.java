/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.gabrys.arkadiusz.client.authorization;

import com.google.gwt.user.client.rpc.AsyncCallback;
import pl.gabrys.arkadiusz.shared.User;

/**
 *
 * @author arkad_000
 */
public interface LoginAsync {

    public void login(User user, AsyncCallback<String> callback);
}
