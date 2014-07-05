// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package eu.musesproject.server.rt2ae.client.request;
import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import eu.musesproject.server.rt2ae.client.proxy.DecisionProxy;
import java.util.List;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("eu.musesproject.server.rt2ae.Decision")
@ServiceName("eu.musesproject.server.rt2ae.Decision")
public interface DecisionRequest_Roo_Gwt extends RequestContext {

    abstract Request<Long> countDecisions();

    abstract Request<List<DecisionProxy>> findAllDecisions();

    abstract Request<List<DecisionProxy>> findDecisionEntries(int firstResult, int maxResults);

    abstract Request<DecisionProxy> findDecision(Integer id);

    abstract InstanceRequest<DecisionProxy, Void> persist();

    abstract InstanceRequest<DecisionProxy, Void> remove();
}
