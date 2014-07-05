// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package eu.musesproject.server.rt2ae.client.proxy;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import java.util.Set;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "eu.musesproject.server.rt2ae.Device", locator = "eu.musesproject.server.rt2ae.server.locator.DeviceLocator")
@RooGwtProxy(value = "eu.musesproject.server.rt2ae.Device", readOnly = { "version", "deviceId" }, scaffold = true)
public interface DeviceProxy extends EntityProxy {

    abstract Integer getDeviceId();

    abstract Set<AccessrequestProxy> getAccessrequests();

    abstract void setAccessrequests(Set<AccessrequestProxy> accessrequests);

    abstract Set<DeviceSecurityStateProxy> getDeviceSecurityStates();

    abstract void setDeviceSecurityStates(Set<DeviceSecurityStateProxy> deviceSecurityStates);

    abstract Set<SecurityIncidentProxy> getSecurityIncidents();

    abstract void setSecurityIncidents(Set<SecurityIncidentProxy> securityIncidents);

    abstract UserProxy getOwnerId();

    abstract void setOwnerId(UserProxy ownerId);

    abstract String getName();

    abstract void setName(String name);

    abstract String getType();

    abstract void setType(String type);

    abstract String getDescription();

    abstract void setDescription(String description);

    abstract String getImei();

    abstract void setImei(String imei);

    abstract String getMacaddress();

    abstract void setMacaddress(String macaddress);

    abstract String getOs();

    abstract void setOs(String os);

    abstract String getTrustvalue();

    abstract void setTrustvalue(String trustvalue);

    abstract Integer getVersion();
}
