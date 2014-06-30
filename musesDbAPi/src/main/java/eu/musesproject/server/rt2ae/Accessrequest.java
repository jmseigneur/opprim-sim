package eu.musesproject.server.rt2ae;
import org.springframework.roo.addon.dbre.RooDbManaged;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooJpaActiveRecord(versionField = "", table = "accessrequest")
@RooDbManaged(automaticallyDelete = true)
@RooToString(excludeFields = { "riskinformations", "assetId", "deviceId", "userId", "assets", "opportunityId", "riskcommunicationid", "threatid", "useractionId" })
public class Accessrequest {
}
