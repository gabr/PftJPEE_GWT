/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.gabrys.arkadiusz.client.authorization;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import pl.gabrys.arkadiusz.shared.User;

/**
 *
 * @author arkad_000
 */
@RemoteServiceRelativePath("authorization/login")
public interface Login extends RemoteService {

    public String login(User user);
}
