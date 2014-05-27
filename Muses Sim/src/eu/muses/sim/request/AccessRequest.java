package eu.muses.sim.request;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Vector;

import eu.muses.sim.OpportunityDescriptor;
import eu.muses.sim.context.location.Location;
import eu.muses.sim.decision.CorporateUserAccessRequestDecision;
import eu.muses.sim.decision.UserAccessDecision;
import eu.muses.sim.riskman.RiskCommunication;
import eu.muses.sim.riskman.RiskEvent;
import eu.muses.sim.riskman.asset.Asset;
import eu.muses.sim.riskman.asset.CorporateAsset;
import eu.muses.sim.riskman.asset.UserDevice;
import eu.muses.sim.riskman.opportunity.Opportunity;
import eu.muses.sim.sim.SimUser;


public class AccessRequest extends Request {
	
	
	private RiskCommunication riskCommunication;
	private CorporateUserAccessRequestDecision corporateAccessRequestDecision;
	private UserAccessDecision userAccessDecision;
	private OpportunityDescriptor opportunityDescriptor;
	
	private Collection<Asset> requestedCorporateAssets = new Vector<Asset>();
	private Location location;
	private UserDevice device;
	private SimUser user;
	
	public AccessRequest(Asset asset) {
		super();
		requestedCorporateAssets.add(asset);

	}
	public RiskCommunication getAccessRiskCommunication() {
		return riskCommunication;
	}
	public void setAccessRisk(RiskCommunication riskCommunication) {
		this.riskCommunication = riskCommunication;
	}
	public CorporateUserAccessRequestDecision getCorporateAccessRequestDecision() {
		return corporateAccessRequestDecision;
	}
	public void setCorporateAccessRequestDecision(
			CorporateUserAccessRequestDecision corporateAccessRequestDecision) {
		this.corporateAccessRequestDecision = corporateAccessRequestDecision;
	}
	public UserAccessDecision getUserAccessDecision() {
		return userAccessDecision;
	}
	public void setUserAccessDecision(UserAccessDecision userAccessDecision) {
		this.userAccessDecision = userAccessDecision;
	}
	public AccessRequest getDenialDecisionReasons() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * @uml.property  name="riskEvent"
	 * @uml.associationEnd  multiplicity="(0 -1)" dimension="1" inverse="accessRequest:eu.muses.sim.riskman.RiskEvent"
	 * @uml.association  name="generates"
	 */
	private RiskEvent[] riskEvents;

	/**
	 * Getter of the property <tt>riskEvent</tt>
	 * @return  Returns the riskEvents.
	 * @uml.property  name="riskEvent"
	 */
	public RiskEvent[] getRiskEvent() {
		return riskEvents;
	}
	/**
	 * Setter of the property <tt>riskEvent</tt>
	 * @param riskEvent  The riskEvents to set.
	 * @uml.property  name="riskEvent"
	 */
	public void setRiskEvent(RiskEvent[] riskEvent) {
		riskEvents = riskEvent;
	}
	public OpportunityDescriptor getOpportunityDescriptor() {
		return opportunityDescriptor;
	}
	public void setOpportunityDescriptor(OpportunityDescriptor opportunityDescriptor) {
		this.opportunityDescriptor = opportunityDescriptor;
		this.requestedCorporateAssets = opportunityDescriptor.getRequestedAssets();
	}
	public SimUser getUser() {
		return user;
	}
	public Collection<Asset> getRequestedCorporateAsset() {
		return requestedCorporateAssets;
	}
	
	

}
