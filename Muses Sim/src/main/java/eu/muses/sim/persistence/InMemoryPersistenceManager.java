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
import eu.muses.sim.trustman.TrustValue;
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
	
	/** The risk Policies */
	private List<ComplexPolicy> complexPolicies = new ArrayList<ComplexPolicy>();
	
	/** Configuration for admin client*/
	private AdminConfiguration adminConf = new AdminConfiguration();
	
	/** List of selected asset by the user*/
	private List<Asset> selectedAssetsbyUser = new ArrayList<Asset>();
	
	private List<SimUser> loggedUser = new ArrayList<SimUser>();

	

	public InMemoryPersistenceManager() {
		super();
	}
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
	public String SelectedRule = null;
	public int WorkingHour;
	public int PotentialRevenueLoss;
	public String LoosingExplanation = null;
	
	public String getSelectedRule() {
		return SelectedRule;
	}

	public void setSelectedRule(String selectedRule) {
		SelectedRule = selectedRule;
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
		for (Outcome outcome : outcomes) {
			this.outcomes.add(outcome);
		}

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
		for (Opportunity opportunity : opportunities) {
			this.opportunities.add(opportunity);
		}

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
		for (Asset asset : assets) {
			this.assets.add(asset);
		}

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
	 * @return the threat
	 */
	public Threat getSingleThreat(Threat t) {
		for (int i = 0; i < this.threats.size(); i++) {
			if(this.threats.get(i).getDescription().equals(t.getDescription()))
				return this.threats.get(i);
		}
		return null;
	}

	@Override
	/**
	 * @param threats
	 *            the threats to set
	 */
	public void setThreats(List<Threat> threats) {
		int x = -1;
		for (Threat threat : threats) {
			if (this.threats.size() > 0) {
				for (int i = 0; i < this.threats.size(); i++) {
					if (this.threats.get(i)
							.getDescription()
							.equals(threat.getDescription())) {
						x = i;
					} 
				}
				
				if (x != -1){
					this.threats.set(x, threat);
				}else{
					this.threats.add(threat);
				}
				
			} else {
				this.threats.add(threat);
			}
		}

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
		for (Clue clue : clues) {
			this.clues.add(clue);
		}

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
		for (RiskPolicy riskPolicy : riskPolicies) {
			this.riskPolicies.add(riskPolicy);
		}

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
	 * @return the simUser
	 */
	public SimUser getSingleSimUsers(SimUser u) {
		for (int i = 0; i < this.simUsers.size(); i++) {
			if(this.simUsers.get(i).getNickname().equals(u.getNickname()))
				return this.simUsers.get(i);
		}
		return new SimUser("NotFound", 0.0,new TrustValue(0.0), "pass");
	}

	@Override
	/**
	 * @param simUsers
	 *            the simUsers to set
	 */
	public void setSimUsers(List<SimUser> simUsers) {
		
		int x = -1;
		for (SimUser user : simUsers) {
			if (this.simUsers.size() > 0) {
				for (int i = 0; i < this.simUsers.size(); i++) {
					if (this.simUsers.get(i)
							.getNickname()
							.equals(user.getNickname())) {
						x = i;
				}
				}
				if (x != -1){
					this.simUsers.set(x, user);
				}else{
					this.simUsers.add(user);
				}
			} else {
				this.simUsers.add(user);
			}
		}

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
	public List<AccessRequest> getAccessRequests() {
		return accessRequests;
	}

	@Override
	/**
	 * @param accessRequests
	 *            the accessRequests to set
	 */
	public void setAccessRequests(List<AccessRequest> accessRequests) {
		int x = -1;
		try{
			System.out.println("We have entered in setAccessRequest");
		for (AccessRequest accessRequest : accessRequests) {
			System.out.println("We have entered in loop setAccessRequest: " + this.accessRequests.size());
			if (this.accessRequests.size() > 0) {
				for (int i = 0; i < this.accessRequests.size(); i++) {
					if (this.accessRequests.get(i)
							.getCluesThreatEntry()
							.getThreat()
							.getDescription()
							.equals(accessRequest.getCluesThreatEntry()
									.getThreat().getDescription())
							&& this.accessRequests.get(i).getTime().getTimeInMillis() == accessRequest.getTime().getTimeInMillis()
									) {
						System.out.println("We are replacing the AccessRequest " + i + " with threat desc " + this.accessRequests.get(i)
								.getCluesThreatEntry()
								.getThreat()
								.getDescription() + " - " + accessRequest.getCluesThreatEntry()
								.getThreat().getDescription() + " and time " + this.accessRequests.get(i).getTime().getTimeInMillis() + " - " + accessRequest.getTime().getTimeInMillis());
						x = i;
					}
				}
				
				if(x != -1){
					this.accessRequests.set(x, accessRequest);
				}else{
					this.accessRequests.add(accessRequest);
				}
				
			} else {
				System.out.println("2");
				this.accessRequests.add(accessRequest);
			}
		}
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}

	@Override
	public void anonymizeAccessReqeuests(List<AccessRequest> accessRequests) {
		// TODO Auto-generated method stub

	}

	@Override
	/**
	 * @return the complexPolicies
	 */
	public List<ComplexPolicy> getComplexPolicies() {
		return complexPolicies;
	}

	@Override
	/**
	 * @param complexPolicies the complexPolicies to set
	 */
	public void setComplexPolicies(List<ComplexPolicy> complexPolicies) {
		this.complexPolicies = complexPolicies;
	}

	public AdminConfiguration getAdminConf() {
		return adminConf;
	}

	public void setAdminConf(AdminConfiguration adminConf) {
		this.adminConf = adminConf;
	}

	@Override
	/**
	 * @param assetName the name of the Asset
	 *            
	 */
	public Asset findAssetbyName(String assetName){
		for (int i = 0; i < this.assets.size(); i++) {
			if(assets.get(i).getAssetName().equalsIgnoreCase(assetName))
				return assets.get(i);
		}
		return null;
	}

	public List<Asset> getSelectedAssetsbyUser() {
		return selectedAssetsbyUser;
	}

	public void setSelectedAssetsbyUser(List<Asset> selectedAssetsbyUser) {
		this.selectedAssetsbyUser = selectedAssetsbyUser;
	}

	public int getPotentialRevenueLoss() {
		return PotentialRevenueLoss;
	}

	public void setPotentialRevenueLoss(int potentialRevenueLoss) {
		PotentialRevenueLoss = potentialRevenueLoss;
	}

	public String getLoosingExplanation() {
		return LoosingExplanation;
	}

	public void setLoosingExplanation(String loosingExplanation) {
		LoosingExplanation = loosingExplanation;
	}

	public List<SimUser> getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(List<SimUser> loggedUser) {
		this.loggedUser = loggedUser;
	}

	


}
