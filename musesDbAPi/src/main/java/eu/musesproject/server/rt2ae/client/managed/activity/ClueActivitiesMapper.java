package eu.musesproject.server.rt2ae.client.managed.activity;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import eu.musesproject.server.rt2ae.client.managed.request.ApplicationRequestFactory;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.ClueDesktopDetailsView;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.ClueDesktopEditView;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.ClueDesktopListView;
import eu.musesproject.server.rt2ae.client.managed.ui.mobile.ClueMobileDetailsView;
import eu.musesproject.server.rt2ae.client.managed.ui.mobile.ClueMobileEditView;
import eu.musesproject.server.rt2ae.client.proxy.ClueProxy;
import eu.musesproject.server.rt2ae.client.proxy.ThreatProxy;
import eu.musesproject.server.rt2ae.client.request.ClueRequest;
import eu.musesproject.server.rt2ae.client.scaffold.ScaffoldApp;
import eu.musesproject.server.rt2ae.client.scaffold.place.ProxyPlace;

public class ClueActivitiesMapper extends ClueActivitiesMapper_Roo_Gwt {

    public ClueActivitiesMapper(ApplicationRequestFactory factory, PlaceController placeController) {
        this.factory = factory;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(((place.getOperation()))) {
            case DETAILS:
                return new ClueDetailsActivity((EntityProxyId<ClueProxy>) place.getProxyId(), factory, placeController, ScaffoldApp.isMobile() ? ClueMobileDetailsView.instance() : ClueDesktopDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
