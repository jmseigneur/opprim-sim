package eu.musesproject.server.rt2ae.client.managed.activity;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import eu.musesproject.server.rt2ae.client.managed.request.ApplicationRequestFactory;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.RisktreatmentDesktopDetailsView;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.RisktreatmentDesktopEditView;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.RisktreatmentDesktopListView;
import eu.musesproject.server.rt2ae.client.managed.ui.mobile.RisktreatmentMobileDetailsView;
import eu.musesproject.server.rt2ae.client.managed.ui.mobile.RisktreatmentMobileEditView;
import eu.musesproject.server.rt2ae.client.proxy.RiskcommunicationProxy;
import eu.musesproject.server.rt2ae.client.proxy.RisktreatmentProxy;
import eu.musesproject.server.rt2ae.client.request.RisktreatmentRequest;
import eu.musesproject.server.rt2ae.client.scaffold.ScaffoldApp;
import eu.musesproject.server.rt2ae.client.scaffold.place.ProxyPlace;

public class RisktreatmentActivitiesMapper extends RisktreatmentActivitiesMapper_Roo_Gwt {

    public RisktreatmentActivitiesMapper(ApplicationRequestFactory factory, PlaceController placeController) {
        this.factory = factory;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(((place.getOperation()))) {
            case DETAILS:
                return new RisktreatmentDetailsActivity((EntityProxyId<RisktreatmentProxy>) place.getProxyId(), factory, placeController, ScaffoldApp.isMobile() ? RisktreatmentMobileDetailsView.instance() : RisktreatmentDesktopDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
