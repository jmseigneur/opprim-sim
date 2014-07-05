package eu.musesproject.server.rt2ae.client.managed.ui;
import eu.musesproject.server.rt2ae.client.proxy.RiskcommunicationProxy;
import eu.musesproject.server.rt2ae.client.proxy.RisktreatmentProxy;
import eu.musesproject.server.rt2ae.client.scaffold.place.ProxyDetailsView;

public interface RisktreatmentDetailsView extends ProxyDetailsView<RisktreatmentProxy> {

    void setDelegate(Delegate delegate);

    interface Delegate extends eu.musesproject.server.rt2ae.client.scaffold.place.ProxyDetailsView.Delegate {
    }
}
