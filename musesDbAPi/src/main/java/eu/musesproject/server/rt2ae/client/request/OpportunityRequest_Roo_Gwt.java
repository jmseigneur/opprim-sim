// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package eu.musesproject.server.rt2ae.client.request;
import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import eu.musesproject.server.rt2ae.client.proxy.OpportunityProxy;
import java.util.List;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("eu.musesproject.server.rt2ae.Opportunity")
@ServiceName("eu.musesproject.server.rt2ae.Opportunity")
public interface OpportunityRequest_Roo_Gwt extends RequestContext {

    abstract Request<Long> countOpportunitys();

    abstract Request<List<OpportunityProxy>> findAllOpportunitys();

    abstract Request<List<OpportunityProxy>> findOpportunityEntries(int firstResult, int maxResults);

    abstract Request<OpportunityProxy> findOpportunity(Integer id);

    abstract InstanceRequest<OpportunityProxy, Void> persist();

    abstract InstanceRequest<OpportunityProxy, Void> remove();
}
