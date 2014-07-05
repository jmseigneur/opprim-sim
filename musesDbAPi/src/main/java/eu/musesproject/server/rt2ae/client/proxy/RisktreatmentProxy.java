// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package eu.musesproject.server.rt2ae.client.proxy;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "eu.musesproject.server.rt2ae.Risktreatment", locator = "eu.musesproject.server.rt2ae.server.locator.RisktreatmentLocator")
@RooGwtProxy(value = "eu.musesproject.server.rt2ae.Risktreatment", readOnly = { "risktreatmentId" }, scaffold = true)
public interface RisktreatmentProxy extends EntityProxy {

    abstract Integer getRisktreatmentId();

    abstract RiskcommunicationProxy getRiskcommunicationId();

    abstract void setRiskcommunicationId(RiskcommunicationProxy riskcommunicationId);

    abstract String getTextualdescription();

    abstract void setTextualdescription(String textualdescription);
}
