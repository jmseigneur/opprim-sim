package eu.musesproject.server.rt2ae.client.managed.activity;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import eu.musesproject.server.rt2ae.client.managed.request.ApplicationRequestFactory;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.DeviceSecurityStateDesktopDetailsView;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.DeviceSecurityStateDesktopEditView;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.DeviceSecurityStateDesktopListView;
import eu.musesproject.server.rt2ae.client.managed.ui.mobile.DeviceSecurityStateMobileDetailsView;
import eu.musesproject.server.rt2ae.client.managed.ui.mobile.DeviceSecurityStateMobileEditView;
import eu.musesproject.server.rt2ae.client.proxy.DeviceProxy;
import eu.musesproject.server.rt2ae.client.proxy.DeviceSecurityStateProxy;
import eu.musesproject.server.rt2ae.client.request.DeviceSecurityStateRequest;
import eu.musesproject.server.rt2ae.client.scaffold.ScaffoldApp;
import eu.musesproject.server.rt2ae.client.scaffold.place.ProxyPlace;

public class DeviceSecurityStateActivitiesMapper extends DeviceSecurityStateActivitiesMapper_Roo_Gwt {

    public DeviceSecurityStateActivitiesMapper(ApplicationRequestFactory factory, PlaceController placeController) {
        this.factory = factory;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(((place.getOperation()))) {
            case DETAILS:
                return new DeviceSecurityStateDetailsActivity((EntityProxyId<DeviceSecurityStateProxy>) place.getProxyId(), factory, placeController, ScaffoldApp.isMobile() ? DeviceSecurityStateMobileDetailsView.instance() : DeviceSecurityStateDesktopDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
