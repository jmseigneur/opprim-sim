package eu.musesproject.server.rt2ae;
import org.springframework.roo.addon.dbre.RooDbManaged;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooJpaActiveRecord(versionField = "", table = "asset")
@RooDbManaged(automaticallyDelete = true)
@RooToString(excludeFields = { "accessrequests", "riskinformations", "securityIncidents", "opportunities", "opportunityid", "accessrequestId" })
public class Asset {
}
