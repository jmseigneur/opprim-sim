/**
 * 
 */
package eu.musesproject.server.persistence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;






import org.springframework.context.support.ClassPathXmlApplicationContext;

import eu.musesproject.server.rt2ae.Accessrequest;
import eu.musesproject.server.rt2ae.Asset;
import eu.musesproject.server.rt2ae.Clue;
import eu.musesproject.server.rt2ae.Decision;
import eu.musesproject.server.rt2ae.Opportunity;
import eu.musesproject.server.rt2ae.Outcome;
import eu.musesproject.server.rt2ae.RiskPolicy;
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
	
	@SuppressWarnings("resource")
	public PersistenceManager() {
		new ClassPathXmlApplicationContext("classpath*:META-INF/spring/applicationContext*.xml");

	}

	/**
	 * @return the outcomes
	 */
	@SuppressWarnings("static-access")
	public  List<Outcome> getOutcomes() {
		
		new PersistenceManager();
		Outcome o = new Outcome();
		return o.findAllOutcomes();
	}

	/**
	 * @param outcomes the outcomes to set
	 */
	public  void setOutcomes(List<Outcome> outcomes) {
				
		Iterator<Outcome> i = outcomes.iterator();
		while(i.hasNext()){
			Outcome o = i.next();
			o.persist();
		
		}
				
	}

	/**
	 * @return the opportunities
	 */
	@SuppressWarnings("static-access")
	public  List<Opportunity> getOpportunities() {
		
		new PersistenceManager();
		Opportunity o = new Opportunity();
		return o.findAllOpportunitys();
	}

	/**
	 * @param opportunities the opportunities to set
	 */
	public  void setOpportunities(List<Opportunity> opportunities) {
		
		
		Iterator<Opportunity> i = opportunities.iterator();
		while(i.hasNext()){
			Opportunity o = i.next();
			o.persist();
		
		}
	}

	/**
	 * @return the assets
	 */
	@SuppressWarnings("static-access")
	public  List<Asset> getAssets() {
		
		new PersistenceManager();
		Asset a = new Asset();
		return a.findAllAssets();
	}

	/**
	 * @param assets the assets to set
	 */
	public  void setAssets(List<Asset> assets) {
				
		Iterator<Asset> i = assets.iterator();
		while(i.hasNext()){
			Asset a = i.next();
			a.persist();
		
		}
	}

	/**
	 * @return the threats
	 */
	@SuppressWarnings("static-access")
	public  List<Threat> getThreats() {
		
		new PersistenceManager();
		Threat t = new Threat();
		return t.findAllThreats();
	}

	/**
	 * @param threats the threats to set
	 */
	public  void setThreats(List<Threat> threats) {
		
		
		
		Iterator<Threat> i = threats.iterator();
		while(i.hasNext()){
			Threat t = i.next();
			t.persist();
		
		}
		
	}

	/**
	 * @return the clues
	 */
	@SuppressWarnings("static-access")
	public  List<Clue> getClues() { 
		
		//new PersistenceManager();
		Clue c = new Clue();
		return c.findAllClues();
	}

	/**
	 * @param clues the clues to set
	 */
	public  void setClues(List<Clue> clues) {
		
		//new PersistenceManager();
		
		Iterator<Clue> i = clues.iterator();
		while(i.hasNext()){
			Clue c = i.next();
			c.persist();
		
		}
		
	}

	/**
	 * @return the riskPolicies
	 */
	public  List<RiskPolicy> getRiskPolicies() {
		return null;
	}

	/**
	 * @param riskPolicies the riskPolicies to set
	 */
	public static void setRiskPolicies(List<RiskPolicy> riskPolicies) {
		
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
	
	public static void main(String[] args) {
		PersistenceManager p = new PersistenceManager();

		
		RiskPolicy r = new RiskPolicy();
		r.setDescription("tessddsftsts");
		r.setRiskvalue(2343400.0);
		
		
		//r.persist();
		Threat t = new Threat ();
		t.setProbability(0.888);
		t.setDescription("dsfdsfdaftesddsdsst");
		//t.persist();
		
		Threat t1 = new Threat ();
		t1.setProbability(0.99);
		t1.setDescription("tasdasdasesddsdsst");
		//t1.persist();
		
		List<Threat> l1 = new ArrayList<Threat>();
		l1.add(t);
		l1.add(t1);
		p.setThreats(l1);
		
		Outcome o = new Outcome();
		o.setCostbenefit(200.0);
		o.setDescription("test");
		
		//o.setOutcomeId(1);
		o.setThreatId(t);
		//o.persist();
		Clue c = new Clue ();
		//c.setClueId(null);
		c.setValue(20023);
		Clue c1 = new Clue ();
		//c.setClueId(null);
		c1.setValue(30043);
		
		c.setThreatId(t);
		c1.setThreatId(t);

		
		List<Clue> l = new ArrayList<Clue>();
		l.add(c);
		l.add(c1);
		//p.setClues(l);
		//c.persist();
		Asset as = new Asset ();
		
		
		
		//o.persist();*/
		
		User u = new User();
		//u.setAccessrequests(null);
		//u.setDevices(null);
		u.setName("nerea");
		u.setSurname("moreno");
		u.setEmail("nerena.moreno@unige.ch");
		u.setSecurityIncidents(null);
		u.setTrustvalue(0.8);
		
		//u.persist();
		
		
		
		
		System.out.println("List of all users: "+p.getAllUser());

	}	
	    
	

}
