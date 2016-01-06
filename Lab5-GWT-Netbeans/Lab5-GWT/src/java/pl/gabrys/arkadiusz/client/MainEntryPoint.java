package pl.gabrys.arkadiusz.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import pl.gabrys.arkadiusz.client.authorization.LoginUsage;
import pl.gabrys.arkadiusz.client.navigation.MenuUsage;

/**
 * Main entry point.
 *
 * @author arkad_000
 * @version 1.0
 */
public class MainEntryPoint implements EntryPoint {

    /**
     * Creates a new instance of MainEntryPoint
     */
    public MainEntryPoint() {
    }

    /**
     * The entry point method, called automatically by loading a module that
     * declares an implementing class as an entry-point
     */
    @Override
    public void onModuleLoad() {
        RootPanel.get().add(new LoginUsage());
        RootPanel.get().add(new MenuUsage());
    }
}
