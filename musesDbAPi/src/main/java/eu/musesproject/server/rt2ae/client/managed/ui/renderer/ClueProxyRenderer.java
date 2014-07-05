package eu.musesproject.server.rt2ae.client.managed.ui.renderer;
import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;
import eu.musesproject.server.rt2ae.client.proxy.ClueProxy;
import eu.musesproject.server.rt2ae.client.proxy.ThreatProxy;

public class ClueProxyRenderer extends ProxyRenderer<ClueProxy> {

    private static ClueProxyRenderer INSTANCE;

    protected ClueProxyRenderer() {
        super(new String[] { "value" });
    }

    public static ClueProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new ClueProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(ClueProxy object) {
        if (object == null) {
            return "";
        }
        return object.getValue() + " (" + object.getValue() + ")";
    }
}
