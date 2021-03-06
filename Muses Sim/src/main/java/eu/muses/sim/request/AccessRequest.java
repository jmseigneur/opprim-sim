/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.muses.sim.request;

import java.util.Calendar;
import java.util.Collection;
import java.util.Vector;

import eu.muses.sim.OpportunityDescriptor;
import eu.muses.sim.decision.CorporateUserAccessRequestDecision;
import eu.muses.sim.decision.UserAccessDecision;
import eu.muses.sim.riskman.RiskCommunication;
import eu.muses.sim.riskman.RiskEvent;
import eu.muses.sim.riskman.asset.Asset;
import eu.muses.sim.test.SimUser;
import eu.muses.sim.userman.action.UserAction;
import eu.muses.wp5.CluesThreatEntry;

/**
 * The Class AccessRequest.
 */
public class AccessRequest extends Request {

	/** The risk communication. */
	private RiskCommunication riskCommunication;

	/** The corporate access request decision. */
	private CorporateUserAccessRequestDecision corporateAccessRequestDecision;

	/** The user access decision. */
	private UserAccessDecision userAccessDecision;

	/** The opportunity descriptor. */
	private OpportunityDescriptor opportunityDescriptor;

	/** The requested corporate assets. */
	private Collection<Asset> requestedCorporateAssets = new Vector<Asset>();

	/** The user. */
	private SimUser user;
	
	/** The user action */
	UserAction userAction;
	
	/** The clues threat entry */
	private CluesThreatEntry cluesThreatEntry;
	
	/** The solved status */
	private boolean solved = false;
	
	/** The allowed status */
	private boolean allowed = false;
	
	/** The malicious status */
	private boolean malicious = false;
	
	private Calendar time;

	/**
	 * The risk events.
	 *
	 * @uml.property name="riskEvent"
	 * @uml.associationEnd multiplicity="(0 -1)" dimension="1"
	 *                     inverse="accessRequest:eu.muses.sim.riskman.RiskEvent"
	 * @uml.association name="generates"
	 */
	private RiskEvent[] riskEvents;

	/**
	 * Instantiates a new access request.
	 *
	 * @param asset
	 *            the asset
	 */
	public AccessRequest(Asset asset) {
		super();
		this.requestedCorporateAssets.add(asset);

	}

	public AccessRequest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets the access risk communication.
	 *
	 * @return the access risk communication
	 */
	public RiskCommunication getAccessRiskCommunication() {
		return this.riskCommunication;
	}

	/**
	 * Gets the corporate access request decision.
	 *
	 * @return the corporate access request decision
	 */
	public CorporateUserAccessRequestDecision getCorporateAccessRequestDecision() {
		return this.corporateAccessRequestDecision;
	}

	/**
	 * Gets the denial decision reasons.
	 *
	 * @return the denial decision reasons
	 */
	public AccessRequest getDenialDecisionReasons() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Gets the opportunity descriptor.
	 *
	 * @return the opportunity descriptor
	 */
	public OpportunityDescriptor getOpportunityDescriptor() {
		return this.opportunityDescriptor;
	}

	/**
	 * Gets the requested corporate asset.
	 *
	 * @return the requested corporate asset
	 */
	public Collection<Asset> getRequestedCorporateAsset() {
		return this.requestedCorporateAssets;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.muses.sim.request.Request#getRiskEvent()
	 */
	@Override
	public RiskEvent[] getRiskEvent() {
		return this.riskEvents;
	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public SimUser getUser() {
		return this.user;
	}

	/**
	 * Sets the user.
	 *
	 * @param the
	 *            user
	 */
	public void setUser(SimUser user) {
		this.user = user;
	}

	/**
	 * Gets the user access decision.
	 *
	 * @return the user access decision
	 */
	public UserAccessDecision getUserAccessDecision() {
		return this.userAccessDecision;
	}

	/**
	 * Sets the access risk.
	 *
	 * @param riskCommunication
	 *            the new access risk
	 */
	public void setAccessRisk(RiskCommunication riskCommunication) {
		this.riskCommunication = riskCommunication;
	}

	/**
	 * Sets the corporate access request decision.
	 *
	 * @param corporateAccessRequestDecision
	 *            the new corporate access request decision
	 */
	public void setCorporateAccessRequestDecision(
			CorporateUserAccessRequestDecision corporateAccessRequestDecision) {
		this.corporateAccessRequestDecision = corporateAccessRequestDecision;
	}

	/**
	 * Sets the opportunity descriptor.
	 *
	 * @param opportunityDescriptor
	 *            the new opportunity descriptor
	 */
	public void setOpportunityDescriptor(
			OpportunityDescriptor opportunityDescriptor) {
		this.opportunityDescriptor = opportunityDescriptor;
		this.requestedCorporateAssets = opportunityDescriptor
				.getRequestedAssets();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.muses.sim.request.Request#setRiskEvent(eu.muses.sim.riskman.RiskEvent
	 * [])
	 */
	@Override
	public void setRiskEvent(RiskEvent[] riskEvent) {
		this.riskEvents = riskEvent;
	}

	/**
	 * Sets the user access decision.
	 *
	 * @param userAccessDecision
	 *            the new user access decision
	 */
	public void setUserAccessDecision(UserAccessDecision userAccessDecision) {
		this.userAccessDecision = userAccessDecision;
	}

	/**
	 * @return the userAction
	 */
	public UserAction getUserAction() {
		return userAction;
	}

	/**
	 * @param userAction the userAction to set
	 */
	public void setUserAction(UserAction userAction) {
		this.userAction = userAction;
	}

	/**
	 * @return the cluesThreatEntry
	 */
	public CluesThreatEntry getCluesThreatEntry() {
		return cluesThreatEntry;
	}

	/**
	 * @param cluesThreatEntry the cluesThreatEntry to set
	 */
	public void setCluesThreatEntry(CluesThreatEntry cluesThreatEntry) {
		this.cluesThreatEntry = cluesThreatEntry;
	}

	/**
	 * @return the solved
	 */
	public boolean isSolved() {
		return solved;
	}

	/**
	 * @param solved the solved to set
	 */
	public void setSolved(boolean solved) {
		this.solved = solved;
	}

	/**
	 * @param requestedCorporateAssets the requestedCorporateAssets to set
	 */
	public void setRequestedCorporateAssets(
			Collection<Asset> requestedCorporateAssets) {
		this.requestedCorporateAssets = requestedCorporateAssets;
	}

	/**
	 * @return the time
	 */
	public Calendar getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(Calendar time) {
		this.time = time;
	}

	/**
	 * @return the allowed
	 */
	public boolean isAllowed() {
		return allowed;
	}

	/**
	 * @param allowed the allowed to set
	 */
	public void setAllowed(boolean allowed) {
		this.allowed = allowed;
	}

	/**
	 * @return the malicious
	 */
	public boolean isMalicious() {
		return malicious;
	}

	/**
	 * @param malicious the malicious to set
	 */
	public void setMalicious(boolean malicious) {
		this.malicious = malicious;
	}

}
