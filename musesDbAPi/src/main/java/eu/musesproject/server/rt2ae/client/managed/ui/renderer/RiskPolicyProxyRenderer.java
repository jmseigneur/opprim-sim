package eu.musesproject.server.rt2ae.client.managed.ui.renderer;
import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;
import eu.musesproject.server.rt2ae.client.proxy.RiskPolicyProxy;

public class RiskPolicyProxyRenderer extends ProxyRenderer<RiskPolicyProxy> {

    private static RiskPolicyProxyRenderer INSTANCE;

    protected RiskPolicyProxyRenderer() {
        super(new String[] { "description" });
    }

    public static RiskPolicyProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new RiskPolicyProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(RiskPolicyProxy object) {
        if (object == null) {
            return "";
        }
        return object.getDescription() + " (" + object.getDescription() + ")";
    }
}
