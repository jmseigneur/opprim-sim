// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package eu.musesproject.server.rt2ae.client.request;
import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import eu.musesproject.server.rt2ae.client.proxy.RiskPolicyProxy;
import java.util.List;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("eu.musesproject.server.rt2ae.RiskPolicy")
@ServiceName("eu.musesproject.server.rt2ae.RiskPolicy")
public interface RiskPolicyRequest_Roo_Gwt extends RequestContext {

    abstract Request<Long> countRiskPolicys();

    abstract Request<List<RiskPolicyProxy>> findAllRiskPolicys();

    abstract Request<List<RiskPolicyProxy>> findRiskPolicyEntries(int firstResult, int maxResults);

    abstract Request<RiskPolicyProxy> findRiskPolicy(Integer id);

    abstract InstanceRequest<RiskPolicyProxy, Void> persist();

    abstract InstanceRequest<RiskPolicyProxy, Void> remove();
}
