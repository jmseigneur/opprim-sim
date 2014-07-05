package eu.musesproject.server.rt2ae.client.managed.activity;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import eu.musesproject.server.rt2ae.client.managed.request.ApplicationRequestFactory;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.ThreatDesktopDetailsView;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.ThreatDesktopEditView;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.ThreatDesktopListView;
import eu.musesproject.server.rt2ae.client.managed.ui.editor.AccessrequestSetEditor;
import eu.musesproject.server.rt2ae.client.managed.ui.editor.ClueSetEditor;
import eu.musesproject.server.rt2ae.client.managed.ui.editor.OutcomeSetEditor;
import eu.musesproject.server.rt2ae.client.managed.ui.mobile.ThreatMobileDetailsView;
import eu.musesproject.server.rt2ae.client.managed.ui.mobile.ThreatMobileEditView;
import eu.musesproject.server.rt2ae.client.proxy.AccessrequestProxy;
import eu.musesproject.server.rt2ae.client.proxy.ClueProxy;
import eu.musesproject.server.rt2ae.client.proxy.OutcomeProxy;
import eu.musesproject.server.rt2ae.client.proxy.ThreatProxy;
import eu.musesproject.server.rt2ae.client.request.ThreatRequest;
import eu.musesproject.server.rt2ae.client.scaffold.ScaffoldApp;
import eu.musesproject.server.rt2ae.client.scaffold.place.ProxyPlace;
import java.util.Set;

public class ThreatActivitiesMapper extends ThreatActivitiesMapper_Roo_Gwt {

    public ThreatActivitiesMapper(ApplicationRequestFactory factory, PlaceController placeController) {
        this.factory = factory;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(((place.getOperation()))) {
            case DETAILS:
                return new ThreatDetailsActivity((EntityProxyId<ThreatProxy>) place.getProxyId(), factory, placeController, ScaffoldApp.isMobile() ? ThreatMobileDetailsView.instance() : ThreatDesktopDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
