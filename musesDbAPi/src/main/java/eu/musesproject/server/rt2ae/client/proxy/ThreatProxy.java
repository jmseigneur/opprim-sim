// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package eu.musesproject.server.rt2ae.client.proxy;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import java.util.Set;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "eu.musesproject.server.rt2ae.Threat", locator = "eu.musesproject.server.rt2ae.server.locator.ThreatLocator")
@RooGwtProxy(value = "eu.musesproject.server.rt2ae.Threat", readOnly = { "threatId" }, scaffold = true)
public interface ThreatProxy extends EntityProxy {

    abstract Integer getThreatId();

    abstract Set<AccessrequestProxy> getAccessrequests();

    abstract void setAccessrequests(Set<AccessrequestProxy> accessrequests);

    abstract Set<ClueProxy> getClues();

    abstract void setClues(Set<ClueProxy> clues);

    abstract Set<OutcomeProxy> getOutcomes();

    abstract void setOutcomes(Set<OutcomeProxy> outcomes);

    abstract String getDescription();

    abstract void setDescription(String description);

    abstract Double getProbability();

    abstract void setProbability(Double probability);

    abstract Double getOccurences();

    abstract void setOccurences(Double occurences);

    abstract Double getBadOutcomeCount();

    abstract void setBadOutcomeCount(Double badOutcomeCount);
}
