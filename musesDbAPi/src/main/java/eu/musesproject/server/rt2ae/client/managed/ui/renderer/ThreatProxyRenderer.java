package eu.musesproject.server.rt2ae.client.managed.ui.renderer;
import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;
import eu.musesproject.server.rt2ae.client.managed.ui.editor.AccessrequestSetEditor;
import eu.musesproject.server.rt2ae.client.managed.ui.editor.ClueSetEditor;
import eu.musesproject.server.rt2ae.client.managed.ui.editor.OutcomeSetEditor;
import eu.musesproject.server.rt2ae.client.proxy.AccessrequestProxy;
import eu.musesproject.server.rt2ae.client.proxy.ClueProxy;
import eu.musesproject.server.rt2ae.client.proxy.OutcomeProxy;
import eu.musesproject.server.rt2ae.client.proxy.ThreatProxy;
import java.util.Set;

public class ThreatProxyRenderer extends ProxyRenderer<ThreatProxy> {

    private static ThreatProxyRenderer INSTANCE;

    protected ThreatProxyRenderer() {
        super(new String[] { "description" });
    }

    public static ThreatProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new ThreatProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(ThreatProxy object) {
        if (object == null) {
            return "";
        }
        return object.getDescription() + " (" + object.getDescription() + ")";
    }
}
