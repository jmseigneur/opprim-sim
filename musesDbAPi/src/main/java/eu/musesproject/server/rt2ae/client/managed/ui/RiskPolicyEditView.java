package eu.musesproject.server.rt2ae.client.managed.ui;
import eu.musesproject.server.rt2ae.client.proxy.RiskPolicyProxy;
import eu.musesproject.server.rt2ae.client.scaffold.place.ProxyEditView;
import java.util.Collection;
import java.util.List;

public interface RiskPolicyEditView<V extends ProxyEditView<RiskPolicyProxy, V>> extends ProxyEditView<RiskPolicyProxy, V> {

    void setDelegate(Delegate delegate);

    interface Delegate extends eu.musesproject.server.rt2ae.client.scaffold.place.ProxyEditView.Delegate {
    }
}
