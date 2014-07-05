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
import eu.musesproject.server.rt2ae.client.managed.ui.ThreatEditView;
import eu.musesproject.server.rt2ae.client.managed.ui.ThreatEditView.Delegate;
import eu.musesproject.server.rt2ae.client.managed.ui.editor.AccessrequestSetEditor;
import eu.musesproject.server.rt2ae.client.managed.ui.editor.ClueSetEditor;
import eu.musesproject.server.rt2ae.client.managed.ui.editor.OutcomeSetEditor;
import eu.musesproject.server.rt2ae.client.proxy.AccessrequestProxy;
import eu.musesproject.server.rt2ae.client.proxy.ClueProxy;
import eu.musesproject.server.rt2ae.client.proxy.OutcomeProxy;
import eu.musesproject.server.rt2ae.client.proxy.ThreatProxy;
import eu.musesproject.server.rt2ae.client.request.ThreatRequest;
import eu.musesproject.server.rt2ae.client.scaffold.place.AbstractProxyEditActivity;
import eu.musesproject.server.rt2ae.client.scaffold.place.ProxyListPlace;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class ThreatEditActivity extends AbstractProxyEditActivity<ThreatProxy> implements Delegate {

    private final ThreatEditView<?> view;

    private final ThreatRequest request;

    public ThreatEditActivity(EntityProxyId<ThreatProxy> proxyId, ApplicationRequestFactory factory, ThreatEditView<?> view, PlaceController placeController) {
        super(proxyId, factory, placeController);
        this.view = view;
        this.request = factory.threatRequest();
    }

    @Override
    protected ThreatEditView<?> getView() {
        return view;
    }

    @Override
    public void start(AcceptsOneWidget display, EventBus eventBus) {
        this.view.setDelegate(this);
        super.start(display, eventBus);
    }

    @Override
    protected ThreatProxy createProxy() {
        return request.create(ThreatProxy.class);
    }

    @Override
    protected RequestContext createSaveRequest(ThreatProxy proxy) {
        request.persist().using(proxy);
        return request;
    }
}
