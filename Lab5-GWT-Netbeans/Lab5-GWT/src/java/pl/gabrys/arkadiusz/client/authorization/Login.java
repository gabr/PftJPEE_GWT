package pl.gabrys.arkadiusz.client.authorization;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import pl.gabrys.arkadiusz.shared.User;

/**
 * Login service remote interface
 * @author arkad_000
 * @version 1.0
 */
@RemoteServiceRelativePath("authorization/login")
public interface Login extends RemoteService {

    /**
     * Adds user if not exists
     * @param user the user to add
     * @return empty if no errors
     */
    public String login(User user);
}
