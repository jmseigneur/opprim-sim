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
import eu.musesproject.server.rt2ae.client.managed.ui.RisktreatmentEditView;
import eu.musesproject.server.rt2ae.client.managed.ui.RisktreatmentEditView.Delegate;
import eu.musesproject.server.rt2ae.client.proxy.RiskcommunicationProxy;
import eu.musesproject.server.rt2ae.client.proxy.RisktreatmentProxy;
import eu.musesproject.server.rt2ae.client.request.RisktreatmentRequest;
import eu.musesproject.server.rt2ae.client.scaffold.place.AbstractProxyEditActivity;
import eu.musesproject.server.rt2ae.client.scaffold.place.ProxyListPlace;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RisktreatmentEditActivity extends AbstractProxyEditActivity<RisktreatmentProxy> implements Delegate {

    private final RisktreatmentEditView<?> view;

    private final RisktreatmentRequest request;

    public RisktreatmentEditActivity(EntityProxyId<RisktreatmentProxy> proxyId, ApplicationRequestFactory factory, RisktreatmentEditView<?> view, PlaceController placeController) {
        super(proxyId, factory, placeController);
        this.view = view;
        this.request = factory.risktreatmentRequest();
    }

    @Override
    protected RisktreatmentEditView<?> getView() {
        return view;
    }

    @Override
    public void start(AcceptsOneWidget display, EventBus eventBus) {
        this.view.setDelegate(this);
        super.start(display, eventBus);
    }

    @Override
    protected RisktreatmentProxy createProxy() {
        return request.create(RisktreatmentProxy.class);
    }

    @Override
    protected RequestContext createSaveRequest(RisktreatmentProxy proxy) {
        request.persist().using(proxy);
        return request;
    }
}
