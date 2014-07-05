package eu.musesproject.server.rt2ae.client.managed.ui.renderer;
import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;
import eu.musesproject.server.rt2ae.client.managed.ui.editor.AccessrequestSetEditor;
import eu.musesproject.server.rt2ae.client.managed.ui.editor.AssetSetEditor;
import eu.musesproject.server.rt2ae.client.managed.ui.editor.OutcomeSetEditor;
import eu.musesproject.server.rt2ae.client.proxy.AccessrequestProxy;
import eu.musesproject.server.rt2ae.client.proxy.AssetProxy;
import eu.musesproject.server.rt2ae.client.proxy.OpportunityProxy;
import eu.musesproject.server.rt2ae.client.proxy.OutcomeProxy;
import java.util.Set;

public class OpportunityProxyRenderer extends ProxyRenderer<OpportunityProxy> {

    private static OpportunityProxyRenderer INSTANCE;

    protected OpportunityProxyRenderer() {
        super(new String[] { "description" });
    }

    public static OpportunityProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new OpportunityProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(OpportunityProxy object) {
        if (object == null) {
            return "";
        }
        return object.getDescription() + " (" + object.getDescription() + ")";
    }
}
