package eu.muses.sim.persistence;

import java.util.ArrayList;
import java.util.List;

import eu.muses.sim.Outcome;
import eu.muses.sim.request.AccessRequest;
import eu.muses.sim.riskman.RiskPolicy;
import eu.muses.sim.riskman.asset.Asset;
import eu.muses.sim.riskman.complexpolicy.ComplexPolicy;
import eu.muses.sim.riskman.opportunity.Opportunity;
import eu.muses.sim.riskman.threat.Threat;
import eu.muses.sim.test.SimUser;
import eu.muses.wp5.Clue;
import eu.muses.wp5.CluesThreatTable;

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
	 * @return the threat
	 */
	public abstract Threat getSingleThreat(Threat t);
	
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
	 * @return the simUser
	 */
	public abstract SimUser getSingleSimUsers(SimUser u);
	
	/**
	 * @param simUsers
	 *            the simUsers to set
	 */
	public abstract void setSimUsers(List<SimUser> simUsers);

	/**
	 * @return the cluesThreatTable
	 */
	public abstract CluesThreatTable getCluesThreatTable();

	/**
	 * @param cluesThreatTable
	 *            the cluesThreatTable to set
	 */
	public abstract void setCluesThreatTable(CluesThreatTable cluesThreatTable);
	
	/**
	 * @return the accessRequests
	 */
	public abstract List<AccessRequest> getAccessRequests();

	/**
	 * @param accessRequests
	 *            the accessRequests to set
	 */
	public abstract void setAccessRequests(List<AccessRequest> accessRequests);

	/**
	 * @param accessRequests
	 *            the accessRequests to anonymize
	 */
	public abstract void anonymizeAccessReqeuests(List<AccessRequest> accessRequests);
	
	/**
	 * @return the riskPolicies
	 */
	public abstract List<ComplexPolicy> getComplexPolicies();

	/**
	 * @param riskPolicies
	 *            the riskPolicies to set
	 */
	public abstract void setComplexPolicies(List<ComplexPolicy> complexPolicies);
	
	/**
	 * @param assetName the name of the Asset
	 *            
	 */
	public abstract Asset findAssetbyName(String assetName);
	
	/**
	 * For opportunity 
	 */
	
	public int workingHour = 0;
	public int potentialLoose = 0;
	public String clueSelected = null;
	public String assetSelected = null;
	public String RPSelected = null;
	public String Connection = null;
	public String Zone = null;
	public Object ObjAsset = null;
	public String Psw;
	public String Username;
	
	
	public String getPsw() {
		return Psw;
	}

	public void setPsw(String psw) {
		Psw = psw;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getZone() {
		return Zone;
	}

	public void setZone(String zone) {
		Zone = zone;
	}

	public String getConnection() {
		return Connection;
	}

	public void setConnection(String connection) {
		Connection = connection;
	}

	public int getWorkingHour() {
		return workingHour;
	}
	public void setWorkingHour(int workingHour) {
		this.workingHour = workingHour;
	}
	public int getPotentialLoose() {
		return potentialLoose;
	}
	public void setPotentialLoose(int potentialLoose) {
		this.potentialLoose = potentialLoose;
	}
	public String getClueSelected() {
		return clueSelected;
	}
	public void setClueSelected(String clueSelected) {
		this.clueSelected = clueSelected;
	}
	public String getAssetSelected() {
		return assetSelected;
	}
	public void setAssetSelected(String assetSelected) {
		this.assetSelected = assetSelected;
	}
	public String getRPSelected() {
		return RPSelected;
	}
	public void setRPSelected(String rPSelected) {
		RPSelected = rPSelected;
	}

	public Object getObjAsset() {
		return ObjAsset;
	}

	public void setObjAsset(Object objAsset) {
		ObjAsset = objAsset;
	}


}
