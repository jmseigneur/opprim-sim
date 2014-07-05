// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package eu.musesproject.server.rt2ae.client.proxy;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import java.util.Set;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "eu.musesproject.server.rt2ae.Opportunity", locator = "eu.musesproject.server.rt2ae.server.locator.OpportunityLocator")
@RooGwtProxy(value = "eu.musesproject.server.rt2ae.Opportunity", readOnly = { "opportunityId" }, scaffold = true)
public interface OpportunityProxy extends EntityProxy {

    abstract Integer getOpportunityId();

    abstract Set<AccessrequestProxy> getAccessrequests();

    abstract void setAccessrequests(Set<AccessrequestProxy> accessrequests);

    abstract Set<AssetProxy> getAssets();

    abstract void setAssets(Set<AssetProxy> assets);

    abstract Set<OutcomeProxy> getOutcomes();

    abstract void setOutcomes(Set<OutcomeProxy> outcomes);

    abstract String getDescription();

    abstract void setDescription(String description);

    abstract Double getCostbenefit();

    abstract void setCostbenefit(Double costbenefit);
}
