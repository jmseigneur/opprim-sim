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
import eu.musesproject.server.rt2ae.client.managed.ui.editor.AccessrequestSetEditor;
import eu.musesproject.server.rt2ae.client.managed.ui.editor.ClueSetEditor;
import eu.musesproject.server.rt2ae.client.managed.ui.editor.OutcomeSetEditor;
import eu.musesproject.server.rt2ae.client.proxy.AccessrequestProxy;
import eu.musesproject.server.rt2ae.client.proxy.ClueProxy;
import eu.musesproject.server.rt2ae.client.proxy.OutcomeProxy;
import eu.musesproject.server.rt2ae.client.proxy.ThreatProxy;
import eu.musesproject.server.rt2ae.client.scaffold.ScaffoldMobileApp;
import eu.musesproject.server.rt2ae.client.scaffold.ui.MobileProxyListView;
import java.util.HashSet;
import java.util.Set;

public class ThreatMobileListView extends ThreatMobileListView_Roo_Gwt {

    private static ThreatMobileListView instance;

    public ThreatMobileListView() {
        super("New Threat", new CellRenderer());
        init();
    }

    public static ThreatMobileListView instance() {
        if (instance == null) {
            instance = new ThreatMobileListView();
        }
        return instance;
    }

    public String[] getPaths() {
        return paths.toArray(new String[paths.size()]);
    }

    private static class CellRenderer extends AbstractSafeHtmlRenderer<ThreatProxy> {

        private final String dateStyle = ScaffoldMobileApp.getMobileListResources().cellListStyle().dateProp();

        private final String secondaryStyle = ScaffoldMobileApp.getMobileListResources().cellListStyle().secondaryProp();

        private final Renderer<ThreatProxy> primaryRenderer = eu.musesproject.server.rt2ae.client.managed.ui.renderer.ThreatProxyRenderer.instance();

        private final Renderer<Integer> secondaryRenderer = new AbstractRenderer<Integer>() {

            public String render(java.lang.Integer obj) {
                return obj == null ? "" : String.valueOf(obj);
            }
        };

        @Override
        public SafeHtml render(ThreatProxy value) {
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
            if (value.getThreatId() != null) {
                sb.appendEscaped(secondaryRenderer.render(value.getThreatId()));
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
