// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package eu.musesproject.server.rt2ae.client.request;
import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import eu.musesproject.server.rt2ae.client.proxy.DeviceSecurityStateProxy;
import java.util.List;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("eu.musesproject.server.rt2ae.DeviceSecurityState")
@ServiceName("eu.musesproject.server.rt2ae.DeviceSecurityState")
public interface DeviceSecurityStateRequest_Roo_Gwt extends RequestContext {

    abstract Request<Long> countDeviceSecurityStates();

    abstract Request<List<DeviceSecurityStateProxy>> findAllDeviceSecurityStates();

    abstract Request<List<DeviceSecurityStateProxy>> findDeviceSecurityStateEntries(int firstResult, int maxResults);

    abstract Request<DeviceSecurityStateProxy> findDeviceSecurityState(Integer id);

    abstract InstanceRequest<DeviceSecurityStateProxy, Void> persist();

    abstract InstanceRequest<DeviceSecurityStateProxy, Void> remove();
}
