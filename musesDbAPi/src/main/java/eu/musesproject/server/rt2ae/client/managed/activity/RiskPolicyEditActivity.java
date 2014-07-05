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
import eu.musesproject.server.rt2ae.client.managed.ui.RiskPolicyEditView;
import eu.musesproject.server.rt2ae.client.managed.ui.RiskPolicyEditView.Delegate;
import eu.musesproject.server.rt2ae.client.proxy.RiskPolicyProxy;
import eu.musesproject.server.rt2ae.client.request.RiskPolicyRequest;
import eu.musesproject.server.rt2ae.client.scaffold.place.AbstractProxyEditActivity;
import eu.musesproject.server.rt2ae.client.scaffold.place.ProxyListPlace;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RiskPolicyEditActivity extends AbstractProxyEditActivity<RiskPolicyProxy> implements Delegate {

    private final RiskPolicyEditView<?> view;

    private final RiskPolicyRequest request;

    public RiskPolicyEditActivity(EntityProxyId<RiskPolicyProxy> proxyId, ApplicationRequestFactory factory, RiskPolicyEditView<?> view, PlaceController placeController) {
        super(proxyId, factory, placeController);
        this.view = view;
        this.request = factory.riskPolicyRequest();
    }

    @Override
    protected RiskPolicyEditView<?> getView() {
        return view;
    }

    @Override
    public void start(AcceptsOneWidget display, EventBus eventBus) {
        this.view.setDelegate(this);
        super.start(display, eventBus);
    }

    @Override
    protected RiskPolicyProxy createProxy() {
        return request.create(RiskPolicyProxy.class);
    }

    @Override
    protected RequestContext createSaveRequest(RiskPolicyProxy proxy) {
        request.persist().using(proxy);
        return request;
    }
}
