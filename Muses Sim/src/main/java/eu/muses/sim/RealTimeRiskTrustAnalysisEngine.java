/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 * Test branch Xavier
 */
package eu.muses.sim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import eu.muses.sim.decision.Decision;
import eu.muses.sim.gui.GuiMain;
import eu.muses.sim.request.AccessRequest;
import eu.muses.sim.riskman.Probability;
import eu.muses.sim.riskman.RiskEvent;
import eu.muses.sim.riskman.RiskPolicy;
import eu.muses.sim.riskman.SecurityIncident;
import eu.muses.sim.riskman.asset.Asset;
import eu.muses.sim.riskman.opportunity.Opportunity;
import eu.muses.sim.riskman.threat.Threat;
import eu.muses.sim.test.SimUser;
import eu.muses.sim.trustman.TrustValue;
import eu.muses.wp5.Clue;
import eu.muses.wp5.CluesThreatEntry;
import eu.muses.wp5.CluesThreatTable;
import eu.muses.wp5.EventProcessor;

/**
 * The Class RealTimeRiskTrustAnalysisEngine.
 */
public class RealTimeRiskTrustAnalysisEngine {

	/** The event processor */
	private static EventProcessor eventProcessor;

	/** The risk policy. */
	private RiskPolicy riskPolicy;

	/** The asset list. */
	private List<Asset> assetList = new ArrayList<Asset>();

	/**
	 * Instantiates a new real time risk trust analysis engine.
	 * 
	 * @param eventProcessor
	 *            the event processor
	 * @param riskPolicy
	 *            the risk policy
	 */
	public RealTimeRiskTrustAnalysisEngine(EventProcessor eventPr,
			RiskPolicy riskPolicy) {
		super();
		this.riskPolicy = riskPolicy;
		eventProcessor = eventPr;
	}

	/**
	 * Adds the asset.
	 * 
	 * @param asset
	 *            the asset
	 */
	public void addAsset(Asset asset) {

		this.assetList.add(asset);

	}

	private Probability computeOpportunityOutcomeProbability(
			TrustValue trustValue, String string, List<Threat> currentThreats) {
		// TODO Auto-generated method stub
		return new Probability(trustValue.getValue());
	}

	/**
	 * Compute outcome probability.
	 * 
	 * @param outcome
	 *            the outcome
	 * @param userTrustValue
	 *            the user trust value
	 * @param threats
	 *            the threats
	 * @return the probability
	 */
	public Probability computeThreatOutcomeProbability(Outcome outcome,
			TrustValue userTrustValue, Threat[] threats) {
		// TODO Auto-generated method stub
		return new Probability(userTrustValue.getValue());
	}

	/**
	 * Decide.
	 * 
	 * @param riskEvents
	 *            the risk events
	 * @param riskPolicy
	 *            the risk policy
	 * @return the decision
	 */
	private Decision decide(RiskEvent[] riskEvents, RiskPolicy riskPolicy) {

		double costOpportunity = 0.0;
		double combinedProbabilityThreats = 1.0;
		double combinedProbabilityOpportunities = 1.0;
		double singleThreatProbabibility = 0.0;
		double singleOpportunityProbability = 0.0;
		int opcount = 0;
		int threatcount = 0;

		for (RiskEvent riskEvent : riskEvents) {

			costOpportunity += riskEvent.getOutcomes().iterator().next()
					.getCostBenefit();

			if (riskEvent.getOutcomes().iterator().next().getCostBenefit() < 0) {
				System.out.println("This is a threat");
				combinedProbabilityThreats = combinedProbabilityThreats
						* riskEvent.getProbability().getProb();
				singleThreatProbabibility = singleThreatProbabibility
						+ riskEvent.getProbability().getProb();
				threatcount++;
			} else {
				System.out.println("This is an opportunity");
				combinedProbabilityOpportunities = combinedProbabilityOpportunities
						* riskEvent.getProbability().getProb();
				singleOpportunityProbability = singleOpportunityProbability
						+ riskEvent.getProbability().getProb();
				opcount++;
			}
		}

		if (threatcount > 1)
			singleThreatProbabibility = singleThreatProbabibility
					- combinedProbabilityThreats;
		if (opcount > 1)
			singleOpportunityProbability = singleOpportunityProbability
					- combinedProbabilityOpportunities;

		System.out.println("Decission data is: ");
		System.out.println("- Risk Policy threshold: "
				+ riskPolicy.getRiskValue().getValue());
		System.out.println("- Cost Oportunity: " + costOpportunity);
		System.out
				.println("- Combined Probability of the all possible Threats happening together: "
						+ combinedProbabilityThreats);
		System.out
				.println("- Combined Probability of the all the possible Opportunities happening together: "
						+ combinedProbabilityOpportunities);
		System.out
				.println("- Combined Probability of only one of the possible Threats happening: "
						+ singleThreatProbabibility);
		System.out
				.println("- Combined Probability of only one of the possible Opportunities happening: "
						+ singleOpportunityProbability);

		System.out.println("Making a decision...");
		System.out.println(".");
		System.out.println("..");
		System.out.println("...");

		if (costOpportunity > 0 || riskPolicy == RiskPolicy.TAKE_FULL_RISK) {
			return Decision.ALLOW_ACCESS;
		}
		if (riskPolicy == RiskPolicy.TAKE_NO_RISK && costOpportunity < 0) {
			return Decision.STRONG_DENY_ACCESS;
		}
		if (riskPolicy == RiskPolicy.TAKE_MEDIUM_RISK) {
			if (combinedProbabilityThreats <= riskPolicy.getRiskValue()
							.getValue()) {
				return Decision.ALLOW_ACCESS;
			} else {
				return Decision.STRONG_DENY_ACCESS;
			}
		}
		if (riskPolicy == RiskPolicy.TAKE_CORPORATE_RISK) {
			if (costOpportunity < 0
					&& combinedProbabilityThreats < riskPolicy.getRiskValue()
							.getValue()) {
				return Decision.ALLOW_ACCESS;
			} else {
				return Decision.MAYBE_ACCESS;
			}
		}
		return Decision.MAYBE_ACCESS;
	}

	/**
	 * Decides based on configured risk policy.
	 * 
	 * @param accessRequest
	 *            the access request
	 * @return the decision
	 */
	public Decision decidesBasedOnConfiguredRiskPolicy(
			AccessRequest accessRequest) {

		Collection<Asset> requestedAssests = accessRequest
				.getRequestedCorporateAsset();
		// TODO infer opportunities without user
		// intervention

		OpportunityDescriptor opportunityDescriptor = accessRequest
				.getOpportunityDescriptor();
		if (opportunityDescriptor != null) {
			// opportunityDescriptor.addRequestedAsset(null);//TODO change for
			// real assets
			requestedAssests = opportunityDescriptor.getRequestedAssets();
		}

		List<Clue> clues = new ArrayList<Clue>();

		for (Asset asset : requestedAssests) {
			// currentThreats = eventProcessor.getThreats(asset,
			// this.getTrustValue(accessRequest.getUser()));
			clues = eventProcessor.getClues(asset);
			clues.add(new Clue(accessRequest.getUser().getNickname()));
			clues.add(new Clue(asset.getAssetName()));
			for (Clue clue : clues) {
				System.out.println("The clue associated with Asset "
						+ asset.getAssetName() + " is " + clue.getId() + "\n");
			}
		}

		List<Threat> currentThreats = new ArrayList<Threat>();
		String threatName = "";
		for (Clue clue : clues) {
			threatName = threatName + clue.getId().substring(0, 1);
		}
		threatName = threatName.substring(0, threatName.length() - 2)
				+ accessRequest.getUser().getNickname()
				+ requestedAssests.iterator().next().getAssetName();
		Threat threat = new Threat("Threat" + threatName, new Probability(0.5),
				new Outcome("Compromised Asset", -requestedAssests.iterator()
						.next().getValue()));
		boolean exists = false;
		List<Threat> dbThreats = GuiMain.getPersistenceManager().getThreats();
		Threat existingThreat = new Threat();
		for (Threat threat2 : dbThreats) {
			if (threat2.getDescription().equalsIgnoreCase(
					threat.getDescription())) {
				exists = true;
				existingThreat = threat2;
			}
		}
		/*
		 * CluesThreatTable tab =
		 * GuiMain.getPersistenceManager().getCluesThreatTable(); currentThreats
		 * = tab.getThreatsFromClues(clues);
		 */
		if (!exists) {

			/*
			 * CluesThreatTable table = GuiMain.getPersistenceManager()
			 * .getCluesThreatTable(); table.addMapping(clues, threat);
			 * table.updateThreatOccurences(threat);
			 * GuiMain.getPersistenceManager().setCluesThreatTable(table);
			 */
			threat.setOccurences(threat.getOccurences() + 1);
			currentThreats.add(threat);
			GuiMain.getPersistenceManager().setThreats(currentThreats);
			System.out.println("The newly created Threat from the Clues is: "
					+ threat.getDescription() + " with probability "
					+ threat.getProbabilityValue()
					+ " for the following outcome: \""
					+ threat.getOutcomes().iterator().next().getDescription()
					+ "\" with the following potential cost (in kEUR): "
					+ threat.getOutcomes().iterator().next().getCostBenefit()
					+ "\n");
			accessRequest.setCluesThreatEntry(new CluesThreatEntry(clues,
					threat));
			Calendar now = Calendar.getInstance();
			accessRequest.setTime(now);
			GuiMain.getPersistenceManager().setAccessRequests(
					new ArrayList<AccessRequest>(Arrays.asList(accessRequest)));
		} else {
			// for (Threat threat : currentThreats) {
			System.out.println("Occurences: " + existingThreat.getOccurences());
			existingThreat.setOccurences(existingThreat.getOccurences() + 1);
			currentThreats.add(existingThreat);
			System.out.println("Occurences: " + existingThreat.getOccurences());
			/*
			 * CluesThreatTable table = GuiMain.getPersistenceManager()
			 * .getCluesThreatTable(); table.updateThreatOccurences(threat);
			 * GuiMain.getPersistenceManager().setCluesThreatTable(table);
			 */
			GuiMain.getPersistenceManager().setThreats(currentThreats);
			System.out.println("The inferred Threat from the Clues is: "
					+ threat.getDescription() + " with probability "
					+ threat.getProbabilityValue()
					+ " for the following outcome: \""
					+ threat.getOutcomes().iterator().next().getDescription()
					+ "\" with the following potential cost (in kEUR): "
					+ threat.getOutcomes().iterator().next().getCostBenefit()
					+ "\n");
			accessRequest.setCluesThreatEntry(new CluesThreatEntry(clues,
					currentThreats.get(0)));
			Calendar now = Calendar.getInstance();
			accessRequest.setTime(now);
			GuiMain.getPersistenceManager().setAccessRequests(
					new ArrayList<AccessRequest>(Arrays.asList(accessRequest)));
		}
		Vector<RiskEvent> riskEvents = new Vector<RiskEvent>();

		for (RiskEvent riskEvent : currentThreats) {
			riskEvents.add(riskEvent);
		}

		if (opportunityDescriptor != null) {

			System.out
					.println("There is an oportunity descriptor associated with this action: \""
							+ opportunityDescriptor.getDescription()
							+ "\" with the following possible outcome: "
							+ opportunityDescriptor.getOutcomes().iterator()
									.next().getDescription()
							+ " which can yield the following benefit (in kEUR): "
							+ opportunityDescriptor.getOutcomes().iterator()
									.next().getCostBenefit() + "\n");

			Opportunity opportunity = new Opportunity(
					opportunityDescriptor.getDescription(),
					computeOpportunityOutcomeProbability(
							getTrustValue(accessRequest.getUser()),
							opportunityDescriptor.getDescription(),
							currentThreats),
					opportunityDescriptor.getOutcomes());
			riskEvents.add(opportunity);
		}

		return decide(riskEvents.toArray(new RiskEvent[0]), this.riskPolicy);

		// double denyBestCaseCostBenefit = lostBid.getCostBenefit() +
		// lostTwoHoursWorkOfUser1.getCostBenefit() +
		// newPatentProposalIsNotInvalidated.getCostBenefit();
		// double denyWorstCaseCostBenefit = lostBid.getCostBenefit() +
		// lostTwoHoursWorkOfUser1.getCostBenefit();
		// double allowWorstCaseCostBenefit =
		// gainedTwoHoursWorkOfUser1.getCostBenefit() +
		// materialForPatentProposalIsStolen.getCostBenefit();
		// double allowMiddleCaseCostBenefit =
		// gainedTwoHoursWorkOfUser1.getCostBenefit() +
		// gainedSubmittedBid.getCostBenefit() +
		// materialForPatentProposalIsStolen.getCostBenefit();
		// double allowBestCaseCostBenefit =
		// gainedTwoHoursWorkOfUser1.getCostBenefit() +
		// gainedSubmittedBid.getCostBenefit();
		// double allowBestBestCaseCostBenefit =
		// gainedTwoHoursWorkOfUser1.getCostBenefit() +
		// gainedSubmittedBid.getCostBenefit() +
		// newPatentProposalIsNotInvalidated.getCostBenefit();

		// Probability denyBestCaseProbability = lostBid. +
		// lostTwoHoursWorkOfUser1.getCostBenefit() +
		// newPatentProposalIsNotInvalidated.getCostBenefit();
		// Probability denyWorstCaseCostProbability = lostBid.getCostBenefit() +
		// lostTwoHoursWorkOfUser1.getCostBenefit();
		// Probability allowWorstCaseProbability =
		// gainedTwoHoursWorkOfUser1.getCostBenefit() +
		// materialForPatentProposalIsStolen.getCostBenefit();
		// Probability allowMiddleCaseProbabiliyt =
		// gainedTwoHoursWorkOfUser1.getCostBenefit() +
		// gainedSubmittedBid.getCostBenefit() +
		// materialForPatentProposalIsStolen.getCostBenefit();
		// Probability allowBestCaseProbability =
		// gainedTwoHoursWorkOfUser1.getCostBenefit() +
		// gainedSubmittedBid.getCostBenefit();
		// Probability allowBestBestCaseProbability =
		// gainedTwoHoursWorkOfUser1.getCostBenefit() +
		// gainedSubmittedBid.getCostBenefit() +
		// newPatentProposalIsNotInvalidated.getCostBenefit();
	}

	/**
	 * Decreases trust in user.
	 * 
	 * @param user1
	 *            the user1
	 * @param opportunityDescriptor
	 *            the opportunity descriptor
	 */
	public void decreasesTrustInUser(SimUser user1,
			OpportunityDescriptor opportunityDescriptor) {
		// TODO Auto-generated method stub

	}

	/**
	 * Decreases trust in user.
	 * 
	 * @param user
	 *            the user
	 * @param securityIncidentOnPatent
	 *            the security incident on patent
	 */
	public void decreasesTrustInUser(SimUser user,
			SecurityIncident securityIncidentOnPatent) {
		// TODO Auto-generated method stub

	}

	/**
	 * Gets the asset.
	 * 
	 * @param assetName
	 *            the asset name
	 * @return the asset
	 */
	public Asset getAsset(String assetName) {

		for (Asset asset : this.assetList) {
			if (asset.getAssetName().equalsIgnoreCase(assetName)) {
				return asset;
			}
		}
		return null;
	}

	/**
	 * Gets the trust value.
	 * 
	 * @param user1
	 *            the user1
	 * @return the trust value
	 */
	public TrustValue getTrustValue(SimUser user1) {
		// TODO Auto-generated method stub
		return user1.getTrustValue();
	}

	/**
	 * Checks for assets.
	 * 
	 * @return true, if successful
	 */
	public boolean hasAssets() {
		// TODO Auto-generated method stub
		return !this.assetList.isEmpty();
	}

	/**
	 * Checks for cso configured assets.
	 * 
	 * @return true, if successful
	 */
	public boolean hasCsoConfiguredAssets() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Updates trust in user given negative outcome.
	 * 
	 * @param user1
	 *            the user1
	 * @param opportunityDescriptor
	 *            the opportunity descriptor
	 */
	public void updatesTrustInUserGivenNegativeOutcome(SimUser user1,
			OpportunityDescriptor opportunityDescriptor) {
		// TODO Auto-generated method stub

	}

	/**
	 * Updates trust in user given positive outcome.
	 * 
	 * @param user1
	 *            the user1
	 * @param opportunityDescriptor
	 *            the opportunity descriptor
	 */
	public void updatesTrustInUserGivenPositiveOutcome(SimUser user1,
			OpportunityDescriptor opportunityDescriptor) {
		// TODO Auto-generated method stub

	}

	/**
	 * Update trust value.
	 */
	public void updateTrustValue() {
		// TODO Auto-generated method stub

	}

	/**
	 * Warns user responsible for security incident.
	 * 
	 * @param user
	 *            the user
	 * @param securityIncidentOnPatent
	 *            the security incident on patent
	 */
	public void warnsUserResponsibleForSecurityIncident(SimUser user,
			SecurityIncident securityIncidentOnPatent) {
		// TODO Auto-generated method stub

	}

	public void recalculateThreatProbabilitiesWhenIncident(
			AccessRequest accessRequest) {

		Threat threat = accessRequest
				.getCluesThreatEntry().getThreat();
		threat.setBadOutcomeCount(threat.getBadOutcomeCount() + 1);
		System.out.println("The bad count: " + threat.getBadOutcomeCount() + " the occurences: " + threat.getOccurences());
		double newProbability = threat.getBadOutcomeCount()
				/ threat.getOccurences();
		threat.setProbability(new Probability(newProbability));
		GuiMain.getPersistenceManager().setThreats(new ArrayList<Threat>(Arrays.asList(threat)));
		System.out.println("The new probability associated with the threat \""
				+ threat.getDescription() + "\" is: "
				+ threat.getProbability().getProb());

	}

	public void recalculateThreatProbabilitiesWhenNoIncident(
			AccessRequest accessRequest) {

		Threat threat = accessRequest
				.getCluesThreatEntry().getThreat();
		System.out.println("The bad count: " + threat.getBadOutcomeCount() + " the occurences: " + threat.getOccurences());
		double newProbability = threat.getBadOutcomeCount()
				/ threat.getOccurences();
		threat.setProbability(new Probability(newProbability));
		GuiMain.getPersistenceManager().setThreats(new ArrayList<Threat>(Arrays.asList(threat)));
		System.out.println("The new probability associated with the threat \""
				+ threat.getDescription() + "\" is: "
				+ threat.getProbability().getProb());

	}

	/**
	 * @return the riskPolicy
	 */
	public RiskPolicy getRiskPolicy() {
		return riskPolicy;
	}

	/**
	 * @param riskPolicy
	 *            the riskPolicy to set
	 */
	public void setRiskPolicy(RiskPolicy riskPolicy) {
		this.riskPolicy = riskPolicy;
	}

	/**
	 * @return the assetList
	 */
	public List<Asset> getAssetList() {
		return assetList;
	}

	/**
	 * @param assetList
	 *            the assetList to set
	 */
	public void setAssetList(List<Asset> assetList) {
		this.assetList = assetList;
	}

}
