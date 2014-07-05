package eu.musesproject.server.rt2ae.client.managed.activity;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import eu.musesproject.server.rt2ae.client.managed.request.ApplicationRequestFactory;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.OutcomeDesktopDetailsView;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.OutcomeDesktopEditView;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.OutcomeDesktopListView;
import eu.musesproject.server.rt2ae.client.managed.ui.mobile.OutcomeMobileDetailsView;
import eu.musesproject.server.rt2ae.client.managed.ui.mobile.OutcomeMobileEditView;
import eu.musesproject.server.rt2ae.client.proxy.OpportunityProxy;
import eu.musesproject.server.rt2ae.client.proxy.OutcomeProxy;
import eu.musesproject.server.rt2ae.client.proxy.ThreatProxy;
import eu.musesproject.server.rt2ae.client.request.OutcomeRequest;
import eu.musesproject.server.rt2ae.client.scaffold.ScaffoldApp;
import eu.musesproject.server.rt2ae.client.scaffold.place.ProxyPlace;

public class OutcomeActivitiesMapper extends OutcomeActivitiesMapper_Roo_Gwt {

    public OutcomeActivitiesMapper(ApplicationRequestFactory factory, PlaceController placeController) {
        this.factory = factory;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(((place.getOperation()))) {
            case DETAILS:
                return new OutcomeDetailsActivity((EntityProxyId<OutcomeProxy>) place.getProxyId(), factory, placeController, ScaffoldApp.isMobile() ? OutcomeMobileDetailsView.instance() : OutcomeDesktopDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
