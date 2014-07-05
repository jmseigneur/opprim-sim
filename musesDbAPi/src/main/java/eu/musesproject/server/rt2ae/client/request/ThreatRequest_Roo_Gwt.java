// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package eu.musesproject.server.rt2ae.client.request;
import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import eu.musesproject.server.rt2ae.client.proxy.ThreatProxy;
import java.util.List;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("eu.musesproject.server.rt2ae.Threat")
@ServiceName("eu.musesproject.server.rt2ae.Threat")
public interface ThreatRequest_Roo_Gwt extends RequestContext {

    abstract Request<Long> countThreats();

    abstract Request<List<ThreatProxy>> findAllThreats();

    abstract Request<List<ThreatProxy>> findThreatEntries(int firstResult, int maxResults);

    abstract Request<ThreatProxy> findThreat(Integer id);

    abstract InstanceRequest<ThreatProxy, Void> persist();

    abstract InstanceRequest<ThreatProxy, Void> remove();
}
