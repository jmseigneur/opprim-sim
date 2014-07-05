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
import eu.musesproject.server.rt2ae.client.managed.ui.OutcomeEditView;
import eu.musesproject.server.rt2ae.client.managed.ui.OutcomeEditView.Delegate;
import eu.musesproject.server.rt2ae.client.proxy.OpportunityProxy;
import eu.musesproject.server.rt2ae.client.proxy.OutcomeProxy;
import eu.musesproject.server.rt2ae.client.proxy.ThreatProxy;
import eu.musesproject.server.rt2ae.client.request.OutcomeRequest;
import eu.musesproject.server.rt2ae.client.scaffold.place.AbstractProxyEditActivity;
import eu.musesproject.server.rt2ae.client.scaffold.place.ProxyListPlace;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class OutcomeEditActivity extends AbstractProxyEditActivity<OutcomeProxy> implements Delegate {

    private final OutcomeEditView<?> view;

    private final OutcomeRequest request;

    public OutcomeEditActivity(EntityProxyId<OutcomeProxy> proxyId, ApplicationRequestFactory factory, OutcomeEditView<?> view, PlaceController placeController) {
        super(proxyId, factory, placeController);
        this.view = view;
        this.request = factory.outcomeRequest();
    }

    @Override
    protected OutcomeEditView<?> getView() {
        return view;
    }

    @Override
    public void start(AcceptsOneWidget display, EventBus eventBus) {
        this.view.setDelegate(this);
        super.start(display, eventBus);
    }

    @Override
    protected OutcomeProxy createProxy() {
        return request.create(OutcomeProxy.class);
    }

    @Override
    protected RequestContext createSaveRequest(OutcomeProxy proxy) {
        request.persist().using(proxy);
        return request;
    }
}
