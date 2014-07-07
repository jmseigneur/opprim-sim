// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

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

public abstract class ThreatActivitiesMapper_Roo_Gwt {

    protected ApplicationRequestFactory factory;

    protected PlaceController placeController;

    protected Activity makeCreateActivity() {
        ThreatDesktopEditView.instance().setCreating(true);
        Activity activity = new ThreatEditActivity(null, factory, ScaffoldApp.isMobile() ? ThreatMobileEditView.instance() : ThreatDesktopEditView.instance(), placeController);
        return new ThreatEditActivityWrapper(factory, ScaffoldApp.isMobile() ? ThreatMobileEditView.instance() : ThreatDesktopEditView.instance(), activity, null);
    }

    @SuppressWarnings("unchecked")
    protected EntityProxyId<ThreatProxy> coerceId(ProxyPlace place) {
        return (EntityProxyId<ThreatProxy>) place.getProxyId();
    }

    protected Activity makeEditActivity(ProxyPlace place) {
        ThreatDesktopEditView.instance().setCreating(false);
        EntityProxyId<ThreatProxy> proxyId = coerceId(place);
        Activity activity = new ThreatEditActivity(proxyId, factory, ScaffoldApp.isMobile() ? ThreatMobileEditView.instance() : ThreatDesktopEditView.instance(), placeController);
        return new ThreatEditActivityWrapper(factory, ScaffoldApp.isMobile() ? ThreatMobileEditView.instance() : ThreatDesktopEditView.instance(), activity, proxyId);
    }
}