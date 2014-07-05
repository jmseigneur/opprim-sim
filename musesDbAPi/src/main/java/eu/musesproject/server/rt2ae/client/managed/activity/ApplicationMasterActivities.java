package eu.musesproject.server.rt2ae.client.managed.activity;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import eu.musesproject.server.rt2ae.client.managed.request.ApplicationEntityTypesProcessor;
import eu.musesproject.server.rt2ae.client.managed.request.ApplicationRequestFactory;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.AccessrequestDesktopListView;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.AssetDesktopListView;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.ClueDesktopListView;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.DecisionDesktopListView;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.DeviceDesktopListView;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.DeviceSecurityStateDesktopListView;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.OpportunityDesktopListView;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.OutcomeDesktopListView;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.RiskPolicyDesktopListView;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.RiskcommunicationDesktopListView;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.RiskinformationDesktopListView;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.RisktreatmentDesktopListView;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.SecurityIncidentDesktopListView;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.ThreatDesktopListView;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.UserActionDesktopListView;
import eu.musesproject.server.rt2ae.client.managed.ui.desktop.UserDesktopListView;
import eu.musesproject.server.rt2ae.client.managed.ui.mobile.AccessrequestMobileListView;
import eu.musesproject.server.rt2ae.client.managed.ui.mobile.AssetMobileListView;
import eu.musesproject.server.rt2ae.client.managed.ui.mobile.ClueMobileListView;
import eu.musesproject.server.rt2ae.client.managed.ui.mobile.DecisionMobileListView;
import eu.musesproject.server.rt2ae.client.managed.ui.mobile.DeviceMobileListView;
import eu.musesproject.server.rt2ae.client.managed.ui.mobile.DeviceSecurityStateMobileListView;
import eu.musesproject.server.rt2ae.client.managed.ui.mobile.OpportunityMobileListView;
import eu.musesproject.server.rt2ae.client.managed.ui.mobile.OutcomeMobileListView;
import eu.musesproject.server.rt2ae.client.managed.ui.mobile.RiskPolicyMobileListView;
import eu.musesproject.server.rt2ae.client.managed.ui.mobile.RiskcommunicationMobileListView;
import eu.musesproject.server.rt2ae.client.managed.ui.mobile.RiskinformationMobileListView;
import eu.musesproject.server.rt2ae.client.managed.ui.mobile.RisktreatmentMobileListView;
import eu.musesproject.server.rt2ae.client.managed.ui.mobile.SecurityIncidentMobileListView;
import eu.musesproject.server.rt2ae.client.managed.ui.mobile.ThreatMobileListView;
import eu.musesproject.server.rt2ae.client.managed.ui.mobile.UserActionMobileListView;
import eu.musesproject.server.rt2ae.client.managed.ui.mobile.UserMobileListView;
import eu.musesproject.server.rt2ae.client.proxy.AccessrequestProxy;
import eu.musesproject.server.rt2ae.client.proxy.AssetProxy;
import eu.musesproject.server.rt2ae.client.proxy.ClueProxy;
import eu.musesproject.server.rt2ae.client.proxy.DecisionProxy;
import eu.musesproject.server.rt2ae.client.proxy.DeviceProxy;
import eu.musesproject.server.rt2ae.client.proxy.DeviceSecurityStateProxy;
import eu.musesproject.server.rt2ae.client.proxy.OpportunityProxy;
import eu.musesproject.server.rt2ae.client.proxy.OutcomeProxy;
import eu.musesproject.server.rt2ae.client.proxy.RiskPolicyProxy;
import eu.musesproject.server.rt2ae.client.proxy.RiskcommunicationProxy;
import eu.musesproject.server.rt2ae.client.proxy.RiskinformationProxy;
import eu.musesproject.server.rt2ae.client.proxy.RisktreatmentProxy;
import eu.musesproject.server.rt2ae.client.proxy.SecurityIncidentProxy;
import eu.musesproject.server.rt2ae.client.proxy.ThreatProxy;
import eu.musesproject.server.rt2ae.client.proxy.UserActionProxy;
import eu.musesproject.server.rt2ae.client.proxy.UserProxy;
import eu.musesproject.server.rt2ae.client.scaffold.ScaffoldApp;
import eu.musesproject.server.rt2ae.client.scaffold.place.ProxyListPlace;

public final class ApplicationMasterActivities extends ApplicationMasterActivities_Roo_Gwt {

    @Inject
    public ApplicationMasterActivities(ApplicationRequestFactory requests, PlaceController placeController) {
        this.requests = requests;
        this.placeController = placeController;
    }
}
