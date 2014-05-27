package eu.muses.sim.corporate;

import eu.muses.sim.Outcome;
import eu.muses.sim.RealTimeRiskTrustAnalysisEngine;
import eu.muses.sim.decision.DecisionManager;
import eu.muses.sim.request.AccessRequest;
import eu.muses.sim.riskman.SecurityIncident;
import eu.muses.sim.riskman.asset.UserDevice;
import eu.muses.sim.sim.SimUser;
import eu.muses.sim.trustman.TrustValue;
import eu.muses.wp5.EventProcessor;

public class Corporation {

	private DecisionManager decisionManager = new DecisionManager();

	public void reportsSecurityIncident(Outcome securityIncidentOnPatent) {
		// TODO Auto-generated method stub
		
	}

	public double seemsUserInvolvedInSecurityIncident(SimUser alice) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void warnsUserResponsibleForSecurityIncident(SimUser alice,
			Outcome securityIncidentOnPatent) {
		// TODO Auto-generated method stub
		
	}

	public void decreasesTrustInUser(SimUser alice,
			Outcome securityIncidentOnPatent) {
		// TODO Auto-generated method stub
		
	}

	public void computeCorporateAccessRequestRisk(AccessRequest accessRequest) {
		
		
		
	}

	public void computeCorporateAccessRequestThreats(AccessRequest accessRequest) {
		// TODO Auto-generated method stub
		
	}

	public void computeCorporateAccessRequestOpportunity(AccessRequest accessRequest) {
		// TODO Auto-generated method stub
		
	}

	public void installs(RealTimeRiskTrustAnalysisEngine rt2ae) {
		// TODO Auto-generated method stub
		
	}

	public void computeCorporateAccessRequestTrust(AccessRequest accessRequest) {
		// TODO Auto-generated method stub
		
	}

	public void computeCorporateAccessRequestDecision(
			AccessRequest accessRequest) {
		// TODO Auto-generated method stub
		
	}

	public void logsBeneficialOutcomeBasedOnTheAchievedOpportunity(
			AccessRequest accessRequest) {
		// TODO Auto-generated method stub
		
	}

	public void logsAccessRequestUserDecisionInMusesCompanyInstance() {
		// TODO Auto-generated method stub
		
	}

	public void generateCorporateAccessRequestRiskTreatmentsAndTrustRiskCommunication(
			AccessRequest accessRequest) {
		// TODO Auto-generated method stub
		
	}

	public TrustValue getTrustValue(SimUser user) {
		// TODO Auto-generated method stub
		return null;
	}

	public void installs(EventProcessor eventProcessor) {
		// TODO Auto-generated method stub
		
	}

	public void enrollsUserInCompanyInformationSystem(SimUser user) {
		// TODO Auto-generated method stub
		
	}

	public boolean checksIfDeviceIsTrustworthyEnough() {
		// TODO Auto-generated method stub
		return false;
	}

	public void logsNewDevice(UserDevice newDevice) {
		// TODO Auto-generated method stub
		
	}

	public void setCso(SimUser userCSO) {
		// TODO Auto-generated method stub
		
	}
	
}
