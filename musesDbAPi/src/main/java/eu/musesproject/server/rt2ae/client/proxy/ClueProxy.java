// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package eu.musesproject.server.rt2ae.client.proxy;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "eu.musesproject.server.rt2ae.Clue", locator = "eu.musesproject.server.rt2ae.server.locator.ClueLocator")
@RooGwtProxy(value = "eu.musesproject.server.rt2ae.Clue", readOnly = { "clueId" }, scaffold = true)
public interface ClueProxy extends EntityProxy {

    abstract Integer getClueId();

    abstract ThreatProxy getThreatId();

    abstract void setThreatId(ThreatProxy threatId);

    abstract String getValue();

    abstract void setValue(String value);
}
