package eu.musesproject.server.rt2ae.client.managed.activity;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import eu.musesproject.server.rt2ae.client.managed.request.ApplicationRequestFactory;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.UserActionDesktopDetailsView;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.UserActionDesktopEditView;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.UserActionDesktopListView;
import eu.musesproject.server.rt2ae.client.managed.ui.editor.AccessrequestSetEditor;
import eu.musesproject.server.rt2ae.client.managed.ui.mobile.UserActionMobileDetailsView;
import eu.musesproject.server.rt2ae.client.managed.ui.mobile.UserActionMobileEditView;
import eu.musesproject.server.rt2ae.client.proxy.AccessrequestProxy;
import eu.musesproject.server.rt2ae.client.proxy.UserActionProxy;
import eu.musesproject.server.rt2ae.client.request.UserActionRequest;
import eu.musesproject.server.rt2ae.client.scaffold.ScaffoldApp;
import eu.musesproject.server.rt2ae.client.scaffold.place.ProxyPlace;
import java.util.Set;

public class UserActionActivitiesMapper extends UserActionActivitiesMapper_Roo_Gwt {

    public UserActionActivitiesMapper(ApplicationRequestFactory factory, PlaceController placeController) {
        this.factory = factory;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(((place.getOperation()))) {
            case DETAILS:
                return new UserActionDetailsActivity((EntityProxyId<UserActionProxy>) place.getProxyId(), factory, placeController, ScaffoldApp.isMobile() ? UserActionMobileDetailsView.instance() : UserActionDesktopDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
