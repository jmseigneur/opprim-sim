package eu.musesproject.server.rt2ae.client.managed.ui.renderer;
import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;
import eu.musesproject.server.rt2ae.client.proxy.DeviceProxy;
import eu.musesproject.server.rt2ae.client.proxy.DeviceSecurityStateProxy;

public class DeviceSecurityStateProxyRenderer extends ProxyRenderer<DeviceSecurityStateProxy> {

    private static DeviceSecurityStateProxyRenderer INSTANCE;

    protected DeviceSecurityStateProxyRenderer() {
        super(new String[] { "devicestate" });
    }

    public static DeviceSecurityStateProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new DeviceSecurityStateProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(DeviceSecurityStateProxy object) {
        if (object == null) {
            return "";
        }
        return object.getDevicestate() + " (" + object.getDevicestate() + ")";
    }
}
