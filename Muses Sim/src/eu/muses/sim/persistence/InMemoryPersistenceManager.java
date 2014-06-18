package eu.muses.sim.persistence;

import java.util.ArrayList;
import java.util.List;

import eu.muses.sim.Outcome;
import eu.muses.sim.request.AccessRequest;
import eu.muses.sim.riskman.RiskPolicy;
import eu.muses.sim.riskman.asset.Asset;
import eu.muses.sim.riskman.opportunity.Opportunity;
import eu.muses.sim.riskman.threat.Threat;
import eu.muses.sim.test.SimUser;
import eu.muses.wp5.Clue;
import eu.muses.wp5.CluesThreatTable;

public class InMemoryPersistenceManager extends PersistenceManager {

	/** The outcomes */
	private List<Outcome> outcomes = new ArrayList<Outcome>();

	/** The opportunities */
	private List<Opportunity> opportunities = new ArrayList<Opportunity>();

	/** The assets */
	private List<Asset> assets = new ArrayList<Asset>();

	/** The threats */
	private List<Threat> threats = new ArrayList<Threat>();

	/** The clues */
	private List<Clue> clues = new ArrayList<Clue>();

	/** The risk Policies */
	private List<RiskPolicy> riskPolicies = new ArrayList<RiskPolicy>();

	/** The Sim Users */
	private List<SimUser> simUsers = new ArrayList<SimUser>();

	/** The clues threat table. */
	private CluesThreatTable cluesThreatTable = new CluesThreatTable();
	
	/** The access requests */
	private List<AccessRequest> accessRequests = new ArrayList<AccessRequest>();

	public InMemoryPersistenceManager() {
		super();
	}

	@Override
	/**
	 * @return the outcomes
	 */
	public List<Outcome> getOutcomes() {
		return outcomes;
	}

	@Override
	/**
	 * @param outcomes
	 *            the outcomes to set
	 */
	public void setOutcomes(List<Outcome> outcomes) {
		this.outcomes = outcomes;
	}

	@Override
	/**
	 * @return the opportunities
	 */
	public List<Opportunity> getOpportunities() {
		return opportunities;
	}

	@Override
	/**
	 * @param opportunities
	 *            the opportunities to set
	 */
	public void setOpportunities(List<Opportunity> opportunities) {
		this.opportunities = opportunities;
	}

	@Override
	/**
	 * @return the assets
	 */
	public List<Asset> getAssets() {
		return assets;
	}

	@Override
	/**
	 * @param assets
	 *            the assets to set
	 */
	public void setAssets(List<Asset> assets) {
		this.assets = assets;
	}

	@Override
	/**
	 * @return the threats
	 */
	public List<Threat> getThreats() {
		return threats;
	}

	@Override
	/**
	 * @param threats
	 *            the threats to set
	 */
	public void setThreats(List<Threat> threats) {
		this.threats = threats;
	}

	@Override
	/**
	 * @return the clues
	 */
	public List<Clue> getClues() {
		return clues;
	}

	@Override
	/**
	 * @param clues
	 *            the clues to set
	 */
	public void setClues(List<Clue> clues) {
		this.clues = clues;
	}

	@Override
	/**
	 * @return the riskPolicies
	 */
	public List<RiskPolicy> getRiskPolicies() {
		return riskPolicies;
	}

	@Override
	/**
	 * @param riskPolicies
	 *            the riskPolicies to set
	 */
	public void setRiskPolicies(List<RiskPolicy> riskPolicies) {
		this.riskPolicies = riskPolicies;
	}

	@Override
	/**
	 * @return the simUsers
	 */
	public List<SimUser> getSimUsers() {
		return simUsers;
	}

	@Override
	/**
	 * @param simUsers
	 *            the simUsers to set
	 */
	public void setSimUsers(List<SimUser> simUsers) {
		this.simUsers = simUsers;
	}

	@Override
	/**
	 * @return the cluesThreatTable
	 */
	public CluesThreatTable getCluesThreatTable() {
		return cluesThreatTable;
	}

	@Override
	/**
	 * @param cluesThreatTable
	 *            the cluesThreatTable to set
	 */
	public void setCluesThreatTable(CluesThreatTable cluesThreatTable) {
		this.cluesThreatTable = cluesThreatTable;
	}

	@Override
	/**
	 * @return the accessRequests
	 */
	public List<AccessRequest> getAccessRequests(){
		return accessRequests;
	}

	@Override
	/**
	 * @param accessRequests
	 *            the accessRequests to set
	 */
	public void setAccessRequests(List<AccessRequest> accessRequests){
		this.accessRequests = accessRequests;
	}

}
