// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package eu.musesproject.server.rt2ae.client.request;
import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import eu.musesproject.server.rt2ae.client.proxy.UserProxy;
import java.util.List;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("eu.musesproject.server.rt2ae.User")
@ServiceName("eu.musesproject.server.rt2ae.User")
public interface UserRequest_Roo_Gwt extends RequestContext {

    abstract Request<Long> countUsers();

    abstract Request<List<UserProxy>> findAllUsers();

    abstract Request<List<UserProxy>> findUserEntries(int firstResult, int maxResults);

    abstract Request<UserProxy> findUser(Integer id);

    abstract InstanceRequest<UserProxy, Void> persist();

    abstract InstanceRequest<UserProxy, Void> remove();
}
