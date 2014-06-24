/**
 * 
 */
package eu.musesproject.server.persistence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import eu.musesproject.server.rt2ae.Asset;
import eu.musesproject.server.rt2ae.Clue;
import eu.musesproject.server.rt2ae.Opportunity;
import eu.musesproject.server.rt2ae.Outcome;
import eu.musesproject.server.rt2ae.RiskPolicy;
import eu.musesproject.server.rt2ae.Threat;
import eu.musesproject.server.rt2ae.User;

/**
 * @author xavier
 *
 */
public class PersistenceManagerImpl extends PersistenceManager {

	/**
	 * 
	 */
	@SuppressWarnings("resource")
	public PersistenceManagerImpl() {
		new ClassPathXmlApplicationContext("classpath*:META-INF/spring/applicationContext*.xml");
	}

	/* (non-Javadoc)
	 * @see eu.musesproject.server.persistence.PersistenceManager#getOutcomes()
	 */
	@SuppressWarnings("static-access")
	public List<Outcome> getOutcomes() {
		Outcome o = new Outcome();
		return o.findAllOutcomes();
	}

	/* (non-Javadoc)
	 * @see eu.musesproject.server.persistence.PersistenceManager#setOutcomes(java.util.List)
	 */
	
	public void setOutcomes(List<Outcome> outcomes) {
		Iterator<Outcome> i = outcomes.iterator();
		while(i.hasNext()){
			Outcome o = i.next();
			o.persist();
		
		}

	}

	/* (non-Javadoc)
	 * @see eu.musesproject.server.persistence.PersistenceManager#getOpportunities()
	 */
	
	@SuppressWarnings("static-access")
	public List<Opportunity> getOpportunities() {
		Opportunity o = new Opportunity();
		return o.findAllOpportunitys();
	}

	/* (non-Javadoc)
	 * @see eu.musesproject.server.persistence.PersistenceManager#setOpportunities(java.util.List)
	 */
	
	public void setOpportunities(List<Opportunity> opportunities) {
		Iterator<Opportunity> i = opportunities.iterator();
		while(i.hasNext()){
			Opportunity o = i.next();
			o.persist();
		
		}
	}

	/* (non-Javadoc)
	 * @see eu.musesproject.server.persistence.PersistenceManager#getAssets()
	 */
	
	@SuppressWarnings("static-access")
	public List<Asset> getAssets() {
		Asset a = new Asset();
		return a.findAllAssets();
	}

	/* (non-Javadoc)
	 * @see eu.musesproject.server.persistence.PersistenceManager#setAssets(java.util.List)
	 */
	
	public void setAssets(List<Asset> assets) {
		Iterator<Asset> i = assets.iterator();
		while(i.hasNext()){
			Asset a = i.next();
			a.setConfidentialLevel("");
			a.setDescription("");
			a.setLocation("");
			a.persist();
		
		}
	}

	/* (non-Javadoc)
	 * @see eu.musesproject.server.persistence.PersistenceManager#getThreats()
	 */

	@SuppressWarnings("static-access")
	public List<Threat> getThreats() {
		Threat t = new Threat();
		return t.findAllThreats();
	}

	/* (non-Javadoc)
	 * @see eu.musesproject.server.persistence.PersistenceManager#setThreats(java.util.List)
	 */

	public void setThreats(List<Threat> threats) {
		Iterator<Threat> i = threats.iterator();
		while(i.hasNext()){
			Threat t = i.next();
			t.persist();
		
		}
	}

	/* (non-Javadoc)
	 * @see eu.musesproject.server.persistence.PersistenceManager#getClues()
	 */
	@SuppressWarnings("static-access")
	public List<Clue> getClues() {
		Clue c = new Clue();
		return c.findAllClues();
	}

	/* (non-Javadoc)
	 * @see eu.musesproject.server.persistence.PersistenceManager#setClues(java.util.List)
	 */
	public void setClues(List<Clue> clues) {
		Iterator<Clue> i = clues.iterator();
		while(i.hasNext()){
			Clue c = i.next();
			c.persist();
		
		}
	}

	/* (non-Javadoc)
	 * @see eu.musesproject.server.persistence.PersistenceManager#getRiskPolicies()
	 */
	@SuppressWarnings("static-access")
	public List<RiskPolicy> getRiskPolicies() {
		RiskPolicy r = new RiskPolicy();
		return r.findAllRiskPolicys();
	}

	/* (non-Javadoc)
	 * @see eu.musesproject.server.persistence.PersistenceManager#setRiskPolicies(java.util.List)
	 */
	
	public void setRiskPolicies(List<RiskPolicy> riskPolicies) {
		Iterator<RiskPolicy> i = riskPolicies.iterator();
		while(i.hasNext()){
			RiskPolicy r = i.next();
			r.persist();
		
		}// TODO Auto-generated method stub

	}
	
@SuppressWarnings("static-access")
public  List<SimUser> getSimUsers() {
		
		User u = new User();
		List<User> l = u.findAllUsers();
		List<SimUser> simusers = new ArrayList<SimUser>();
		Iterator<User> i = l.iterator();
		while(i.hasNext()){
			User temp = i.next();
			SimUser s = new SimUser();
			s.setNickname(temp.getName());
			s.setTrustValue(temp.getTrustvalue());
			simusers.add(s);
		}// TODO Auto
		
		return simusers;
	}

	/**
	 * @param assets the assets to set
	 */
	public  void setSimUsers(List<SimUser> simusers) {
				
		
		List<User> l = new ArrayList<User>();
		//List<SimUser> simusers = new ArrayList<SimUser>();
		Iterator<SimUser> i = simusers.iterator();
		while(i.hasNext()){
			User temp = new User();
			SimUser s = i.next();
			temp.setName(s.getNickname());
			temp.setTrustvalue(s.getTrustValue());
			temp.setEmail("");
			temp.setSurname("");
			l.add(temp);
		
		}// TODO Auto
		PersistenceManagerImpl p = new PersistenceManagerImpl();
		p.setUser(l);
				
		
	}
	@SuppressWarnings("static-access")
	public List<User> getAllUser(){
		
		User u = new User();
		
		return u.findAllUsers();
	}
	
	public  void setUser(List<User> users) {
		
		//new PersistenceManager();
		
		Iterator<User> i = users.iterator();
		while(i.hasNext()){
			User u = i.next();
			u.persist();
		
		}
		
	}
	public static void main(String[] args) {
		
		long startTime = System.nanoTime();
		PersistenceManagerImpl p = new PersistenceManagerImpl();
		System.out.println("List of all users: "+p.getSimUsers().get(0).toString());
		long endTime = System.nanoTime();
		double duration = (double) (endTime - startTime) / (Math.pow(10, 9));
		System.out.println("First execution time: " + duration);
		for(int i = 0; i < 10; i++){
		startTime = System.nanoTime();
		System.out.println("List of all users: "+p.getSimUsers().get(0).toString());
		endTime = System.nanoTime();
		duration = (double) (endTime - startTime) / (Math.pow(10, 9));
		System.out.println("Time: " + duration);
		}
		
		Threat t = new Threat ();
	
		
	}
	
}
