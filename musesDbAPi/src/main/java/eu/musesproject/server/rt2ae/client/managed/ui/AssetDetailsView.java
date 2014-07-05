package eu.musesproject.server.rt2ae.client.managed.ui;
import eu.musesproject.server.rt2ae.client.managed.ui.editor.RiskinformationSetEditor;
import eu.musesproject.server.rt2ae.client.managed.ui.editor.SecurityIncidentSetEditor;
import eu.musesproject.server.rt2ae.client.proxy.AccessrequestProxy;
import eu.musesproject.server.rt2ae.client.proxy.AssetProxy;
import eu.musesproject.server.rt2ae.client.proxy.OpportunityProxy;
import eu.musesproject.server.rt2ae.client.proxy.RiskinformationProxy;
import eu.musesproject.server.rt2ae.client.proxy.SecurityIncidentProxy;
import eu.musesproject.server.rt2ae.client.scaffold.place.ProxyDetailsView;
import java.util.Set;

public interface AssetDetailsView extends ProxyDetailsView<AssetProxy> {

    void setDelegate(Delegate delegate);

    interface Delegate extends eu.musesproject.server.rt2ae.client.scaffold.place.ProxyDetailsView.Delegate {
    }
}
