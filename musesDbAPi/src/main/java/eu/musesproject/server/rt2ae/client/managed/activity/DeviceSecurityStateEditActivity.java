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
import eu.musesproject.server.rt2ae.client.managed.ui.DeviceSecurityStateEditView;
import eu.musesproject.server.rt2ae.client.managed.ui.DeviceSecurityStateEditView.Delegate;
import eu.musesproject.server.rt2ae.client.proxy.DeviceProxy;
import eu.musesproject.server.rt2ae.client.proxy.DeviceSecurityStateProxy;
import eu.musesproject.server.rt2ae.client.request.DeviceSecurityStateRequest;
import eu.musesproject.server.rt2ae.client.scaffold.place.AbstractProxyEditActivity;
import eu.musesproject.server.rt2ae.client.scaffold.place.ProxyListPlace;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DeviceSecurityStateEditActivity extends AbstractProxyEditActivity<DeviceSecurityStateProxy> implements Delegate {

    private final DeviceSecurityStateEditView<?> view;

    private final DeviceSecurityStateRequest request;

    public DeviceSecurityStateEditActivity(EntityProxyId<DeviceSecurityStateProxy> proxyId, ApplicationRequestFactory factory, DeviceSecurityStateEditView<?> view, PlaceController placeController) {
        super(proxyId, factory, placeController);
        this.view = view;
        this.request = factory.deviceSecurityStateRequest();
    }

    @Override
    protected DeviceSecurityStateEditView<?> getView() {
        return view;
    }

    @Override
    public void start(AcceptsOneWidget display, EventBus eventBus) {
        this.view.setDelegate(this);
        super.start(display, eventBus);
    }

    @Override
    protected DeviceSecurityStateProxy createProxy() {
        return request.create(DeviceSecurityStateProxy.class);
    }

    @Override
    protected RequestContext createSaveRequest(DeviceSecurityStateProxy proxy) {
        request.persist().using(proxy);
        return request;
    }
}
