package eu.musesproject.server.rt2ae.client.managed.ui.renderer;
import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;
import eu.musesproject.server.rt2ae.client.managed.ui.editor.AccessrequestSetEditor;
import eu.musesproject.server.rt2ae.client.managed.ui.editor.DeviceSecurityStateSetEditor;
import eu.musesproject.server.rt2ae.client.managed.ui.editor.SecurityIncidentSetEditor;
import eu.musesproject.server.rt2ae.client.proxy.AccessrequestProxy;
import eu.musesproject.server.rt2ae.client.proxy.DeviceProxy;
import eu.musesproject.server.rt2ae.client.proxy.DeviceSecurityStateProxy;
import eu.musesproject.server.rt2ae.client.proxy.SecurityIncidentProxy;
import eu.musesproject.server.rt2ae.client.proxy.UserProxy;
import java.util.Set;

public class DeviceProxyRenderer extends ProxyRenderer<DeviceProxy> {

    private static DeviceProxyRenderer INSTANCE;

    protected DeviceProxyRenderer() {
        super(new String[] { "name" });
    }

    public static DeviceProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new DeviceProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(DeviceProxy object) {
        if (object == null) {
            return "";
        }
        return object.getName() + " (" + object.getName() + ")";
    }
}
