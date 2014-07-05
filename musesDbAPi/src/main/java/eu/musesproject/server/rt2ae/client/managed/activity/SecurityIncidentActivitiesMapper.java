package eu.musesproject.server.rt2ae.client.managed.activity;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import eu.musesproject.server.rt2ae.client.managed.request.ApplicationRequestFactory;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.SecurityIncidentDesktopDetailsView;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.SecurityIncidentDesktopEditView;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.SecurityIncidentDesktopListView;
import eu.musesproject.server.rt2ae.client.managed.ui.mobile.SecurityIncidentMobileDetailsView;
import eu.musesproject.server.rt2ae.client.managed.ui.mobile.SecurityIncidentMobileEditView;
import eu.musesproject.server.rt2ae.client.proxy.AssetProxy;
import eu.musesproject.server.rt2ae.client.proxy.DeviceProxy;
import eu.musesproject.server.rt2ae.client.proxy.SecurityIncidentProxy;
import eu.musesproject.server.rt2ae.client.proxy.UserProxy;
import eu.musesproject.server.rt2ae.client.request.SecurityIncidentRequest;
import eu.musesproject.server.rt2ae.client.scaffold.ScaffoldApp;
import eu.musesproject.server.rt2ae.client.scaffold.place.ProxyPlace;

public class SecurityIncidentActivitiesMapper extends SecurityIncidentActivitiesMapper_Roo_Gwt {

    public SecurityIncidentActivitiesMapper(ApplicationRequestFactory factory, PlaceController placeController) {
        this.factory = factory;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(((place.getOperation()))) {
            case DETAILS:
                return new SecurityIncidentDetailsActivity((EntityProxyId<SecurityIncidentProxy>) place.getProxyId(), factory, placeController, ScaffoldApp.isMobile() ? SecurityIncidentMobileDetailsView.instance() : SecurityIncidentDesktopDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
