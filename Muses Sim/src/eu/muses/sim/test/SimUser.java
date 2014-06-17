/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.muses.sim.test;

import java.util.Collection;

import eu.muses.sim.OpportunityDescriptor;
import eu.muses.sim.RealTimeRiskTrustAnalysisEngine;
import eu.muses.sim.context.location.Location;
import eu.muses.sim.request.AccessRequest;
import eu.muses.sim.riskman.RiskCommunication;
import eu.muses.sim.riskman.RiskPolicy;
import eu.muses.sim.riskman.RiskTreatment;
import eu.muses.sim.riskman.RiskValue;
import eu.muses.sim.riskman.asset.Asset;
import eu.muses.sim.riskman.asset.UserDevice;
import eu.muses.sim.riskman.opportunity.Opportunity;
import eu.muses.sim.trustman.TrustValue;
import eu.muses.sim.userman.Credential;
import eu.muses.sim.userman.User;
import eu.muses.wp5.EventProcessor;

/**
 * The Class SimUser.
 */
public class SimUser extends User {

	/**
	 * Requests access to asset.
	 *
	 * @param requestedAssestByUser
	 *            the requested assest by user
	 * @return the access request
	 */
	public static AccessRequest requestsAccessToAsset(
			Asset requestedAssestByUser) {
		AccessRequest accessRequest = new AccessRequest(requestedAssestByUser);
		return accessRequest;
	}

	/** The hourly cost. */
	private double hourlyCost;

	/** The TrustValue */
	private TrustValue trustValue;

	public TrustValue getTrustValue() {
		return trustValue;
	}

	public void setTrustValue(TrustValue trustValue) {
		this.trustValue = trustValue;
	}

	public void setHourlyCost(double hourlyCost) {
		this.hourlyCost = hourlyCost;
	}

	/**
	 * Instantiates a new sim user.
	 *
	 * @param nickname
	 *            the nickname
	 * @param hourlyCost
	 *            the hourly cost
	 */
	public SimUser(String nickname, double hourlyCost, TrustValue tValue) {
		super(nickname);
		this.hourlyCost = hourlyCost;
		this.trustValue = tValue;
		// TODO Auto-generated constructor stub
	}

	/**
	 * Accepts to refine opportunity.
	 *
	 * @return true, if successful
	 */
	public boolean acceptsToRefineOpportunity() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * Adds new asset to rt2ae.
	 *
	 * @param rt2ae
	 *            the rt2ae
	 * @param asset
	 *            the asset
	 * @return the asset
	 */
	public Asset addsNewAssetToRt2ae(RealTimeRiskTrustAnalysisEngine rt2ae,
			Asset asset) {
		rt2ae.addAsset(asset);
		return asset;
	}

	/**
	 * Applies successfully risk treatment.
	 *
	 * @param riskTreatment
	 *            the risk treatment
	 * @return true, if successful
	 */
	public boolean appliesSuccessfullyRiskTreatment(RiskTreatment riskTreatment) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Authenticates.
	 *
	 * @return the credential[]
	 */
	public Credential[] authenticates() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Authenticate wih muses credentials.
	 *
	 * @param userLogin
	 *            the user login
	 * @param password
	 *            the password
	 * @return true, if successful
	 */
	public boolean authenticateWihMusesCredentials(String userLogin,
			String password) {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * Checks if device is trustworthy enough.
	 *
	 * @return true, if successful
	 */
	public boolean checksIfDeviceIsTrustworthyEnough() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Configure event correlator.
	 *
	 * @return the event processor
	 */
	public EventProcessor configureEventCorrelator() {
		// TODO Auto-generated method stub
		return new EventProcessor();
	}

	/**
	 * Configure muses client app.
	 *
	 * @param musesServerApp
	 *            the muses server app
	 * @return the muses client app
	 */
	public MusesClientApp configureMusesClientApp(MusesServerApp musesServerApp) {
		// TODO Auto-generated method stub
		return new MusesClientApp();
	}

	/**
	 * Configure muses server app.
	 *
	 * @param rt2ae
	 *            the rt2ae
	 * @return the muses server app
	 */
	public MusesServerApp configureMusesServerApp(
			RealTimeRiskTrustAnalysisEngine rt2ae) {
		// TODO Auto-generated method stub
		return new MusesServerApp(rt2ae);
	}

	/**
	 * Configure risk policy.
	 *
	 * @return the risk policy
	 */
	public RiskPolicy configureRiskPolicy() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Configure risk policy.
	 *
	 * @param riskValue
	 *            the risk value
	 * @return the risk policy
	 */
	public RiskPolicy configureRiskPolicy(RiskValue riskValue) {
		// TODO Auto-generated method stub
		return new RiskPolicy(riskValue, null);
	}

	/**
	 * Configure rt2ae.
	 *
	 * @param eventProcessor
	 *            the event processor
	 * @param riskPolicy
	 *            the risk policy
	 * @return the real time risk trust analysis engine
	 */
	public RealTimeRiskTrustAnalysisEngine configureRt2ae(
			EventProcessor eventProcessor, RiskPolicy riskPolicy) {

		// TODO Auto-generated method stub
		return new RealTimeRiskTrustAnalysisEngine(eventProcessor, riskPolicy);
	}

	/**
	 * Decides accessing asset in spite of risk.
	 *
	 * @param accessRequest
	 *            the access request
	 * @return true, if successful
	 */
	public boolean decidesAccessingAssetInSpiteOfRisk(
			AccessRequest accessRequest) {
		// TODO implement how the user can decide to access the asset in spite
		// of risk
		return true;
	}

	/**
	 * Decides not accessing asset due to risk.
	 *
	 * @return true, if successful
	 */
	public boolean decidesNotAccessingAssetDueToRisk() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Decides to apply a proposed risk treatment.
	 *
	 * @param accessRequest
	 *            the access request
	 * @return true, if successful
	 */
	public boolean decidesToApplyAProposedRiskTreatment(
			AccessRequest accessRequest) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Enrolls user in company information system.
	 *
	 * @param user1
	 *            the user1
	 */
	public void enrollsUserInCompanyInformationSystem(SimUser user1) {
		// TODO Auto-generated method stub

	}

	/**
	 * Gets the corporate assets.
	 *
	 * @param accessRequest
	 *            the access request
	 * @return the corporate assets
	 */
	public Asset[] getCorporateAssets(AccessRequest accessRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Gets the hourly cost.
	 *
	 * @return the hourly cost
	 */
	public double getHourlyCost() {
		return this.hourlyCost;
	}

	/**
	 * Gives up request due to risk.
	 *
	 * @param accessRequest
	 *            the access request
	 * @return true, if successful
	 */
	public boolean givesUpRequestDueToRisk(AccessRequest accessRequest) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Checks for cso configured assets.
	 *
	 * @param s2Rt2ae
	 *            the s2 rt2ae
	 * @return true, if successful
	 */
	public boolean hasCsoConfiguredAssets(
			RealTimeRiskTrustAnalysisEngine s2Rt2ae) {

		return s2Rt2ae.hasAssets();
	}

	/**
	 * Installs.
	 *
	 * @param s2EventCorrelator
	 *            the s2 event correlator
	 */
	public void installs(EventProcessor s2EventCorrelator) {
		// TODO Auto-generated method stub

	}

	/**
	 * Installs.
	 *
	 * @param s2Rt2ae
	 *            the s2 rt2ae
	 */
	public void installs(RealTimeRiskTrustAnalysisEngine s2Rt2ae) {
		// TODO Auto-generated method stub

	}

	/**
	 * Installs on server.
	 *
	 * @param s2MusesServerApp
	 *            the s2 muses server app
	 */
	public void installsOnServer(MusesServerApp s2MusesServerApp) {
		// TODO Auto-generated method stub

	}

	/**
	 * Checks if is informed of successfully applied risk treatment.
	 *
	 * @param riskTreatment
	 *            the risk treatment
	 */
	public void isInformedOfSuccessfullyAppliedRiskTreatment(
			RiskTreatment riskTreatment) {
		// TODO Auto-generated method stub

	}

	/**
	 * Checks if is informed of unsuccessfull risk treatment application.
	 */
	public void isInformedOfUnsuccessfullRiskTreatmentApplication() {
		// TODO Auto-generated method stub

	}

	/**
	 * Checks if is still making request.
	 *
	 * @param accessRequest
	 *            the access request
	 * @return true, if is still making request
	 */
	public boolean isStillMakingRequest(AccessRequest accessRequest) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Log new device.
	 *
	 * @param user1Laptop
	 *            the user1 laptop
	 */
	public void logNewDevice(UserDevice user1Laptop) {
		// TODO Auto-generated method stub

	}

	/**
	 * Moves to.
	 *
	 * @param location
	 *            the location
	 */
	public void movesTo(Location location) {
		// TODO implement moving to a new location
	}

	/**
	 * Reads access denial decision reasons.
	 *
	 * @param accessRequest
	 *            the access request
	 */
	public void readsAccessDenialDecisionReasons(AccessRequest accessRequest) {
		// TODO Auto-generated method stub

	}

	/**
	 * Reads access risk communication including potential risk treatments.
	 *
	 * @param riskCommunication
	 *            the risk communication
	 */
	public void readsAccessRiskCommunicationIncludingPotentialRiskTreatments(
			RiskCommunication riskCommunication) {
		// TODO implement displaying the access risk to the user
	}

	/**
	 * Refines opportunity.
	 *
	 * @return the opportunity descriptor
	 */
	public OpportunityDescriptor refinesOpportunity() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Requests access to assets for opportunity.
	 *
	 * @param assets
	 *            the assets
	 * @param opportunity
	 *            the opportunity
	 * @param location
	 *            the location
	 * @param device
	 *            the device
	 * @return the access request
	 */
	public AccessRequest requestsAccessToAssetsForOpportunity(
			Collection<Asset> assets, Opportunity opportunity,
			Location location, UserDevice device) {
		// TODO implement access to requested asset if granted
		return null; // new AccessRequest(assets, opportunity, location,
						// device);
	}

	/**
	 * Sets the risk policy.
	 *
	 * @param riskPolicy
	 *            the new risk policy
	 */
	public void setRiskPolicy(RiskPolicy riskPolicy) {
		// TODO Auto-generated method stub

	}

	/**
	 * Sets the still making request.
	 *
	 * @param accessRequest
	 *            the access request
	 * @param b
	 *            the b
	 */
	public void setStillMakingRequest(AccessRequest accessRequest, boolean b) {
		// TODO Auto-generated method stub

	}

	/**
	 * Successfully use corporate assets given the specified opportunity.
	 *
	 * @param opportunityDescriptor
	 *            the opportunity descriptor
	 * @return true, if successful
	 */
	public boolean successfullyUseCorporateAssetsGivenTheSpecifiedOpportunity(
			OpportunityDescriptor opportunityDescriptor) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Type password.
	 *
	 * @return the string
	 */
	public String typePassword() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Updates access request with user decision.
	 */
	public void updatesAccessRequestWithUserDecision() {
		// TODO implement adding the user decision to the access request
	}

	/**
	 * Uses corporate assets.
	 *
	 * @param corporateAssets
	 *            the corporate assets
	 */
	public void usesCorporateAssets(Asset[] corporateAssets) {
		// TODO Auto-generated method stub

	}

}
