// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package eu.musesproject.server.rt2ae.client.proxy;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import java.util.Set;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "eu.musesproject.server.rt2ae.Accessrequest", locator = "eu.musesproject.server.rt2ae.server.locator.AccessrequestLocator")
@RooGwtProxy(value = "eu.musesproject.server.rt2ae.Accessrequest", readOnly = { "accessrequestId" }, scaffold = true)
public interface AccessrequestProxy extends EntityProxy {

    abstract Integer getAccessrequestId();

    abstract Set<AssetProxy> getAssets();

    abstract void setAssets(Set<AssetProxy> assets);

    abstract Set<RiskinformationProxy> getRiskinformations();

    abstract void setRiskinformations(Set<RiskinformationProxy> riskinformations);

    abstract OpportunityProxy getOpportunityId();

    abstract void setOpportunityId(OpportunityProxy opportunityId);

    abstract DeviceProxy getDeviceId();

    abstract void setDeviceId(DeviceProxy deviceId);

    abstract UserProxy getUserId();

    abstract void setUserId(UserProxy userId);

    abstract RiskcommunicationProxy getRiskcommunicationid();

    abstract void setRiskcommunicationid(RiskcommunicationProxy riskcommunicationid);

    abstract ThreatProxy getThreatid();

    abstract void setThreatid(ThreatProxy threatid);

    abstract UserActionProxy getUseractionId();

    abstract void setUseractionId(UserActionProxy useractionId);

    abstract Short getSolved();

    abstract void setSolved(Short solved);

    abstract Integer getRiskcommunicationId();

    abstract void setRiskcommunicationId(Integer riskcommunicationId);
}
