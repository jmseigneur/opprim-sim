// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package eu.musesproject.server.rt2ae.client.request;
import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import eu.musesproject.server.rt2ae.client.proxy.DeviceProxy;
import java.util.List;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("eu.musesproject.server.rt2ae.Device")
@ServiceName("eu.musesproject.server.rt2ae.Device")
public interface DeviceRequest_Roo_Gwt extends RequestContext {

    abstract Request<Long> countDevices();

    abstract Request<List<DeviceProxy>> findAllDevices();

    abstract Request<List<DeviceProxy>> findDeviceEntries(int firstResult, int maxResults);

    abstract Request<DeviceProxy> findDevice(Integer id);

    abstract InstanceRequest<DeviceProxy, Void> persist();

    abstract InstanceRequest<DeviceProxy, Void> remove();
}
