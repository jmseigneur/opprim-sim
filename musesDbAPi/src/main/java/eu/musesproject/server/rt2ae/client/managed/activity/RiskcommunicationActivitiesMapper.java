package eu.musesproject.server.rt2ae.client.managed.activity;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import eu.musesproject.server.rt2ae.client.managed.request.ApplicationRequestFactory;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.RiskcommunicationDesktopDetailsView;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.RiskcommunicationDesktopEditView;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.RiskcommunicationDesktopListView;
import eu.musesproject.server.rt2ae.client.managed.ui.editor.AccessrequestSetEditor;
import eu.musesproject.server.rt2ae.client.managed.ui.editor.DecisionSetEditor;
import eu.musesproject.server.rt2ae.client.managed.ui.editor.RisktreatmentSetEditor;
import eu.musesproject.server.rt2ae.client.managed.ui.mobile.RiskcommunicationMobileDetailsView;
import eu.musesproject.server.rt2ae.client.managed.ui.mobile.RiskcommunicationMobileEditView;
import eu.musesproject.server.rt2ae.client.proxy.AccessrequestProxy;
import eu.musesproject.server.rt2ae.client.proxy.DecisionProxy;
import eu.musesproject.server.rt2ae.client.proxy.RiskcommunicationProxy;
import eu.musesproject.server.rt2ae.client.proxy.RisktreatmentProxy;
import eu.musesproject.server.rt2ae.client.request.RiskcommunicationRequest;
import eu.musesproject.server.rt2ae.client.scaffold.ScaffoldApp;
import eu.musesproject.server.rt2ae.client.scaffold.place.ProxyPlace;
import java.util.Set;

public class RiskcommunicationActivitiesMapper extends RiskcommunicationActivitiesMapper_Roo_Gwt {

    public RiskcommunicationActivitiesMapper(ApplicationRequestFactory factory, PlaceController placeController) {
        this.factory = factory;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(((place.getOperation()))) {
            case DETAILS:
                return new RiskcommunicationDetailsActivity((EntityProxyId<RiskcommunicationProxy>) place.getProxyId(), factory, placeController, ScaffoldApp.isMobile() ? RiskcommunicationMobileDetailsView.instance() : RiskcommunicationDesktopDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
