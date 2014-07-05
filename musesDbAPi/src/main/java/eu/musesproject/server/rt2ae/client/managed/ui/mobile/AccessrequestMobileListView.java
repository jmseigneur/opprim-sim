package eu.musesproject.server.rt2ae.client.managed.ui.mobile;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.text.client.DateTimeFormatRenderer;
import com.google.gwt.text.shared.AbstractRenderer;
import com.google.gwt.text.shared.AbstractSafeHtmlRenderer;
import com.google.gwt.text.shared.Renderer;
import com.google.gwt.text.shared.SafeHtmlRenderer;
import eu.musesproject.server.rt2ae.client.managed.ui.editor.AssetSetEditor;
import eu.musesproject.server.rt2ae.client.managed.ui.editor.RiskinformationSetEditor;
import eu.musesproject.server.rt2ae.client.proxy.AccessrequestProxy;
import eu.musesproject.server.rt2ae.client.proxy.AssetProxy;
import eu.musesproject.server.rt2ae.client.proxy.DeviceProxy;
import eu.musesproject.server.rt2ae.client.proxy.OpportunityProxy;
import eu.musesproject.server.rt2ae.client.proxy.RiskcommunicationProxy;
import eu.musesproject.server.rt2ae.client.proxy.RiskinformationProxy;
import eu.musesproject.server.rt2ae.client.proxy.ThreatProxy;
import eu.musesproject.server.rt2ae.client.proxy.UserActionProxy;
import eu.musesproject.server.rt2ae.client.proxy.UserProxy;
import eu.musesproject.server.rt2ae.client.scaffold.ScaffoldMobileApp;
import eu.musesproject.server.rt2ae.client.scaffold.ui.MobileProxyListView;
import java.util.HashSet;
import java.util.Set;

public class AccessrequestMobileListView extends AccessrequestMobileListView_Roo_Gwt {

    private static AccessrequestMobileListView instance;

    public AccessrequestMobileListView() {
        super("New Accessrequest", new CellRenderer());
        init();
    }

    public static AccessrequestMobileListView instance() {
        if (instance == null) {
            instance = new AccessrequestMobileListView();
        }
        return instance;
    }

    public String[] getPaths() {
        return paths.toArray(new String[paths.size()]);
    }

    private static class CellRenderer extends AbstractSafeHtmlRenderer<AccessrequestProxy> {

        private final String dateStyle = ScaffoldMobileApp.getMobileListResources().cellListStyle().dateProp();

        private final String secondaryStyle = ScaffoldMobileApp.getMobileListResources().cellListStyle().secondaryProp();

        private final Renderer<AccessrequestProxy> primaryRenderer = eu.musesproject.server.rt2ae.client.managed.ui.renderer.AccessrequestProxyRenderer.instance();

        private final Renderer<Set> secondaryRenderer = eu.musesproject.server.rt2ae.client.scaffold.place.CollectionRenderer.of(eu.musesproject.server.rt2ae.client.managed.ui.renderer.AssetProxyRenderer.instance());

        @Override
        public SafeHtml render(AccessrequestProxy value) {
            if (value == null) {
                return SafeHtmlUtils.EMPTY_SAFE_HTML;
            }
            // Primary property.
            SafeHtmlBuilder sb = new SafeHtmlBuilder();
            if (value != null) {
                sb.appendEscaped(primaryRenderer.render(value));
            }
            // Secondary property.
            sb.appendHtmlConstant("<div style=\"position:relative;\">");
            sb.appendHtmlConstant("<div class=\"" + secondaryStyle + "\">");
            if (value.getAssets() != null) {
                sb.appendEscaped(secondaryRenderer.render(value.getAssets()));
            }
            sb.appendHtmlConstant("</div>");
            // Date property.
            sb.appendHtmlConstant("<div class=\"" + dateStyle + "\">");
            sb.appendHtmlConstant("</div>");
            sb.appendHtmlConstant("</div>");
            return sb.toSafeHtml();
        }
    }
}
