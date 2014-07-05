package eu.musesproject.server.rt2ae.client.managed.ui.renderer;
import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;
import eu.musesproject.server.rt2ae.client.proxy.AccessrequestProxy;
import eu.musesproject.server.rt2ae.client.proxy.AssetProxy;
import eu.musesproject.server.rt2ae.client.proxy.RiskinformationProxy;

public class RiskinformationProxyRenderer extends ProxyRenderer<RiskinformationProxy> {

    private static RiskinformationProxyRenderer INSTANCE;

    protected RiskinformationProxyRenderer() {
        super(new String[] { "type" });
    }

    public static RiskinformationProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new RiskinformationProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(RiskinformationProxy object) {
        if (object == null) {
            return "";
        }
        return object.getType() + " (" + object.getType() + ")";
    }
}
