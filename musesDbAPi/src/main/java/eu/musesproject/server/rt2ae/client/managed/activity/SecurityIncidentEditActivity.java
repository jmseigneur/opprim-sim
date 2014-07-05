package eu.musesproject.server.rt2ae.client.managed.activity;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import eu.musesproject.server.rt2ae.client.managed.request.ApplicationRequestFactory;
import eu.musesproject.server.rt2ae.client.managed.ui.SecurityIncidentEditView;
import eu.musesproject.server.rt2ae.client.managed.ui.SecurityIncidentEditView.Delegate;
import eu.musesproject.server.rt2ae.client.proxy.AssetProxy;
import eu.musesproject.server.rt2ae.client.proxy.DeviceProxy;
import eu.musesproject.server.rt2ae.client.proxy.SecurityIncidentProxy;
import eu.musesproject.server.rt2ae.client.proxy.UserProxy;
import eu.musesproject.server.rt2ae.client.request.SecurityIncidentRequest;
import eu.musesproject.server.rt2ae.client.scaffold.place.AbstractProxyEditActivity;
import eu.musesproject.server.rt2ae.client.scaffold.place.ProxyListPlace;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SecurityIncidentEditActivity extends AbstractProxyEditActivity<SecurityIncidentProxy> implements Delegate {

    private final SecurityIncidentEditView<?> view;

    private final SecurityIncidentRequest request;

    public SecurityIncidentEditActivity(EntityProxyId<SecurityIncidentProxy> proxyId, ApplicationRequestFactory factory, SecurityIncidentEditView<?> view, PlaceController placeController) {
        super(proxyId, factory, placeController);
        this.view = view;
        this.request = factory.securityIncidentRequest();
    }

    @Override
    protected SecurityIncidentEditView<?> getView() {
        return view;
    }

    @Override
    public void start(AcceptsOneWidget display, EventBus eventBus) {
        this.view.setDelegate(this);
        super.start(display, eventBus);
    }

    @Override
    protected SecurityIncidentProxy createProxy() {
        return request.create(SecurityIncidentProxy.class);
    }

    @Override
    protected RequestContext createSaveRequest(SecurityIncidentProxy proxy) {
        request.persist().using(proxy);
        return request;
    }
}
