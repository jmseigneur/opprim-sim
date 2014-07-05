package eu.musesproject.server.rt2ae.client.managed.ui;
import eu.musesproject.server.rt2ae.client.proxy.DecisionProxy;
import eu.musesproject.server.rt2ae.client.proxy.RiskcommunicationProxy;
import eu.musesproject.server.rt2ae.client.scaffold.place.ProxyEditView;
import java.util.Collection;
import java.util.List;

public interface DecisionEditView<V extends ProxyEditView<DecisionProxy, V>> extends ProxyEditView<DecisionProxy, V> {

    void setDelegate(Delegate delegate);

    interface Delegate extends eu.musesproject.server.rt2ae.client.scaffold.place.ProxyEditView.Delegate {
    }
}
