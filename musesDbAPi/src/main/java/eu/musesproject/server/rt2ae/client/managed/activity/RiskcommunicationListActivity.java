package eu.musesproject.server.rt2ae.client.managed.activity;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.view.client.Range;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;
import eu.musesproject.server.rt2ae.client.managed.request.ApplicationRequestFactory;
import eu.musesproject.server.rt2ae.client.managed.ui.editor.AccessrequestSetEditor;
import eu.musesproject.server.rt2ae.client.managed.ui.editor.DecisionSetEditor;
import eu.musesproject.server.rt2ae.client.managed.ui.editor.RisktreatmentSetEditor;
import eu.musesproject.server.rt2ae.client.proxy.AccessrequestProxy;
import eu.musesproject.server.rt2ae.client.proxy.DecisionProxy;
import eu.musesproject.server.rt2ae.client.proxy.RiskcommunicationProxy;
import eu.musesproject.server.rt2ae.client.proxy.RisktreatmentProxy;
import eu.musesproject.server.rt2ae.client.scaffold.ScaffoldMobileApp;
import eu.musesproject.server.rt2ae.client.scaffold.activity.IsScaffoldMobileActivity;
import eu.musesproject.server.rt2ae.client.scaffold.place.AbstractProxyListActivity;
import eu.musesproject.server.rt2ae.client.scaffold.place.ProxyListView;
import java.util.List;
import java.util.Set;

public class RiskcommunicationListActivity extends RiskcommunicationListActivity_Roo_Gwt {

    public RiskcommunicationListActivity(ApplicationRequestFactory requests, ProxyListView<RiskcommunicationProxy> view, PlaceController placeController) {
        super(placeController, view, RiskcommunicationProxy.class);
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
        return "Riskcommunications";
    }

    public boolean hasEditButton() {
        return false;
    }

    protected Request<List<RiskcommunicationProxy>> createRangeRequest(Range range) {
        return requests.riskcommunicationRequest().findRiskcommunicationEntries(range.getStart(), range.getLength());
    }
}
