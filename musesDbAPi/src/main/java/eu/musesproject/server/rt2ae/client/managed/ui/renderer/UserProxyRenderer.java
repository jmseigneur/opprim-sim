package eu.musesproject.server.rt2ae.client.managed.ui.renderer;
import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;
import eu.musesproject.server.rt2ae.client.managed.ui.editor.AccessrequestSetEditor;
import eu.musesproject.server.rt2ae.client.managed.ui.editor.DeviceSetEditor;
import eu.musesproject.server.rt2ae.client.managed.ui.editor.SecurityIncidentSetEditor;
import eu.musesproject.server.rt2ae.client.proxy.AccessrequestProxy;
import eu.musesproject.server.rt2ae.client.proxy.DeviceProxy;
import eu.musesproject.server.rt2ae.client.proxy.SecurityIncidentProxy;
import eu.musesproject.server.rt2ae.client.proxy.UserProxy;
import java.util.Set;

public class UserProxyRenderer extends ProxyRenderer<UserProxy> {

    private static UserProxyRenderer INSTANCE;

    protected UserProxyRenderer() {
        super(new String[] { "name" });
    }

    public static UserProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new UserProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(UserProxy object) {
        if (object == null) {
            return "";
        }
        return object.getName() + " (" + object.getName() + ")";
    }
}
