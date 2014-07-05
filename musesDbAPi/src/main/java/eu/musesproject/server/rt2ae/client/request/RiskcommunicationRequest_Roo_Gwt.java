// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package eu.musesproject.server.rt2ae.client.request;
import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import eu.musesproject.server.rt2ae.client.proxy.RiskcommunicationProxy;
import java.util.List;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("eu.musesproject.server.rt2ae.Riskcommunication")
@ServiceName("eu.musesproject.server.rt2ae.Riskcommunication")
public interface RiskcommunicationRequest_Roo_Gwt extends RequestContext {

    abstract Request<Long> countRiskcommunications();

    abstract Request<List<RiskcommunicationProxy>> findAllRiskcommunications();

    abstract Request<List<RiskcommunicationProxy>> findRiskcommunicationEntries(int firstResult, int maxResults);

    abstract Request<RiskcommunicationProxy> findRiskcommunication(Integer id);

    abstract InstanceRequest<RiskcommunicationProxy, Void> persist();

    abstract InstanceRequest<RiskcommunicationProxy, Void> remove();
}
