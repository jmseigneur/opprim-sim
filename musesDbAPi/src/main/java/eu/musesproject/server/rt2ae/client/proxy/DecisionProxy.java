// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package eu.musesproject.server.rt2ae.client.proxy;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "eu.musesproject.server.rt2ae.Decision", locator = "eu.musesproject.server.rt2ae.server.locator.DecisionLocator")
@RooGwtProxy(value = "eu.musesproject.server.rt2ae.Decision", readOnly = { "decisionId" }, scaffold = true)
public interface DecisionProxy extends EntityProxy {

    abstract Integer getDecisionId();

    abstract RiskcommunicationProxy getRiskcommunicationId();

    abstract void setRiskcommunicationId(RiskcommunicationProxy riskcommunicationId);

    abstract String getValue();

    abstract void setValue(String value);
}
