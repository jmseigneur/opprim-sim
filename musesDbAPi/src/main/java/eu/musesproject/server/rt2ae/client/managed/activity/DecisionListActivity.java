package eu.musesproject.server.rt2ae.client.managed.activity;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.view.client.Range;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;
import eu.musesproject.server.rt2ae.client.managed.request.ApplicationRequestFactory;
import eu.musesproject.server.rt2ae.client.proxy.DecisionProxy;
import eu.musesproject.server.rt2ae.client.proxy.RiskcommunicationProxy;
import eu.musesproject.server.rt2ae.client.scaffold.ScaffoldMobileApp;
import eu.musesproject.server.rt2ae.client.scaffold.activity.IsScaffoldMobileActivity;
import eu.musesproject.server.rt2ae.client.scaffold.place.AbstractProxyListActivity;
import eu.musesproject.server.rt2ae.client.scaffold.place.ProxyListView;
import java.util.List;

public class DecisionListActivity extends DecisionListActivity_Roo_Gwt {

    public DecisionListActivity(ApplicationRequestFactory requests, ProxyListView<DecisionProxy> view, PlaceController placeController) {
        super(placeController, view, DecisionProxy.class);
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
        return "Decisions";
    }

    public boolean hasEditButton() {
        return false;
    }

    protected Request<List<DecisionProxy>> createRangeRequest(Range range) {
        return requests.decisionRequest().findDecisionEntries(range.getStart(), range.getLength());
    }
}
