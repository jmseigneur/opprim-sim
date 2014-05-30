package eu.muses.sim.sim;

import java.util.Collection;
import java.util.Vector;

import eu.muses.sim.OpportunityDescriptor;
import eu.muses.sim.RealTimeRiskTrustAnalysisEngine;
import eu.muses.sim.context.location.Location;
import eu.muses.sim.request.AccessRequest;
import eu.muses.sim.riskman.RiskCommunication;
import eu.muses.sim.riskman.RiskPolicy;
import eu.muses.sim.riskman.RiskTreatment;
import eu.muses.sim.riskman.RiskValue;
import eu.muses.sim.riskman.asset.Asset;
import eu.muses.sim.riskman.asset.CorporateAsset;
import eu.muses.sim.riskman.asset.UserDevice;
import eu.muses.sim.riskman.opportunity.Opportunity;
import eu.muses.sim.userman.Credential;
import eu.muses.sim.userman.User;
import eu.muses.wp5.EventProcessor;

public class SimUser extends User {
	
	private double hourlyCost;
	
	public SimUser(String nickname, double hourlyCost) {
		super(nickname);
		// TODO Auto-generated constructor stub
	}

	public void movesTo(Location location) {
		//TODO implement moving to a new location
	}
	
	public AccessRequest requestsAccessToAssetsForOpportunity(Collection<Asset> assets, Opportunity opportunity, Location location, UserDevice device) {
		//TODO implement access to requested asset if granted
		return null; // new AccessRequest(assets, opportunity, location, device);
	}
	
	public void readsAccessRiskCommunicationIncludingPotentialRiskTreatments(RiskCommunication riskCommunication) {
		//TODO implement displaying the access risk to the user
	}

	public boolean decidesAccessingAssetInSpiteOfRisk(AccessRequest accessRequest) {
		//TODO implement how the user can decide to access the asset in spite of risk
		return true;
	}
	
	public void updatesAccessRequestWithUserDecision() {
		//TODO implement adding the user decision to the access request
	}
	

	public void usesCorporateAssets(Asset[] corporateAssets) {
		// TODO Auto-generated method stub
		
	}

	public void readsAccessDenialDecisionReasons(AccessRequest accessRequest) {
		// TODO Auto-generated method stub
		
	}

	public boolean decidesToApplyAProposedRiskTreatment(
			AccessRequest accessRequest) {
		// TODO Auto-generated method stub
		return false;
	}

	public double getHourlyCost() {
		return hourlyCost;
	}

	public Asset[] getCorporateAssets(AccessRequest accessRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	public Credential[] authenticates() {
		// TODO Auto-generated method stub
		return null;
	}

	public void enrollsUserInCompanyInformationSystem(SimUser user1) {
		// TODO Auto-generated method stub
		
	}

	public void installs(EventProcessor s2EventCorrelator) {
		// TODO Auto-generated method stub
		
	}

	public void installs(RealTimeRiskTrustAnalysisEngine s2Rt2ae) {
		// TODO Auto-generated method stub
		
	}

	public boolean hasCsoConfiguredAssets(RealTimeRiskTrustAnalysisEngine s2Rt2ae) {

		return s2Rt2ae.hasAssets();
	}

	public Asset addsNewAssetToRt2ae(RealTimeRiskTrustAnalysisEngine rt2ae,
			Asset asset) {
		rt2ae.addAsset(asset);
		return asset;
	}

	public boolean checksIfDeviceIsTrustworthyEnough() {
		// TODO Auto-generated method stub
		return false;
	}

	public void logNewDevice(UserDevice user1Laptop) {
		// TODO Auto-generated method stub
		
	}

	public void setRiskPolicy(RiskPolicy riskPolicy) {
		// TODO Auto-generated method stub
		
	}
	
	public static AccessRequest requestsAccessToAsset(Asset requestedAssestByUser) {
		AccessRequest accessRequest = new AccessRequest(requestedAssestByUser);
		return accessRequest;
	}

	public boolean acceptsToRefineOpportunity() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public OpportunityDescriptor refinesOpportunity() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean appliesSuccessfullyRiskTreatment(RiskTreatment riskTreatment) {
		// TODO Auto-generated method stub
		return false;
	}

	public void isInformedOfSuccessfullyAppliedRiskTreatment(RiskTreatment riskTreatment) {
		// TODO Auto-generated method stub
		
	}

	public boolean decidesNotAccessingAssetDueToRisk() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean successfullyUseCorporateAssetsGivenTheSpecifiedOpportunity(OpportunityDescriptor opportunityDescriptor) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isStillMakingRequest(AccessRequest accessRequest) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean givesUpRequestDueToRisk(AccessRequest accessRequest) {
		// TODO Auto-generated method stub
		return false;
	}

	public void setStillMakingRequest(AccessRequest accessRequest, boolean b) {
		// TODO Auto-generated method stub
		
	}

	public RiskPolicy configureRiskPolicy() {
		// TODO Auto-generated method stub
		return null;
	}

	public void installsOnServer(MusesServerApp s2MusesServerApp) {
		// TODO Auto-generated method stub
		
	}

	public RiskPolicy configureRiskPolicy(RiskValue riskValue) {
		// TODO Auto-generated method stub
		return null;
	}

	public MusesClientApp configureMusesClientApp(MusesServerApp musesServerApp) {
		// TODO Auto-generated method stub
		return new MusesClientApp();
	}

	public EventProcessor configureEventCorrelator() {
		// TODO Auto-generated method stub
		return new EventProcessor();
	}

	public RealTimeRiskTrustAnalysisEngine configureRt2ae(
			EventProcessor eventProcessor, RiskPolicy riskPolicy) {
		
		// TODO Auto-generated method stub
		return new RealTimeRiskTrustAnalysisEngine(eventProcessor, riskPolicy);
	}

	public MusesServerApp configureMusesServerApp(
			RealTimeRiskTrustAnalysisEngine rt2ae) {
		// TODO Auto-generated method stub
		return new MusesServerApp(rt2ae);
	}

	public String typePassword() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean authenticateWihMusesCredentials(String userLogin,
			String password) {
		// TODO Auto-generated method stub
		return true;
	}

	public void isInformedOfUnsuccessfullRiskTreatmentApplication() {
		// TODO Auto-generated method stub
		
	}

}
