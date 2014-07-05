package eu.musesproject.server.rt2ae.client.managed.activity;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import eu.musesproject.server.rt2ae.client.managed.request.ApplicationRequestFactory;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.RiskinformationDesktopDetailsView;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.RiskinformationDesktopEditView;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.RiskinformationDesktopListView;
import eu.musesproject.server.rt2ae.client.managed.ui.mobile.RiskinformationMobileDetailsView;
import eu.musesproject.server.rt2ae.client.managed.ui.mobile.RiskinformationMobileEditView;
import eu.musesproject.server.rt2ae.client.proxy.AccessrequestProxy;
import eu.musesproject.server.rt2ae.client.proxy.AssetProxy;
import eu.musesproject.server.rt2ae.client.proxy.RiskinformationProxy;
import eu.musesproject.server.rt2ae.client.request.RiskinformationRequest;
import eu.musesproject.server.rt2ae.client.scaffold.ScaffoldApp;
import eu.musesproject.server.rt2ae.client.scaffold.place.ProxyPlace;

public class RiskinformationActivitiesMapper extends RiskinformationActivitiesMapper_Roo_Gwt {

    public RiskinformationActivitiesMapper(ApplicationRequestFactory factory, PlaceController placeController) {
        this.factory = factory;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(((place.getOperation()))) {
            case DETAILS:
                return new RiskinformationDetailsActivity((EntityProxyId<RiskinformationProxy>) place.getProxyId(), factory, placeController, ScaffoldApp.isMobile() ? RiskinformationMobileDetailsView.instance() : RiskinformationDesktopDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
