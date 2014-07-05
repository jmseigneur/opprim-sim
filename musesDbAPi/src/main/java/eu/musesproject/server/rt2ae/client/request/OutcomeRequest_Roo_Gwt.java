// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package eu.musesproject.server.rt2ae.client.request;
import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import eu.musesproject.server.rt2ae.client.proxy.OutcomeProxy;
import java.util.List;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("eu.musesproject.server.rt2ae.Outcome")
@ServiceName("eu.musesproject.server.rt2ae.Outcome")
public interface OutcomeRequest_Roo_Gwt extends RequestContext {

    abstract Request<Long> countOutcomes();

    abstract Request<List<OutcomeProxy>> findAllOutcomes();

    abstract Request<List<OutcomeProxy>> findOutcomeEntries(int firstResult, int maxResults);

    abstract Request<OutcomeProxy> findOutcome(Integer id);

    abstract InstanceRequest<OutcomeProxy, Void> persist();

    abstract InstanceRequest<OutcomeProxy, Void> remove();
}
