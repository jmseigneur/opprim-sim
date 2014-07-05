// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package eu.musesproject.server.rt2ae.client.proxy;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import java.util.Set;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "eu.musesproject.server.rt2ae.Riskcommunication", locator = "eu.musesproject.server.rt2ae.server.locator.RiskcommunicationLocator")
@RooGwtProxy(value = "eu.musesproject.server.rt2ae.Riskcommunication", readOnly = { "riskcommunicationId" }, scaffold = true)
public interface RiskcommunicationProxy extends EntityProxy {

    abstract Integer getRiskcommunicationId();

    abstract Set<AccessrequestProxy> getAccessrequests();

    abstract void setAccessrequests(Set<AccessrequestProxy> accessrequests);

    abstract Set<DecisionProxy> getDecisions();

    abstract void setDecisions(Set<DecisionProxy> decisions);

    abstract Set<RisktreatmentProxy> getRisktreatments();

    abstract void setRisktreatments(Set<RisktreatmentProxy> risktreatments);

    abstract String getTextualDescription();

    abstract void setTextualDescription(String textualDescription);
}
