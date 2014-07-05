package eu.musesproject.server.rt2ae.client.managed.ui.renderer;
import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;
import eu.musesproject.server.rt2ae.client.managed.ui.editor.AssetSetEditor;
import eu.musesproject.server.rt2ae.client.managed.ui.editor.RiskinformationSetEditor;
import eu.musesproject.server.rt2ae.client.proxy.AccessrequestProxy;
import eu.musesproject.server.rt2ae.client.proxy.AssetProxy;
import eu.musesproject.server.rt2ae.client.proxy.DeviceProxy;
import eu.musesproject.server.rt2ae.client.proxy.OpportunityProxy;
import eu.musesproject.server.rt2ae.client.proxy.RiskcommunicationProxy;
import eu.musesproject.server.rt2ae.client.proxy.RiskinformationProxy;
import eu.musesproject.server.rt2ae.client.proxy.ThreatProxy;
import eu.musesproject.server.rt2ae.client.proxy.UserActionProxy;
import eu.musesproject.server.rt2ae.client.proxy.UserProxy;
import java.util.Set;

public class AccessrequestProxyRenderer extends ProxyRenderer<AccessrequestProxy> {

    private static AccessrequestProxyRenderer INSTANCE;

    protected AccessrequestProxyRenderer() {
        super(new String[] { "accessrequestId" });
    }

    public static AccessrequestProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new AccessrequestProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(AccessrequestProxy object) {
        if (object == null) {
            return "";
        }
        return object.getAccessrequestId() + " (" + object.getAccessrequestId() + ")";
    }
}
