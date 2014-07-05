// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package eu.musesproject.server.rt2ae.client.request;
import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import eu.musesproject.server.rt2ae.client.proxy.UserActionProxy;
import java.util.List;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("eu.musesproject.server.rt2ae.UserAction")
@ServiceName("eu.musesproject.server.rt2ae.UserAction")
public interface UserActionRequest_Roo_Gwt extends RequestContext {

    abstract Request<Long> countUserActions();

    abstract Request<List<UserActionProxy>> findAllUserActions();

    abstract Request<List<UserActionProxy>> findUserActionEntries(int firstResult, int maxResults);

    abstract Request<UserActionProxy> findUserAction(Integer id);

    abstract InstanceRequest<UserActionProxy, Void> persist();

    abstract InstanceRequest<UserActionProxy, Void> remove();
}
