package eu.musesproject.server.rt2ae.client.managed.ui.renderer;
import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;
import eu.musesproject.server.rt2ae.client.managed.ui.editor.RiskinformationSetEditor;
import eu.musesproject.server.rt2ae.client.managed.ui.editor.SecurityIncidentSetEditor;
import eu.musesproject.server.rt2ae.client.proxy.AccessrequestProxy;
import eu.musesproject.server.rt2ae.client.proxy.AssetProxy;
import eu.musesproject.server.rt2ae.client.proxy.OpportunityProxy;
import eu.musesproject.server.rt2ae.client.proxy.RiskinformationProxy;
import eu.musesproject.server.rt2ae.client.proxy.SecurityIncidentProxy;
import java.util.Set;

public class AssetProxyRenderer extends ProxyRenderer<AssetProxy> {

    private static AssetProxyRenderer INSTANCE;

    protected AssetProxyRenderer() {
        super(new String[] { "assetName" });
    }

    public static AssetProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new AssetProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(AssetProxy object) {
        if (object == null) {
            return "";
        }
        return object.getAssetName() + " (" + object.getAssetName() + ")";
    }
}
