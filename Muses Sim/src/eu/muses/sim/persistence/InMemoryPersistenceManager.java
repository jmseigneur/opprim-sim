package eu.muses.sim.persistence;

import java.util.ArrayList;
import java.util.List;

import eu.muses.sim.Outcome;
import eu.muses.sim.riskman.RiskPolicy;
import eu.muses.sim.riskman.asset.Asset;
import eu.muses.sim.riskman.opportunity.Opportunity;
import eu.muses.sim.riskman.threat.Threat;
import eu.muses.sim.test.SimUser;
import eu.muses.wp5.Clue;
import eu.muses.wp5.CluesThreatTable;

public class InMemoryPersistenceManager extends PersistenceManager {

	/** The outcomes */
	static List<Outcome> outcomes = new ArrayList<Outcome>();

	/** The opportunities */
	static List<Opportunity> opportunities = new ArrayList<Opportunity>();

	/** The assets */
	static List<Asset> assets = new ArrayList<Asset>();

	/** The threats */
	static List<Threat> threats = new ArrayList<Threat>();

	/** The clues */
	static List<Clue> clues = new ArrayList<Clue>();

	/** The risk Policies */
	static List<RiskPolicy> riskPolicies = new ArrayList<RiskPolicy>();

	/** The Sim Users */
	static List<SimUser> simUsers = new ArrayList<SimUser>();

	/** The clues threat table. */
	private static CluesThreatTable cluesThreatTable = new CluesThreatTable();

	public InMemoryPersistenceManager() {
		super();
	}

	/**
	 * @return the outcomes
	 */
	public static List<Outcome> getOutcomes() {
		return outcomes;
	}

	/**
	 * @param outcomes
	 *            the outcomes to set
	 */
	public static void setOutcomes(List<Outcome> outcomes) {
		InMemoryPersistenceManager.outcomes = outcomes;
	}

	/**
	 * @return the opportunities
	 */
	public static List<Opportunity> getOpportunities() {
		return opportunities;
	}

	/**
	 * @param opportunities
	 *            the opportunities to set
	 */
	public static void setOpportunities(List<Opportunity> opportunities) {
		InMemoryPersistenceManager.opportunities = opportunities;
	}

	/**
	 * @return the assets
	 */
	public static List<Asset> getAssets() {
		return assets;
	}

	/**
	 * @param assets
	 *            the assets to set
	 */
	public static void setAssets(List<Asset> assets) {
		InMemoryPersistenceManager.assets = assets;
	}

	/**
	 * @return the threats
	 */
	public static List<Threat> getThreats() {
		return threats;
	}

	/**
	 * @param threats
	 *            the threats to set
	 */
	public static void setThreats(List<Threat> threats) {
		InMemoryPersistenceManager.threats = threats;
	}

	/**
	 * @return the clues
	 */
	public static List<Clue> getClues() {
		return clues;
	}

	/**
	 * @param clues
	 *            the clues to set
	 */
	public static void setClues(List<Clue> clues) {
		InMemoryPersistenceManager.clues = clues;
	}

	/**
	 * @return the riskPolicies
	 */
	public static List<RiskPolicy> getRiskPolicies() {
		return riskPolicies;
	}

	/**
	 * @param riskPolicies
	 *            the riskPolicies to set
	 */
	public static void setRiskPolicies(List<RiskPolicy> riskPolicies) {
		InMemoryPersistenceManager.riskPolicies = riskPolicies;
	}

	/**
	 * @return the simUsers
	 */
	public static List<SimUser> getSimUsers() {
		return simUsers;
	}

	/**
	 * @param simUsers
	 *            the simUsers to set
	 */
	public static void setSimUsers(List<SimUser> simUsers) {
		InMemoryPersistenceManager.simUsers = simUsers;
	}

	/**
	 * @return the cluesThreatTable
	 */
	public static CluesThreatTable getCluesThreatTable() {
		return cluesThreatTable;
	}

	/**
	 * @param cluesThreatTable
	 *            the cluesThreatTable to set
	 */
	public static void setCluesThreatTable(CluesThreatTable cluesThreatTable) {
		InMemoryPersistenceManager.cluesThreatTable = cluesThreatTable;
	}

}
