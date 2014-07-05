// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package eu.musesproject.server.rt2ae.client.proxy;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import java.util.Set;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "eu.musesproject.server.rt2ae.UserAction", locator = "eu.musesproject.server.rt2ae.server.locator.UserActionLocator")
@RooGwtProxy(value = "eu.musesproject.server.rt2ae.UserAction", readOnly = { "useractionId" }, scaffold = true)
public interface UserActionProxy extends EntityProxy {

    abstract Integer getUseractionId();

    abstract Set<AccessrequestProxy> getAccessrequests();

    abstract void setAccessrequests(Set<AccessrequestProxy> accessrequests);

    abstract Integer getId();

    abstract void setId(Integer id);
}
