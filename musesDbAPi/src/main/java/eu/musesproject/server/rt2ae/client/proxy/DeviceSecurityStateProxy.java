// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package eu.musesproject.server.rt2ae.client.proxy;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "eu.musesproject.server.rt2ae.DeviceSecurityState", locator = "eu.musesproject.server.rt2ae.server.locator.DeviceSecurityStateLocator")
@RooGwtProxy(value = "eu.musesproject.server.rt2ae.DeviceSecurityState", readOnly = { "deviceSecurityStateId" }, scaffold = true)
public interface DeviceSecurityStateProxy extends EntityProxy {

    abstract Integer getDeviceSecurityStateId();

    abstract DeviceProxy getDeviceId();

    abstract void setDeviceId(DeviceProxy deviceId);

    abstract String getDevicestate();

    abstract void setDevicestate(String devicestate);

    abstract Integer getAntivirus();

    abstract void setAntivirus(Integer antivirus);

    abstract Integer getPasswordprotection();

    abstract void setPasswordprotection(Integer passwordprotection);

    abstract Integer getAutolock();

    abstract void setAutolock(Integer autolock);

    abstract Integer getSslprotection();

    abstract void setSslprotection(Integer sslprotection);

    abstract Integer getEncryption();

    abstract void setEncryption(Integer encryption);

    abstract Integer getTrackingdevice();

    abstract void setTrackingdevice(Integer trackingdevice);

    abstract Integer getRemotewipe();

    abstract void setRemotewipe(Integer remotewipe);

    abstract Integer getVpn();

    abstract void setVpn(Integer vpn);
}
