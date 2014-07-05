package eu.musesproject.server.rt2ae.client.managed.ui.renderer;
import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;
import eu.musesproject.server.rt2ae.client.managed.ui.editor.AccessrequestSetEditor;
import eu.musesproject.server.rt2ae.client.proxy.AccessrequestProxy;
import eu.musesproject.server.rt2ae.client.proxy.UserActionProxy;
import java.util.Set;

public class UserActionProxyRenderer extends ProxyRenderer<UserActionProxy> {

    private static UserActionProxyRenderer INSTANCE;

    protected UserActionProxyRenderer() {
        super(new String[] { "useractionId" });
    }

    public static UserActionProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new UserActionProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(UserActionProxy object) {
        if (object == null) {
            return "";
        }
        return object.getUseractionId() + " (" + object.getUseractionId() + ")";
    }
}
