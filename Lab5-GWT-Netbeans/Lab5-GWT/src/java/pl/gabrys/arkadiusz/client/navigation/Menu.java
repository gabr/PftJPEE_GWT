/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.gabrys.arkadiusz.client.navigation;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.ArrayList;

/**
 * Interface for remote service
 * @author arkad_000
 * @version 1.0
 */
@RemoteServiceRelativePath("navigation/menu")
public interface Menu extends RemoteService {

    /**
     * Gets users list from database
     * @return the users list
     */
    public ArrayList<String> getUsers();
}
