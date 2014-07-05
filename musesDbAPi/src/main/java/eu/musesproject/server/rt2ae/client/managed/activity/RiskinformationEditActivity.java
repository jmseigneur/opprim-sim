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
import eu.musesproject.server.rt2ae.client.managed.ui.RiskinformationEditView;
import eu.musesproject.server.rt2ae.client.managed.ui.RiskinformationEditView.Delegate;
import eu.musesproject.server.rt2ae.client.proxy.AccessrequestProxy;
import eu.musesproject.server.rt2ae.client.proxy.AssetProxy;
import eu.musesproject.server.rt2ae.client.proxy.RiskinformationProxy;
import eu.musesproject.server.rt2ae.client.request.RiskinformationRequest;
import eu.musesproject.server.rt2ae.client.scaffold.place.AbstractProxyEditActivity;
import eu.musesproject.server.rt2ae.client.scaffold.place.ProxyListPlace;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RiskinformationEditActivity extends AbstractProxyEditActivity<RiskinformationProxy> implements Delegate {

    private final RiskinformationEditView<?> view;

    private final RiskinformationRequest request;

    public RiskinformationEditActivity(EntityProxyId<RiskinformationProxy> proxyId, ApplicationRequestFactory factory, RiskinformationEditView<?> view, PlaceController placeController) {
        super(proxyId, factory, placeController);
        this.view = view;
        this.request = factory.riskinformationRequest();
    }

    @Override
    protected RiskinformationEditView<?> getView() {
        return view;
    }

    @Override
    public void start(AcceptsOneWidget display, EventBus eventBus) {
        this.view.setDelegate(this);
        super.start(display, eventBus);
    }

    @Override
    protected RiskinformationProxy createProxy() {
        return request.create(RiskinformationProxy.class);
    }

    @Override
    protected RequestContext createSaveRequest(RiskinformationProxy proxy) {
        request.persist().using(proxy);
        return request;
    }
}
