/**
 * 
 */
package eu.musesproject.server.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import eu.musesproject.server.rt2ae.Asset;
import eu.musesproject.server.rt2ae.Clue;
import eu.musesproject.server.rt2ae.Opportunity;
import eu.musesproject.server.rt2ae.SecurityIncident;
import eu.musesproject.server.rt2ae.Threat;
import eu.musesproject.server.rt2ae.User;



/**
 * @author xavier
 *
 */
public class PersistenceManager {

	/**
	 * 
	 */
	
	public PersistenceManager() {
		// TODO Auto-generated constructor stub
		super();
	}

	/**
	 * @return the outcomes
	 */
	/*public static List<Outcome> getOutcomes() {
		return null;
	}

	/**
	 * @param outcomes the outcomes to set
	 */
	/*public static void setOutcomes(List<Outcome> outcomes) {
		
	}

	/**
	 * @return the opportunities
	 */
	public static List<Opportunity> getOpportunities() {
		return null;
	}

	/**
	 * @param opportunities the opportunities to set
	 */
	public static void setOpportunities(List<Opportunity> opportunities) {
		
	}

	/**
	 * @return the assets
	 */
	public static List<Asset> getAssets() {
		return null;
	}

	/**
	 * @param assets the assets to set
	 */
	public static void setAssets(List<Asset> assets) {
		
	}

	/**
	 * @return the threats
	 */
	public static List<Threat> getThreats() {
		return null;
	}

	/**
	 * @param threats the threats to set
	 */
	public static void setThreats(List<Threat> threats) {
		
	}

	/**
	 * @return the clues
	 */
	public static List<Clue> getClues() {
		return null;
	}

	/**
	 * @param clues the clues to set
	 */
	public static void setClues(List<Clue> clues) {
		
	}

	/**
	 * @return the riskPolicies
	 */
	/*public static List<RiskPolicy> getRiskPolicies() {
		return null;
	}

	/**
	 * @param riskPolicies the riskPolicies to set
	 */
	/*public static void setRiskPolicies(List<RiskPolicy> riskPolicies) {
		
	}

	/**
	 * @return the simUsers
	 */
	/*public static List<SimUser> getSimUsers() {
		return null;
	}

	/**
	 * @param simUsers the simUsers to set
	 */
	/*public static void setSimUsers(List<SimUser> simUsers) {
		
	}

	/**
	 * @return the cluesThreatTable
	 */
	/*public static CluesThreatTable getCluesThreatTable() {
		return null;
	}

	/**
	 * @param cluesThreatTable the cluesThreatTable to set
	 */
	/*public static void setCluesThreatTable(CluesThreatTable cluesThreatTable) {
		
	}*/
	
	public List<User> getAllUser(){
		
		User u = new User();
		
		return u.findAllUsers();
	}
	
	@SuppressWarnings({"resource" })
	public static void main(String[] args) {
		
		new ClassPathXmlApplicationContext("classpath*:META-INF/spring/applicationContext*.xml");
		
		SecurityIncident s = new SecurityIncident();
		
		
		//System.out.println(u.findAllUsers().toString());
	}	
	
	

}
