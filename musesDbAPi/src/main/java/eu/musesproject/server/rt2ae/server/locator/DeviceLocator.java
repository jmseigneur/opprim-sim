package eu.musesproject.server.rt2ae.server.locator;
import com.google.web.bindery.requestfactory.shared.Locator;
import eu.musesproject.server.rt2ae.Device;
import org.springframework.roo.addon.gwt.RooGwtLocator;
import org.springframework.stereotype.Component;

@RooGwtLocator("eu.musesproject.server.rt2ae.Device")
@Component
public class DeviceLocator extends Locator<Device, Integer> {

    public Device create(Class<? extends eu.musesproject.server.rt2ae.Device> clazz) {
        return new Device();
    }

    public Device find(Class<? extends eu.musesproject.server.rt2ae.Device> clazz, Integer id) {
        return Device.findDevice(id);
    }

    public Class<Device> getDomainType() {
        return Device.class;
    }

    public Integer getId(Device device) {
        return device.getDeviceId();
    }

    public Class<Integer> getIdType() {
        return Integer.class;
    }

    public Object getVersion(Device device) {
        return device.getVersion();
    }
}
