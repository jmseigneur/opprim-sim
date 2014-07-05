package eu.musesproject.server.rt2ae.client.managed.ui.renderer;
import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;
import eu.musesproject.server.rt2ae.client.proxy.AssetProxy;
import eu.musesproject.server.rt2ae.client.proxy.DeviceProxy;
import eu.musesproject.server.rt2ae.client.proxy.SecurityIncidentProxy;
import eu.musesproject.server.rt2ae.client.proxy.UserProxy;

public class SecurityIncidentProxyRenderer extends ProxyRenderer<SecurityIncidentProxy> {

    private static SecurityIncidentProxyRenderer INSTANCE;

    protected SecurityIncidentProxyRenderer() {
        super(new String[] { "description" });
    }

    public static SecurityIncidentProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new SecurityIncidentProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(SecurityIncidentProxy object) {
        if (object == null) {
            return "";
        }
        return object.getDescription() + " (" + object.getDescription() + ")";
    }
}
