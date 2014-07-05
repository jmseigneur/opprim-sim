// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package eu.musesproject.server.rt2ae.client.proxy;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "eu.musesproject.server.rt2ae.Outcome", locator = "eu.musesproject.server.rt2ae.server.locator.OutcomeLocator")
@RooGwtProxy(value = "eu.musesproject.server.rt2ae.Outcome", readOnly = { "outcomeId" }, scaffold = true)
public interface OutcomeProxy extends EntityProxy {

    abstract Integer getOutcomeId();

    abstract OpportunityProxy getOpportunityId();

    abstract void setOpportunityId(OpportunityProxy opportunityId);

    abstract ThreatProxy getThreatId();

    abstract void setThreatId(ThreatProxy threatId);

    abstract String getDescription();

    abstract void setDescription(String description);

    abstract Double getCostbenefit();

    abstract void setCostbenefit(Double costbenefit);
}
