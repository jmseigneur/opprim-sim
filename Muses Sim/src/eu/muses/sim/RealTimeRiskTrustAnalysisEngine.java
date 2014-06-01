/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.muses.sim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import eu.muses.sim.decision.Decision;
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

    /** The event processor. */
    private EventProcessor eventProcessor;

    /** The clues threat table. */
    private CluesThreatTable cluesThreatTable;

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
    public RealTimeRiskTrustAnalysisEngine(EventProcessor eventProcessor, RiskPolicy riskPolicy) {
        super();
        this.eventProcessor = eventProcessor;
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

    private Probability computeOpportunityOutcomeProbability(TrustValue trustValue, String string,
            List<Threat> currentThreats) {
        // TODO Auto-generated method stub
        return null;
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
    public Probability computeThreatOutcomeProbability(Outcome outcome, TrustValue userTrustValue, Threat[] threats) {
        // TODO Auto-generated method stub
        return null;
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
        // TODO implement risk events risk policies
        return Decision.MAYBE_ACCESS;
    }

    /**
     * Decides based on configured risk policy.
     *
     * @param accessRequest
     *            the access request
     * @return the decision
     */
    public Decision decidesBasedOnConfiguredRiskPolicy(AccessRequest accessRequest) {

        Collection<Asset> requestedAssests = accessRequest.getRequestedCorporateAsset();
        // TODO infer opportunities without user
        // intervention

        OpportunityDescriptor opportunityDescriptor = accessRequest.getOpportunityDescriptor();
        if (opportunityDescriptor != null) {
            // opportunityDescriptor.addRequestedAsset(null);//TODO change for real assets
            requestedAssests = opportunityDescriptor.getRequestedAssets();
        }

        List<Clue> clues = new ArrayList<Clue>();

        for (Asset asset : requestedAssests) {
            // currentThreats = eventProcessor.getThreats(asset, this.getTrustValue(accessRequest.getUser()));
            clues = this.eventProcessor.getClues(asset);
            for (Clue clue : clues) {
                System.out.println("The clue associated with Asset " + asset.getAssetName() + " is " + clue.getId());
            }
        }

        List<Threat> currentThreats = new ArrayList<Threat>();
        currentThreats = this.cluesThreatTable.getThreatsFromClues(clues);
        for (Threat threat : currentThreats) {
            System.out.println("The inferred Threat from the Clues is: "
                    + threat.getDescription()
                    + " with probability "
                    + threat.getProbability());
        }

        Vector<RiskEvent> riskEvents = new Vector<RiskEvent>();

        for (RiskEvent riskEvent : currentThreats) {
            riskEvents.add(riskEvent);
        }

        if (opportunityDescriptor != null) {
            Opportunity opportunity = new Opportunity(opportunityDescriptor.getDescription(),
                    computeOpportunityOutcomeProbability(getTrustValue(accessRequest.getUser()),
                            opportunityDescriptor.getDescription(), currentThreats),
                    opportunityDescriptor.getOutcomes());
            riskEvents.add(opportunity);
        }

        return decide(riskEvents.toArray(new RiskEvent[0]), this.riskPolicy);

        // double denyBestCaseCostBenefit = lostBid.getCostBenefit() + lostTwoHoursWorkOfUser1.getCostBenefit() +
        // newPatentProposalIsNotInvalidated.getCostBenefit();
        // double denyWorstCaseCostBenefit = lostBid.getCostBenefit() + lostTwoHoursWorkOfUser1.getCostBenefit();
        // double allowWorstCaseCostBenefit = gainedTwoHoursWorkOfUser1.getCostBenefit() +
        // materialForPatentProposalIsStolen.getCostBenefit();
        // double allowMiddleCaseCostBenefit = gainedTwoHoursWorkOfUser1.getCostBenefit() +
        // gainedSubmittedBid.getCostBenefit() + materialForPatentProposalIsStolen.getCostBenefit();
        // double allowBestCaseCostBenefit = gainedTwoHoursWorkOfUser1.getCostBenefit() +
        // gainedSubmittedBid.getCostBenefit();
        // double allowBestBestCaseCostBenefit = gainedTwoHoursWorkOfUser1.getCostBenefit() +
        // gainedSubmittedBid.getCostBenefit() + newPatentProposalIsNotInvalidated.getCostBenefit();

        // Probability denyBestCaseProbability = lostBid. + lostTwoHoursWorkOfUser1.getCostBenefit() +
        // newPatentProposalIsNotInvalidated.getCostBenefit();
        // Probability denyWorstCaseCostProbability = lostBid.getCostBenefit() +
        // lostTwoHoursWorkOfUser1.getCostBenefit();
        // Probability allowWorstCaseProbability = gainedTwoHoursWorkOfUser1.getCostBenefit() +
        // materialForPatentProposalIsStolen.getCostBenefit();
        // Probability allowMiddleCaseProbabiliyt = gainedTwoHoursWorkOfUser1.getCostBenefit() +
        // gainedSubmittedBid.getCostBenefit() + materialForPatentProposalIsStolen.getCostBenefit();
        // Probability allowBestCaseProbability = gainedTwoHoursWorkOfUser1.getCostBenefit() +
        // gainedSubmittedBid.getCostBenefit();
        // Probability allowBestBestCaseProbability = gainedTwoHoursWorkOfUser1.getCostBenefit() +
        // gainedSubmittedBid.getCostBenefit() + newPatentProposalIsNotInvalidated.getCostBenefit();
    }

    /**
     * Decreases trust in user.
     *
     * @param user1
     *            the user1
     * @param opportunityDescriptor
     *            the opportunity descriptor
     */
    public void decreasesTrustInUser(SimUser user1, OpportunityDescriptor opportunityDescriptor) {
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
    public void decreasesTrustInUser(SimUser user, SecurityIncident securityIncidentOnPatent) {
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
        return null;
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
     * Inits the clues threat table.
     */
    public void initCluesThreatTable() {

        try {
            Collection<CluesThreatEntry> entries = new Vector<CluesThreatEntry>();

            entries.add(new CluesThreatEntry(Arrays.asList(Clue.antivirusClue, Clue.firewallClue), new Threat(
                    "Threat1", null, null)));
            entries.add(new CluesThreatEntry(Arrays.asList(Clue.firewallClue), new Threat("Threat2", null, null)));
            entries.add(new CluesThreatEntry(Arrays.asList(Clue.vpnClue, Clue.antivirusClue), new Threat("Threat3",
                    null, null)));
            this.cluesThreatTable = new CluesThreatTable(entries);

        }
        catch (Exception e) {

            e.printStackTrace();

        }
    }

    /**
     * Updates trust in user given negative outcome.
     *
     * @param user1
     *            the user1
     * @param opportunityDescriptor
     *            the opportunity descriptor
     */
    public void updatesTrustInUserGivenNegativeOutcome(SimUser user1, OpportunityDescriptor opportunityDescriptor) {
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
    public void updatesTrustInUserGivenPositiveOutcome(SimUser user1, OpportunityDescriptor opportunityDescriptor) {
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
    public void warnsUserResponsibleForSecurityIncident(SimUser user, SecurityIncident securityIncidentOnPatent) {
        // TODO Auto-generated method stub

    }

}
