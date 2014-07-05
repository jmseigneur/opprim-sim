// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package eu.musesproject.server.rt2ae.client.proxy;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "eu.musesproject.server.rt2ae.RiskPolicy", locator = "eu.musesproject.server.rt2ae.server.locator.RiskPolicyLocator")
@RooGwtProxy(value = "eu.musesproject.server.rt2ae.RiskPolicy", readOnly = { "riskpolicyId" }, scaffold = true)
public interface RiskPolicyProxy extends EntityProxy {

    abstract Integer getRiskpolicyId();

    abstract Double getRiskvalue();

    abstract void setRiskvalue(Double riskvalue);

    abstract String getDescription();

    abstract void setDescription(String description);
}
