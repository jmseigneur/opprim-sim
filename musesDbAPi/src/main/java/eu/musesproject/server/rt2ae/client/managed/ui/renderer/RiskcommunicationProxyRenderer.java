package eu.musesproject.server.rt2ae.client.managed.ui.renderer;
import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;
import eu.musesproject.server.rt2ae.client.managed.ui.editor.AccessrequestSetEditor;
import eu.musesproject.server.rt2ae.client.managed.ui.editor.DecisionSetEditor;
import eu.musesproject.server.rt2ae.client.managed.ui.editor.RisktreatmentSetEditor;
import eu.musesproject.server.rt2ae.client.proxy.AccessrequestProxy;
import eu.musesproject.server.rt2ae.client.proxy.DecisionProxy;
import eu.musesproject.server.rt2ae.client.proxy.RiskcommunicationProxy;
import eu.musesproject.server.rt2ae.client.proxy.RisktreatmentProxy;
import java.util.Set;

public class RiskcommunicationProxyRenderer extends ProxyRenderer<RiskcommunicationProxy> {

    private static RiskcommunicationProxyRenderer INSTANCE;

    protected RiskcommunicationProxyRenderer() {
        super(new String[] { "textualDescription" });
    }

    public static RiskcommunicationProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new RiskcommunicationProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(RiskcommunicationProxy object) {
        if (object == null) {
            return "";
        }
        return object.getTextualDescription() + " (" + object.getTextualDescription() + ")";
    }
}
