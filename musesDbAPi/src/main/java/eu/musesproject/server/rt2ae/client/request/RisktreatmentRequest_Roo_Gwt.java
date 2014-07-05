// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package eu.musesproject.server.rt2ae.client.request;
import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import eu.musesproject.server.rt2ae.client.proxy.RisktreatmentProxy;
import java.util.List;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("eu.musesproject.server.rt2ae.Risktreatment")
@ServiceName("eu.musesproject.server.rt2ae.Risktreatment")
public interface RisktreatmentRequest_Roo_Gwt extends RequestContext {

    abstract Request<Long> countRisktreatments();

    abstract Request<List<RisktreatmentProxy>> findAllRisktreatments();

    abstract Request<List<RisktreatmentProxy>> findRisktreatmentEntries(int firstResult, int maxResults);

    abstract Request<RisktreatmentProxy> findRisktreatment(Integer id);

    abstract InstanceRequest<RisktreatmentProxy, Void> persist();

    abstract InstanceRequest<RisktreatmentProxy, Void> remove();
}
