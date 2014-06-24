/**
 * 
 */
package eu.musesproject.server.persistence;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import eu.muses.sim.Outcome;
import eu.muses.sim.persistence.PersistenceManager;
import eu.muses.sim.request.AccessRequest;
import eu.muses.sim.riskman.Probability;
import eu.muses.sim.riskman.RiskPolicy;
import eu.muses.sim.riskman.asset.Asset;
import eu.muses.sim.riskman.opportunity.Opportunity;
import eu.muses.sim.riskman.threat.Threat;
import eu.muses.sim.test.SimUser;
import eu.muses.wp5.Clue;
import eu.muses.wp5.CluesThreatTable;
import eu.musesproject.server.rt2ae.User;

/**
 * @author xavier
 *
 */
public class DbPersistenceManager extends PersistenceManager {

	/**
	 * 
	 */
	@SuppressWarnings("resource")
	public DbPersistenceManager() {
		new ClassPathXmlApplicationContext("classpath*:META-INF/spring/applicationContext*.xml");
	}

	/* (non-Javadoc)
	 * @see eu.muses.sim.persistence.PersistenceManager#getOutcomes()
	 */
	@SuppressWarnings("static-access")
	@Override
	public List<Outcome> getOutcomes() {
		eu.musesproject.server.rt2ae.Outcome outcome = new eu.musesproject.server.rt2ae.Outcome();
		List<eu.musesproject.server.rt2ae.Outcome> l = outcome.findAllOutcomes();
		List<Outcome> lsim = new ArrayList<Outcome>();
		Iterator<eu.musesproject.server.rt2ae.Outcome> i = l.iterator();
		while(i.hasNext()){
			eu.musesproject.server.rt2ae.Outcome temp = i.next();
			Outcome o = new Outcome();
			o.setCostBenefit(temp.getCostbenefit());
			o.setDescription(temp.getDescription());
			lsim.add(o);
		}
		return lsim;		
	}

	/* (non-Javadoc)
	 * @see eu.muses.sim.persistence.PersistenceManager#setOutcomes(java.util.List)
	 */
	@Override
	public void setOutcomes(List<Outcome> outcomes) {
		Iterator<Outcome> i = outcomes.iterator();
		while(i.hasNext()){
			eu.musesproject.server.rt2ae.Outcome temp = new eu.musesproject.server.rt2ae.Outcome();
			Outcome o = i.next();
			temp.setCostbenefit(o.getCostBenefit());
			temp.setDescription(o.getDescription());
			temp.persist();	
		}
		
	}

	/* (non-Javadoc)
	 * @see eu.muses.sim.persistence.PersistenceManager#getOpportunities()
	 */
	@Override
	public List<Opportunity> getOpportunities() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see eu.muses.sim.persistence.PersistenceManager#setOpportunities(java.util.List)
	 */
	@Override
	public void setOpportunities(List<Opportunity> opportunities) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see eu.muses.sim.persistence.PersistenceManager#getAssets()
	 */
	@SuppressWarnings("static-access")
	@Override
	public List<Asset> getAssets() {
		eu.musesproject.server.rt2ae.Asset asset = new eu.musesproject.server.rt2ae.Asset();
		List<eu.musesproject.server.rt2ae.Asset> l = asset.findAllAssets();
		List<Asset> lsim = new ArrayList<Asset>();
		Iterator<eu.musesproject.server.rt2ae.Asset> i = l.iterator();
		while(i.hasNext()){
			eu.musesproject.server.rt2ae.Asset temp = i.next();
			Asset a = new Asset(temp.getAssetName(), temp.getValue());

			lsim.add(a);
		}
		return lsim;		
	}

	/* (non-Javadoc)
	 * @see eu.muses.sim.persistence.PersistenceManager#setAssets(java.util.List)
	 */
	@Override
	public void setAssets(List<Asset> assets) {
		Iterator<Asset> i = assets.iterator();
		while(i.hasNext()){
			eu.musesproject.server.rt2ae.Asset temp = new eu.musesproject.server.rt2ae.Asset();
			Asset a = i.next();
			System.out.println("ok");
			temp.setAssetName(a.getAssetName());
			temp.setValue(a.getValue());
			temp.setConfidentialLevel("PUBLIC");
			temp.setDescription("sadasd");
			temp.setLocation("fsdfsdfsd");
			temp.persist();	
		}
	}

	/* (non-Javadoc)
	 * @see eu.muses.sim.persistence.PersistenceManager#getThreats()
	 */
	@SuppressWarnings("static-access")
	@Override
	public List<Threat> getThreats() {
		eu.musesproject.server.rt2ae.Threat threat = new eu.musesproject.server.rt2ae.Threat();
		List<eu.musesproject.server.rt2ae.Threat> l = threat.findAllThreats();
		List<Threat> lsim = new ArrayList<Threat>();
		Iterator<eu.musesproject.server.rt2ae.Threat> i = l.iterator();
		while(i.hasNext()){
			eu.musesproject.server.rt2ae.Threat temp = i.next();
			Collection<Outcome> c = new ArrayList<Outcome>(); 
			
			//temp.getOutcomes().
			Iterator<eu.musesproject.server.rt2ae.Outcome> it = temp.getOutcomes().iterator();
			while(it.hasNext()){
				//eu.musesproject.server.rt2ae.Outcome temp = new eu.musesproject.server.rt2ae.Outcome();
				eu.musesproject.server.rt2ae.Outcome temp1 = it.next();
				Outcome o = new Outcome(temp1.getDescription(), temp1.getCostbenefit());
				c.add(o);				
				
			}
			
			Probability p = new Probability();
			p.setProb(temp.getProbability());
			Threat t = new Threat(temp.getDescription(),p, c);
			lsim.add(t);
		}
		return lsim;		
	}

	/* (non-Javadoc)
	 * @see eu.muses.sim.persistence.PersistenceManager#setThreats(java.util.List)
	 */
	@Override
	public void setThreats(List<Threat> threats) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see eu.muses.sim.persistence.PersistenceManager#getClues()
	 */
	@Override
	public List<Clue> getClues() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see eu.muses.sim.persistence.PersistenceManager#setClues(java.util.List)
	 */
	@Override
	public void setClues(List<Clue> clues) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see eu.muses.sim.persistence.PersistenceManager#getRiskPolicies()
	 */
	@Override
	public List<RiskPolicy> getRiskPolicies() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see eu.muses.sim.persistence.PersistenceManager#setRiskPolicies(java.util.List)
	 */
	@Override
	public void setRiskPolicies(List<RiskPolicy> riskPolicies) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see eu.muses.sim.persistence.PersistenceManager#getSimUsers()
	 */
	@Override
	public List<SimUser> getSimUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see eu.muses.sim.persistence.PersistenceManager#setSimUsers(java.util.List)
	 */
	@Override
	public void setSimUsers(List<SimUser> simUsers) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see eu.muses.sim.persistence.PersistenceManager#getCluesThreatTable()
	 */
	@Override
	public CluesThreatTable getCluesThreatTable() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see eu.muses.sim.persistence.PersistenceManager#setCluesThreatTable(eu.muses.wp5.CluesThreatTable)
	 */
	@Override
	public void setCluesThreatTable(CluesThreatTable cluesThreatTable) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see eu.muses.sim.persistence.PersistenceManager#getAccessRequests()
	 */
	@Override
	public List<AccessRequest> getAccessRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see eu.muses.sim.persistence.PersistenceManager#setAccessRequests(java.util.List)
	 */
	@Override
	public void setAccessRequests(List<AccessRequest> accessRequests) {
		// TODO Auto-generated method stub

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DbPersistenceManager p = new DbPersistenceManager();
		Outcome o = new Outcome();
		o.setCostBenefit(100.1);
		o.setDescription("ooooooooo");
		
		Outcome o1 = new Outcome();
		o1.setCostBenefit(100.2);
		o1.setDescription("aaaaaaaaa");
		
		Outcome o2 = new Outcome();
		o2.setCostBenefit(100.3);
		o2.setDescription("iiiiiiii");
		
		List<Outcome> l = new ArrayList<Outcome>();
		l.add(o);
		l.add(o1);
		l.add(o2);
		//p.setOutcomes(l);
		eu.musesproject.server.rt2ae.Asset temp = new eu.musesproject.server.rt2ae.Asset();
		temp.setAssetName("aaaa");
		temp.setValue(0.6);
		temp.setConfidentialLevel("PUBLIC");
		temp.setDescription("sadasd");
		temp.setLocation("fsdfsdfsd");
		//temp.persist();	
		Asset a = new Asset("poster", 0.5);
		Asset a1 = new Asset("poster1", 0.8);
		List<Asset> l1 = new ArrayList<Asset>();
		l1.add(a);
		l1.add(a1);
		//p.setAssets(l1);
		//System.out.println("List of all users: "+p.getThreats().toString());
	}

}
