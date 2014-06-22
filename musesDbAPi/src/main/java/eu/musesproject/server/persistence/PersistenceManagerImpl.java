/**
 * 
 */
package eu.musesproject.server.persistence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
		PersistenceManagerImpl p = new PersistenceManagerImpl();
		
		RiskPolicy r = new RiskPolicy();
		r.setDescription("tessddsftsts");
		r.setRiskvalue(2343400.0);
		
		
		//r.persist();
		Threat t = new Threat ();
		t.setProbability(0.11111888);
		t.setDescription("dsfdsfdaftesddsdsst");
		//t.persist();
		
		Threat t1 = new Threat ();
		t1.setProbability(0.111199);
		t1.setDescription("tasdasdasesddsdsst");
		//t1.persist();
		
		List<Threat> l1 = new ArrayList<Threat>();
		l1.add(t);
		l1.add(t1);
		
		//p.setThreats(l1);
		
		Outcome o = new Outcome();
		o.setCostbenefit(200.0);
		o.setDescription("test");
		
		//o.setOutcomeId(1);
		o.setThreatId(t);
		//o.persist();
		Clue c = new Clue ();
		//c.setClueId(null);
		c.setValue("WIFI");
		Clue c1 = new Clue ();
		//c.setClueId(null);
		c1.setValue("Antivirus");
		
		c.setThreatId(t);
		c1.setThreatId(t);

		
		List<Clue> l = new ArrayList<Clue>();
		l.add(c);
		l.add(c1);
		//p.setClues(l);
		//c.persist();
	
		
		
		
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
		
		
		
		
		System.out.println("List of all users: "+p.getSimUsers().get(0).toString());

	}	

}
