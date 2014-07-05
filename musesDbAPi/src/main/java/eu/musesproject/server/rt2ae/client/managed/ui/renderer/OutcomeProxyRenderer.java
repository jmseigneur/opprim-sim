package eu.musesproject.server.rt2ae.client.managed.ui.renderer;
import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;
import eu.musesproject.server.rt2ae.client.proxy.OpportunityProxy;
import eu.musesproject.server.rt2ae.client.proxy.OutcomeProxy;
import eu.musesproject.server.rt2ae.client.proxy.ThreatProxy;

public class OutcomeProxyRenderer extends ProxyRenderer<OutcomeProxy> {

    private static OutcomeProxyRenderer INSTANCE;

    protected OutcomeProxyRenderer() {
        super(new String[] { "description" });
    }

    public static OutcomeProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new OutcomeProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(OutcomeProxy object) {
        if (object == null) {
            return "";
        }
        return object.getDescription() + " (" + object.getDescription() + ")";
    }
}
