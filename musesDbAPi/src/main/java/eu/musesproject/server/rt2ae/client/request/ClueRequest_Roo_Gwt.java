// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package eu.musesproject.server.rt2ae.client.request;
import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import eu.musesproject.server.rt2ae.client.proxy.ClueProxy;
import java.util.List;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("eu.musesproject.server.rt2ae.Clue")
@ServiceName("eu.musesproject.server.rt2ae.Clue")
public interface ClueRequest_Roo_Gwt extends RequestContext {

    abstract Request<Long> countClues();

    abstract Request<List<ClueProxy>> findAllClues();

    abstract Request<List<ClueProxy>> findClueEntries(int firstResult, int maxResults);

    abstract Request<ClueProxy> findClue(Integer id);

    abstract InstanceRequest<ClueProxy, Void> persist();

    abstract InstanceRequest<ClueProxy, Void> remove();
}
