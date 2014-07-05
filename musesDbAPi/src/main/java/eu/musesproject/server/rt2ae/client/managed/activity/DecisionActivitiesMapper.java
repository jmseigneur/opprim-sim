package eu.musesproject.server.rt2ae.client.managed.activity;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import eu.musesproject.server.rt2ae.client.managed.request.ApplicationRequestFactory;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.DecisionDesktopDetailsView;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.DecisionDesktopEditView;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.DecisionDesktopListView;
import eu.musesproject.server.rt2ae.client.managed.ui.mobile.DecisionMobileDetailsView;
import eu.musesproject.server.rt2ae.client.managed.ui.mobile.DecisionMobileEditView;
import eu.musesproject.server.rt2ae.client.proxy.DecisionProxy;
import eu.musesproject.server.rt2ae.client.proxy.RiskcommunicationProxy;
import eu.musesproject.server.rt2ae.client.request.DecisionRequest;
import eu.musesproject.server.rt2ae.client.scaffold.ScaffoldApp;
import eu.musesproject.server.rt2ae.client.scaffold.place.ProxyPlace;

public class DecisionActivitiesMapper extends DecisionActivitiesMapper_Roo_Gwt {

    public DecisionActivitiesMapper(ApplicationRequestFactory factory, PlaceController placeController) {
        this.factory = factory;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(((place.getOperation()))) {
            case DETAILS:
                return new DecisionDetailsActivity((EntityProxyId<DecisionProxy>) place.getProxyId(), factory, placeController, ScaffoldApp.isMobile() ? DecisionMobileDetailsView.instance() : DecisionDesktopDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
