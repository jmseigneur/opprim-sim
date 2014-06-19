/**
 * 
 */
package eu.musesproject.server.persistence;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import eu.musesproject.server.rt2ae.Asset;
import eu.musesproject.server.rt2ae.Clue;
import eu.musesproject.server.rt2ae.Opportunity;
import eu.musesproject.server.rt2ae.Outcome;
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
		new ClassPathXmlApplicationContext("classpath*:META-INF/spring/applicationContext*.xml");

	}

	/**
	 * @return the outcomes
	 */
	public static List<Outcome> getOutcomes() {
		
		new PersistenceManager();
		Outcome o = new Outcome();
		return o.findAllOutcomes();
	}

	/**
	 * @param outcomes the outcomes to set
	 */
	public static void setOutcomes(List<Outcome> outcomes) {
		
		new PersistenceManager();
		
		Iterator<Outcome> i = outcomes.iterator();
		while(i.hasNext()){
			Outcome o = (Outcome)i.next();
			o.persist();
		
		}
				
	}

	/**
	 * @return the opportunities
	 */
	public static List<Opportunity> getOpportunities() {
		
		new PersistenceManager();
		Opportunity o = new Opportunity();
		return o.findAllOpportunitys();
	}

	/**
	 * @param opportunities the opportunities to set
	 */
	public static void setOpportunities(List<Opportunity> opportunities) {
		
		new PersistenceManager();
		
		Iterator<Opportunity> i = opportunities.iterator();
		while(i.hasNext()){
			Opportunity o = (Opportunity)i.next();
			o.persist();
		
		}
	}

	/**
	 * @return the assets
	 */
	public static List<Asset> getAssets() {
		
		new PersistenceManager();
		Asset a = new Asset();
		return a.findAllAssets();
	}

	/**
	 * @param assets the assets to set
	 */
	public static void setAssets(List<Asset> assets) {
		
		new PersistenceManager();
		
		Iterator<Asset> i = assets.iterator();
		while(i.hasNext()){
			Asset a = (Asset)i.next();
			a.persist();
		
		}
	}

	/**
	 * @return the threats
	 */
	public static List<Threat> getThreats() {
		
		new PersistenceManager();
		Threat t = new Threat();
		return t.findAllThreats();
	}

	/**
	 * @param threats the threats to set
	 */
	public static void setThreats(List<Threat> threats) {
		
		new PersistenceManager();
		
		Iterator<Threat> i = threats.iterator();
		while(i.hasNext()){
			Threat t = (Threat)i.next();
			t.persist();
		
		}
		
	}

	/**
	 * @return the clues
	 */
	public static List<Clue> getClues() { 
		
		new PersistenceManager();
		Clue c = new Clue();
		return c.findAllClues();
	}

	/**
	 * @param clues the clues to set
	 */
	public static void setClues(List<Clue> clues) {
		
		new PersistenceManager();
		
		Iterator<Clue> i = clues.iterator();
		while(i.hasNext()){
			Clue c = (Clue)i.next();
			c.persist();
		
		}
		
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
	
	@SuppressWarnings("static-access")
	public List<User> getAllUser(){
		
		User u = new User();
		
		return u.findAllUsers();
	}
	
	@SuppressWarnings({"resource" })
	public static void main(String[] args) {
		Threat t = new Threat ();
		PersistenceManager p = new PersistenceManager();
		
		t.setProbability(0.5);
		t.setDescription("test");
		t.setClues(null);
		t.persist();
		Outcome o = new Outcome();
		o.setCostbenefit(200.0);
		o.setDescription("test");
		o.setOutcomeId(1);
		o.setThreatId(t);
		Clue c = new Clue ();
		//c.setClueId(null);
		c.setValue(200);
		c.setThreatId(t);
		c.persist();
		Asset a = new Asset ();
	
		//o.persist();
		User u = new User();		
		System.out.println("List of all users: "+u.findAllUsers());
	}	
	    
	

}
