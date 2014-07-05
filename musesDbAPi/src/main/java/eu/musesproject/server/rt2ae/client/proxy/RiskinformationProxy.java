// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package eu.musesproject.server.rt2ae.client.proxy;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "eu.musesproject.server.rt2ae.Riskinformation", locator = "eu.musesproject.server.rt2ae.server.locator.RiskinformationLocator")
@RooGwtProxy(value = "eu.musesproject.server.rt2ae.Riskinformation", readOnly = { "riskinformationId" }, scaffold = true)
public interface RiskinformationProxy extends EntityProxy {

    abstract Integer getRiskinformationId();

    abstract AccessrequestProxy getAccessrequestId();

    abstract void setAccessrequestId(AccessrequestProxy accessrequestId);

    abstract AssetProxy getAssetId();

    abstract void setAssetId(AssetProxy assetId);

    abstract String getType();

    abstract void setType(String type);

    abstract String getDescription();

    abstract void setDescription(String description);

    abstract Double getProbability();

    abstract void setProbability(Double probability);
}
