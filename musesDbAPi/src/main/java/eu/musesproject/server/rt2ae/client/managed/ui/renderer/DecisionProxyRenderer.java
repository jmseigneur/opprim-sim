package eu.musesproject.server.rt2ae.client.managed.ui.renderer;
import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;
import eu.musesproject.server.rt2ae.client.proxy.DecisionProxy;
import eu.musesproject.server.rt2ae.client.proxy.RiskcommunicationProxy;

public class DecisionProxyRenderer extends ProxyRenderer<DecisionProxy> {

    private static DecisionProxyRenderer INSTANCE;

    protected DecisionProxyRenderer() {
        super(new String[] { "value" });
    }

    public static DecisionProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new DecisionProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(DecisionProxy object) {
        if (object == null) {
            return "";
        }
        return object.getValue() + " (" + object.getValue() + ")";
    }
}
