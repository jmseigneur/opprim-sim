// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package eu.musesproject.server.rt2ae.client.proxy;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "eu.musesproject.server.rt2ae.SecurityIncident", locator = "eu.musesproject.server.rt2ae.server.locator.SecurityIncidentLocator")
@RooGwtProxy(value = "eu.musesproject.server.rt2ae.SecurityIncident", readOnly = { "securityIncidentId" }, scaffold = true)
public interface SecurityIncidentProxy extends EntityProxy {

    abstract Integer getSecurityIncidentId();

    abstract AssetProxy getAssetsId();

    abstract void setAssetsId(AssetProxy assetsId);

    abstract DeviceProxy getDevicesId();

    abstract void setDevicesId(DeviceProxy devicesId);

    abstract UserProxy getUsersId();

    abstract void setUsersId(UserProxy usersId);

    abstract String getDescription();

    abstract void setDescription(String description);

    abstract Double getCostbenefit();

    abstract void setCostbenefit(Double costbenefit);

    abstract Integer getDecisionId();

    abstract void setDecisionId(Integer decisionId);

    abstract Double getProbability();

    abstract void setProbability(Double probability);
}
