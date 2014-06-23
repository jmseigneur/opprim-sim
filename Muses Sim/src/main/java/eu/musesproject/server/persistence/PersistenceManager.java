package eu.musesproject.server.persistence;

import java.util.List;

import eu.musesproject.server.rt2ae.Asset;
import eu.musesproject.server.rt2ae.Clue;
import eu.musesproject.server.rt2ae.Opportunity;
import eu.musesproject.server.rt2ae.Outcome;
import eu.musesproject.server.rt2ae.RiskPolicy;
import eu.musesproject.server.rt2ae.Threat;



public abstract class PersistenceManager {

	public PersistenceManager() {
		// TODO Auto-generated constructor stub
		super();
	}

	/**
	 * @return the outcomes
	 */
	public abstract List<Outcome> getOutcomes();

	/**
	 * @param outcomes
	 *            the outcomes to set
	 */
	public abstract void setOutcomes(List<Outcome> outcomes);

	/**
	 * @return the opportunities
	 */
	public abstract List<Opportunity> getOpportunities();

	/**
	 * @param opportunities
	 *            the opportunities to set
	 */
	public abstract void setOpportunities(List<Opportunity> opportunities);

	/**
	 * @return the assets
	 */
	public abstract List<Asset> getAssets();

	/**
	 * @param assets
	 *            the assets to set
	 */
	public abstract void setAssets(List<Asset> assets);

	/**
	 * @return the threats
	 */
	public abstract List<Threat> getThreats();

	/**
	 * @param threats
	 *            the threats to set
	 */
	public abstract void setThreats(List<Threat> threats);

	/**
	 * @return the clues
	 */
	public abstract List<Clue> getClues();

	/**
	 * @param clues
	 *            the clues to set
	 */
	public abstract void setClues(List<Clue> clues);

	/**
	 * @return the riskPolicies
	 */
	public abstract List<RiskPolicy> getRiskPolicies();

	/**
	 * @param riskPolicies
	 *            the riskPolicies to set
	 */
	public abstract void setRiskPolicies(List<RiskPolicy> riskPolicies);

	/**
	 * @return the simUsers
	 */
	public abstract List<SimUser> getSimUsers();

	/**
	 * @param simUsers
	 *            the simUsers to set
	 */
	public abstract void setSimUsers(List<SimUser> simUsers);

	/**
	 * @return the cluesThreatTable
	 */
	//public abstract CluesThreatTable getCluesThreatTable();

	/**
	 * @param cluesThreatTable
	 *            the cluesThreatTable to set
	 */
	//public abstract void setCluesThreatTable(CluesThreatTable cluesThreatTable);

}
