// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package eu.musesproject.server.rt2ae.client.request;
import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import eu.musesproject.server.rt2ae.client.proxy.RiskinformationProxy;
import java.util.List;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("eu.musesproject.server.rt2ae.Riskinformation")
@ServiceName("eu.musesproject.server.rt2ae.Riskinformation")
public interface RiskinformationRequest_Roo_Gwt extends RequestContext {

    abstract Request<Long> countRiskinformations();

    abstract Request<List<RiskinformationProxy>> findAllRiskinformations();

    abstract Request<List<RiskinformationProxy>> findRiskinformationEntries(int firstResult, int maxResults);

    abstract Request<RiskinformationProxy> findRiskinformation(Integer id);

    abstract InstanceRequest<RiskinformationProxy, Void> persist();

    abstract InstanceRequest<RiskinformationProxy, Void> remove();
}
