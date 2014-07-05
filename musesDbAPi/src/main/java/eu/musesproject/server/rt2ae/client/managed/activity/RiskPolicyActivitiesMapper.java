package eu.musesproject.server.rt2ae.client.managed.activity;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import eu.musesproject.server.rt2ae.client.managed.request.ApplicationRequestFactory;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.RiskPolicyDesktopDetailsView;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.RiskPolicyDesktopEditView;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.RiskPolicyDesktopListView;
import eu.musesproject.server.rt2ae.client.managed.ui.mobile.RiskPolicyMobileDetailsView;
import eu.musesproject.server.rt2ae.client.managed.ui.mobile.RiskPolicyMobileEditView;
import eu.musesproject.server.rt2ae.client.proxy.RiskPolicyProxy;
import eu.musesproject.server.rt2ae.client.request.RiskPolicyRequest;
import eu.musesproject.server.rt2ae.client.scaffold.ScaffoldApp;
import eu.musesproject.server.rt2ae.client.scaffold.place.ProxyPlace;

public class RiskPolicyActivitiesMapper extends RiskPolicyActivitiesMapper_Roo_Gwt {

    public RiskPolicyActivitiesMapper(ApplicationRequestFactory factory, PlaceController placeController) {
        this.factory = factory;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(((place.getOperation()))) {
            case DETAILS:
                return new RiskPolicyDetailsActivity((EntityProxyId<RiskPolicyProxy>) place.getProxyId(), factory, placeController, ScaffoldApp.isMobile() ? RiskPolicyMobileDetailsView.instance() : RiskPolicyDesktopDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
