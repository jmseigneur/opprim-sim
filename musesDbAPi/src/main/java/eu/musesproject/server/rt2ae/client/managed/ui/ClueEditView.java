package eu.musesproject.server.rt2ae.client.managed.ui;
import eu.musesproject.server.rt2ae.client.proxy.ClueProxy;
import eu.musesproject.server.rt2ae.client.proxy.ThreatProxy;
import eu.musesproject.server.rt2ae.client.scaffold.place.ProxyEditView;
import java.util.Collection;
import java.util.List;

public interface ClueEditView<V extends ProxyEditView<ClueProxy, V>> extends ProxyEditView<ClueProxy, V> {

    void setDelegate(Delegate delegate);

    interface Delegate extends eu.musesproject.server.rt2ae.client.scaffold.place.ProxyEditView.Delegate {
    }
}
