package eu.musesproject.server.rt2ae.client.managed.ui.renderer;
import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;
import eu.musesproject.server.rt2ae.client.proxy.RiskcommunicationProxy;
import eu.musesproject.server.rt2ae.client.proxy.RisktreatmentProxy;

public class RisktreatmentProxyRenderer extends ProxyRenderer<RisktreatmentProxy> {

    private static RisktreatmentProxyRenderer INSTANCE;

    protected RisktreatmentProxyRenderer() {
        super(new String[] { "textualdescription" });
    }

    public static RisktreatmentProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new RisktreatmentProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(RisktreatmentProxy object) {
        if (object == null) {
            return "";
        }
        return object.getTextualdescription() + " (" + object.getTextualdescription() + ")";
    }
}
