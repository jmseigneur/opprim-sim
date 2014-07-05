// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package eu.musesproject.server.rt2ae.client.request;
import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import eu.musesproject.server.rt2ae.client.proxy.SecurityIncidentProxy;
import java.util.List;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("eu.musesproject.server.rt2ae.SecurityIncident")
@ServiceName("eu.musesproject.server.rt2ae.SecurityIncident")
public interface SecurityIncidentRequest_Roo_Gwt extends RequestContext {

    abstract Request<Long> countSecurityIncidents();

    abstract Request<List<SecurityIncidentProxy>> findAllSecurityIncidents();

    abstract Request<List<SecurityIncidentProxy>> findSecurityIncidentEntries(int firstResult, int maxResults);

    abstract Request<SecurityIncidentProxy> findSecurityIncident(Integer id);

    abstract InstanceRequest<SecurityIncidentProxy, Void> persist();

    abstract InstanceRequest<SecurityIncidentProxy, Void> remove();
}
