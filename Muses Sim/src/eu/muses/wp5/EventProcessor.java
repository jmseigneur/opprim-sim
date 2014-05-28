package eu.muses.wp5;

import java.security.Certificate;
import java.util.Collection;

import eu.muses.sim.Outcome;
import eu.muses.sim.request.AccessRequest;
import eu.muses.sim.riskman.Probability;
import eu.muses.sim.riskman.RiskTreatment;
import eu.muses.sim.riskman.SecurityIncident;
import eu.muses.sim.riskman.asset.Asset;
import eu.muses.sim.riskman.asset.MusesCertificateRequest;
import eu.muses.sim.riskman.asset.UserDevice;
import eu.muses.sim.riskman.threat.Threat;
import eu.muses.sim.riskman.vulnerability.Vulnerability;
import eu.muses.sim.sim.SimUser;
import eu.muses.sim.trustman.TrustValue;
       
public class EventProcessor {

	public Collection<Vulnerability> getVulnerabilities(Asset materialForPatentProposal) {
		// TODO Auto-generated method stub
		return null;
	}

	public void reportsSecurityIncident(SecurityIncident securityIncident) {
		// TODO Auto-generated method stub
		
	}

	public double seemsUserInvolvedInSecurityIncident(SimUser user1) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void logsAccessRequestUserDecisionInMusesCompanyInstance() {
		// TODO Auto-generated method stub
		
	}

	public void logsPositiveOutcomeBasedOnTheAchievedOpportunity(
			AccessRequest accessRequest) {
		// TODO Auto-generated method stub
		
	}

	public Threat[] getThreats(Asset asset, TrustValue userTrustValue) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Clue[] getClues(Asset asset) {
		// TODO Auto-generated method stub
		return null;
	}

	public void logsNegativeOutcomeBasedOnTheNonAchievedOpportunity(
			AccessRequest accessRequest) {
		// TODO Auto-generated method stub
		
	}

	public void logsUserUsesAssetInMusesCompanyInstance() {
		// TODO Auto-generated method stub
		
	}

	public void logsSuccessfullyAppliedRiskTreatment(RiskTreatment riskTreatment) {
		// TODO Auto-generated method stub
		
	}

	public Probability computeOutcomeProbability(Outcome outcome, TrustValue userTrustValue) {
		// TODO Auto-generated method stub
		return null;
	}

	public Certificate logNewDevice(String cryptoId, Object owner,
			MusesCertificateRequest certificateSignatureRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	public void logDeniedRequest(AccessRequest accessRequest) {
		// TODO Auto-generated method stub
		
	}

}
