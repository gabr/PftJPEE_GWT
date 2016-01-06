/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.gabrys.arkadiusz.client.navigation;

import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.ArrayList;

/**
 * Async interface of Menu servlet
 * 
 * @author arkad_000
 * @version 1.0
 */
public interface MenuAsync {

    /**
     * Gets users from database
     * @param callback the function on result
     */
    public void getUsers(AsyncCallback<ArrayList<String>> callback);
}
