package eu.muses.sim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import eu.muses.wp5.Clue;
import eu.muses.wp5.CluesThreatEntry;
import eu.muses.wp5.CluesThreatTable;
import eu.muses.sim.decision.Decision;
import eu.muses.sim.request.AccessRequest;
import eu.muses.sim.riskman.Probability;
import eu.muses.sim.riskman.RiskEvent;
import eu.muses.sim.riskman.RiskPolicy;
import eu.muses.sim.riskman.SecurityIncident;
import eu.muses.sim.riskman.asset.Asset;
import eu.muses.sim.riskman.opportunity.Opportunity;
import eu.muses.sim.riskman.threat.Threat;
import eu.muses.sim.sim.SimUser;
import eu.muses.sim.trustman.TrustValue;
import eu.muses.wp5.EventProcessor;

public class RealTimeRiskTrustAnalysisEngine {
	
	private EventProcessor eventProcessor;
	private CluesThreatTable cluesThreatTable;
	private RiskPolicy riskPolicy;

	public RealTimeRiskTrustAnalysisEngine(EventProcessor eventProcessor, RiskPolicy riskPolicy) {
		super();
		this.eventProcessor = eventProcessor;
	}
	
	public Probability callEventCorrelatorForProbability(Outcome outcome, TrustValue userTrustValue) {
		return null;
		//TODO implement link to event correlator call for probability
	}

	public void warnsUserResponsibleForSecurityIncident(SimUser user,
			SecurityIncident securityIncidentOnPatent) {
		// TODO Auto-generated method stub
		
	}

	public void decreasesTrustInUser(SimUser user,
			SecurityIncident securityIncidentOnPatent) {
		// TODO Auto-generated method stub
		
	}

	public TrustValue getTrustValue(SimUser user1) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean hasCsoConfiguredAssets() {
		// TODO Auto-generated method stub
		return false;
	}

	public Asset getAsset(String assetName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void initCluesThreatTable() {
		
		try{
		Collection<CluesThreatEntry> entries = new Vector<CluesThreatEntry>();
		
		entries.add(new CluesThreatEntry(Arrays.asList(Clue.antivirusClue, Clue.firewallClue), new Threat("Threat1", null, null)));
		entries.add(new CluesThreatEntry(Arrays.asList(Clue.firewallClue), new Threat("Threat2", null, null)));
		entries.add(new CluesThreatEntry(Arrays.asList(Clue.vpnClue, Clue.antivirusClue), new Threat("Threat3", null, null)));
		cluesThreatTable = new CluesThreatTable(entries);
		
		}catch (Exception e){
			
			e.printStackTrace();
			
		}
	}

	public Decision decidesBasedOnConfiguredRiskPolicy(AccessRequest accessRequest) {
		
		Collection<Asset> requestedAssests = accessRequest.getRequestedCorporateAsset();
		Collection<Outcome> userSpecifiedOutcomes = new Vector<Outcome>(); //TODO infer opportunities without user intervention
		
		OpportunityDescriptor opportunityDescriptor = accessRequest.getOpportunityDescriptor(); 
		if (opportunityDescriptor != null) {
			opportunityDescriptor.addRequestedAsset(null);//TODO change for real assets
			requestedAssests = opportunityDescriptor.getRequestedAssets();
			userSpecifiedOutcomes = opportunityDescriptor.getOutcomes();
		}
		
		List<Clue> clues = new ArrayList<Clue>();
		
		for (Asset asset : requestedAssests) {
			//currentThreats = eventProcessor.getThreats(asset, this.getTrustValue(accessRequest.getUser()));
			clues = eventProcessor.getClues(asset);
		} 
		
		
		List<Threat> currentThreats = new ArrayList<Threat>();
		currentThreats = cluesThreatTable.getThreatsFromClues(clues);
		
		Collection<Probability> outcomesProbabilites = new Vector<Probability>();
		
		for (Outcome outcome : userSpecifiedOutcomes) {
			outcomesProbabilites.add(eventProcessor.computeOutcomeProbability(outcome, this.getTrustValue(accessRequest.getUser())));
		}
		
		Vector<RiskEvent> riskEvents = new Vector<RiskEvent>();
		
		if (userSpecifiedOutcomes.isEmpty()) {
			Opportunity opportunity = new Opportunity(opportunityDescriptor.getDescription(), computeOverallProbability(outcomesProbabilites), userSpecifiedOutcomes); 
			riskEvents.add(opportunity);
		}
		
		for (RiskEvent riskEvent : currentThreats) {
			riskEvents.add(riskEvent);
		}
		
		return decide(riskEvents.toArray(new RiskEvent[0]), riskPolicy);
		
//		double denyBestCaseCostBenefit = lostBid.getCostBenefit() + lostTwoHoursWorkOfUser1.getCostBenefit() + newPatentProposalIsNotInvalidated.getCostBenefit();
//		double denyWorstCaseCostBenefit = lostBid.getCostBenefit() + lostTwoHoursWorkOfUser1.getCostBenefit();
//		double allowWorstCaseCostBenefit = gainedTwoHoursWorkOfUser1.getCostBenefit() + materialForPatentProposalIsStolen.getCostBenefit();
//		double allowMiddleCaseCostBenefit = gainedTwoHoursWorkOfUser1.getCostBenefit() + gainedSubmittedBid.getCostBenefit() + materialForPatentProposalIsStolen.getCostBenefit();
//		double allowBestCaseCostBenefit = gainedTwoHoursWorkOfUser1.getCostBenefit() + gainedSubmittedBid.getCostBenefit();
//		double allowBestBestCaseCostBenefit = gainedTwoHoursWorkOfUser1.getCostBenefit() + gainedSubmittedBid.getCostBenefit() + newPatentProposalIsNotInvalidated.getCostBenefit();
		
//		Probability denyBestCaseProbability = lostBid. + lostTwoHoursWorkOfUser1.getCostBenefit() + newPatentProposalIsNotInvalidated.getCostBenefit();
		//		Probability denyWorstCaseCostProbability = lostBid.getCostBenefit() + lostTwoHoursWorkOfUser1.getCostBenefit();
		//Probability allowWorstCaseProbability = gainedTwoHoursWorkOfUser1.getCostBenefit() + materialForPatentProposalIsStolen.getCostBenefit();
		//Probability allowMiddleCaseProbabiliyt = gainedTwoHoursWorkOfUser1.getCostBenefit() + gainedSubmittedBid.getCostBenefit() + materialForPatentProposalIsStolen.getCostBenefit();
		//Probability allowBestCaseProbability = gainedTwoHoursWorkOfUser1.getCostBenefit() + gainedSubmittedBid.getCostBenefit();
		//Probability allowBestBestCaseProbability = gainedTwoHoursWorkOfUser1.getCostBenefit() + gainedSubmittedBid.getCostBenefit() + newPatentProposalIsNotInvalidated.getCostBenefit();		
	}

	public void decreasesTrustInUser(SimUser user1,
			OpportunityDescriptor opportunityDescriptor) {
		// TODO Auto-generated method stub
		
	}

	public void updatesTrustInUserGivenPositiveOutcome(SimUser user1,
			OpportunityDescriptor opportunityDescriptor) {
		// TODO Auto-generated method stub
		
	}

	public void updatesTrustInUserGivenNegativeOutcome(SimUser user1,
			OpportunityDescriptor opportunityDescriptor) {
		// TODO Auto-generated method stub
		
	}
	
	private Probability computeOverallProbability(Collection<Probability> probabilites) {
		//TODO implement computing probability of multiple probabilities
		return null;
	}
	
	private Decision decide(RiskEvent[] riskEvents, RiskPolicy riskPolicy) {
		//TODO implement risk events risk policies
		return Decision.MAYBE_ACCESS;
	}

	public void updateTrustValue() {
		// TODO Auto-generated method stub
		
	}

}
