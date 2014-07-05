// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package eu.musesproject.server.rt2ae.client.request;
import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import eu.musesproject.server.rt2ae.client.proxy.AssetProxy;
import java.util.List;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("eu.musesproject.server.rt2ae.Asset")
@ServiceName("eu.musesproject.server.rt2ae.Asset")
public interface AssetRequest_Roo_Gwt extends RequestContext {

    abstract Request<Long> countAssets();

    abstract Request<List<AssetProxy>> findAllAssets();

    abstract Request<List<AssetProxy>> findAssetEntries(int firstResult, int maxResults);

    abstract Request<AssetProxy> findAsset(Integer id);

    abstract InstanceRequest<AssetProxy, Void> persist();

    abstract InstanceRequest<AssetProxy, Void> remove();
}
