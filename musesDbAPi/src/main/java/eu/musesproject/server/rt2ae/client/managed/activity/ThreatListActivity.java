package eu.musesproject.server.rt2ae.client.managed.activity;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.view.client.Range;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;
import eu.musesproject.server.rt2ae.client.managed.request.ApplicationRequestFactory;
import eu.musesproject.server.rt2ae.client.managed.ui.editor.AccessrequestSetEditor;
import eu.musesproject.server.rt2ae.client.managed.ui.editor.ClueSetEditor;
import eu.musesproject.server.rt2ae.client.managed.ui.editor.OutcomeSetEditor;
import eu.musesproject.server.rt2ae.client.proxy.AccessrequestProxy;
import eu.musesproject.server.rt2ae.client.proxy.ClueProxy;
import eu.musesproject.server.rt2ae.client.proxy.OutcomeProxy;
import eu.musesproject.server.rt2ae.client.proxy.ThreatProxy;
import eu.musesproject.server.rt2ae.client.scaffold.ScaffoldMobileApp;
import eu.musesproject.server.rt2ae.client.scaffold.activity.IsScaffoldMobileActivity;
import eu.musesproject.server.rt2ae.client.scaffold.place.AbstractProxyListActivity;
import eu.musesproject.server.rt2ae.client.scaffold.place.ProxyListView;
import java.util.List;
import java.util.Set;

public class ThreatListActivity extends ThreatListActivity_Roo_Gwt {

    public ThreatListActivity(ApplicationRequestFactory requests, ProxyListView<ThreatProxy> view, PlaceController placeController) {
        super(placeController, view, ThreatProxy.class);
        this.requests = requests;
    }

    public Place getBackButtonPlace() {
        return ScaffoldMobileApp.ROOT_PLACE;
    }

    public String getBackButtonText() {
        return "Entities";
    }

    public Place getEditButtonPlace() {
        return null;
    }

    public String getTitleText() {
        return "Threats";
    }

    public boolean hasEditButton() {
        return false;
    }

    protected Request<List<ThreatProxy>> createRangeRequest(Range range) {
        return requests.threatRequest().findThreatEntries(range.getStart(), range.getLength());
    }
}
