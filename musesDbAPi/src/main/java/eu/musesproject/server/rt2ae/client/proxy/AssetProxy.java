// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package eu.musesproject.server.rt2ae.client.proxy;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import java.util.Set;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "eu.musesproject.server.rt2ae.Asset", locator = "eu.musesproject.server.rt2ae.server.locator.AssetLocator")
@RooGwtProxy(value = "eu.musesproject.server.rt2ae.Asset", readOnly = { "assetId" }, scaffold = true)
public interface AssetProxy extends EntityProxy {

    abstract Integer getAssetId();

    abstract Set<AccessrequestProxy> getAccessrequests();

    abstract void setAccessrequests(Set<AccessrequestProxy> accessrequests);

    abstract Set<RiskinformationProxy> getRiskinformations();

    abstract void setRiskinformations(Set<RiskinformationProxy> riskinformations);

    abstract Set<SecurityIncidentProxy> getSecurityIncidents();

    abstract void setSecurityIncidents(Set<SecurityIncidentProxy> securityIncidents);

    abstract OpportunityProxy getOpportunityid();

    abstract void setOpportunityid(OpportunityProxy opportunityid);

    abstract String getAssetName();

    abstract void setAssetName(String assetName);

    abstract String getDescription();

    abstract void setDescription(String description);

    abstract Double getValue();

    abstract void setValue(Double value);

    abstract String getConfidentialLevel();

    abstract void setConfidentialLevel(String confidentialLevel);

    abstract String getLocation();

    abstract void setLocation(String location);
}
