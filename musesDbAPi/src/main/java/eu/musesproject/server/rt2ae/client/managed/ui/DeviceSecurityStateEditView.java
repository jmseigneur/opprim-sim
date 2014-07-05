package eu.musesproject.server.rt2ae.client.managed.ui;
import eu.musesproject.server.rt2ae.client.proxy.DeviceProxy;
import eu.musesproject.server.rt2ae.client.proxy.DeviceSecurityStateProxy;
import eu.musesproject.server.rt2ae.client.scaffold.place.ProxyEditView;
import java.util.Collection;
import java.util.List;

public interface DeviceSecurityStateEditView<V extends ProxyEditView<DeviceSecurityStateProxy, V>> extends ProxyEditView<DeviceSecurityStateProxy, V> {

    void setDelegate(Delegate delegate);

    interface Delegate extends eu.musesproject.server.rt2ae.client.scaffold.place.ProxyEditView.Delegate {
    }
}
