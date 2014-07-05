// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package eu.musesproject.server.rt2ae.client.request;
import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import eu.musesproject.server.rt2ae.client.proxy.AccessrequestProxy;
import java.util.List;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("eu.musesproject.server.rt2ae.Accessrequest")
@ServiceName("eu.musesproject.server.rt2ae.Accessrequest")
public interface AccessrequestRequest_Roo_Gwt extends RequestContext {

    abstract Request<Long> countAccessrequests();

    abstract Request<List<AccessrequestProxy>> findAllAccessrequests();

    abstract Request<List<AccessrequestProxy>> findAccessrequestEntries(int firstResult, int maxResults);

    abstract Request<AccessrequestProxy> findAccessrequest(Integer id);

    abstract InstanceRequest<AccessrequestProxy, Void> persist();

    abstract InstanceRequest<AccessrequestProxy, Void> remove();
}
