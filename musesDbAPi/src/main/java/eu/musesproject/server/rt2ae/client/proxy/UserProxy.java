// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package eu.musesproject.server.rt2ae.client.proxy;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import java.util.Set;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "eu.musesproject.server.rt2ae.User", locator = "eu.musesproject.server.rt2ae.server.locator.UserLocator")
@RooGwtProxy(value = "eu.musesproject.server.rt2ae.User", readOnly = { "userId" }, scaffold = true)
public interface UserProxy extends EntityProxy {

    abstract Integer getUserId();

    abstract Set<AccessrequestProxy> getAccessrequests();

    abstract void setAccessrequests(Set<AccessrequestProxy> accessrequests);

    abstract Set<DeviceProxy> getDevices();

    abstract void setDevices(Set<DeviceProxy> devices);

    abstract Set<SecurityIncidentProxy> getSecurityIncidents();

    abstract void setSecurityIncidents(Set<SecurityIncidentProxy> securityIncidents);

    abstract String getName();

    abstract void setName(String name);

    abstract String getSurname();

    abstract void setSurname(String surname);

    abstract String getEmail();

    abstract void setEmail(String email);

    abstract Double getTrustvalue();

    abstract void setTrustvalue(Double trustvalue);

    abstract Double getHourlyCost();

    abstract void setHourlyCost(Double hourlyCost);
}
