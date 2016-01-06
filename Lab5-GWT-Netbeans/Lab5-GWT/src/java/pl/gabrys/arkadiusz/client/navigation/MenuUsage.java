package pl.gabrys.arkadiusz.client.navigation;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;

import com.google.gwt.user.client.rpc.AsyncCallback;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.view.client.ListDataProvider;
import java.util.ArrayList;
import java.util.List;
import pl.gabrys.arkadiusz.shared.ResultDialogBox;

/**
 * Creates menu view and manages its actions.
 *
 * @author arkad_000
 * @version 1.0
 */
public class MenuUsage extends VerticalPanel {
    
    /**
     * Refresh button
     */
    private Button btnShow = new Button("Show/refresh users list");
    
    /**
     * List of users
     */
    private CellList<String> usersList = new CellList<String>(new TextCell());
    
    /**
     * Data provider for users list
     */
    private ListDataProvider<String> usersDataProvider = new ListDataProvider<String>();
    
    /**
     * Constructor, creates menu with register form and button to show users
     */
    public MenuUsage() {
        usersDataProvider.addDataDisplay(usersList);
        
        add(btnShow);
        add(usersList);
        
        // Create an asynchronous callback to handle the result.
        final AsyncCallback<ArrayList<String> > callback = new AsyncCallback<ArrayList<String> >() {
            public void onSuccess(ArrayList<String> users) {
                List<String> list = usersDataProvider.getList();
                list.clear();
                
                for (int i = 0; i < users.size(); i++) {
                    list.add((i + 1) + ". " + users.get(i));
                }
            }
            
            public void onFailure(Throwable caught) {
                ResultDialogBox dialog = new ResultDialogBox(caught.getMessage());
                dialog.show();
            }
        };

        btnShow.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                getService().getUsers(callback);
            }
        });
    }
    
    /**
     * Gets menu object
     * @return Menu service object
     */
    public static MenuAsync getService() {
        return GWT.create(Menu.class);
    }
}
