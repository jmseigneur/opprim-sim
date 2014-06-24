/**
 * 
 */
package eu.musesproject.server.persistence;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import eu.muses.sim.Outcome;
import eu.muses.sim.persistence.PersistenceManager;
import eu.muses.sim.request.AccessRequest;
import eu.muses.sim.riskman.Probability;
import eu.muses.sim.riskman.RiskPolicy;
import eu.muses.sim.riskman.RiskValue;
import eu.muses.sim.riskman.asset.Asset;
import eu.muses.sim.riskman.opportunity.Opportunity;
import eu.muses.sim.riskman.threat.Threat;
import eu.muses.sim.test.SimUser;
import eu.muses.sim.trustman.UserTrustValue;
import eu.muses.wp5.Clue;
import eu.muses.wp5.CluesThreatEntry;
import eu.muses.wp5.CluesThreatTable;
import eu.musesproject.server.rt2ae.Accessrequest;

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
		List<eu.musesproject.server.rt2ae.Outcome> listoutcome = outcome.findAllOutcomes();
		List<Outcome> listoutcomesim = new ArrayList<Outcome>();
		Iterator<eu.musesproject.server.rt2ae.Outcome> i = listoutcome.iterator();
		while(i.hasNext()){
			eu.musesproject.server.rt2ae.Outcome temp = i.next();
			Outcome o = new Outcome();
			o.setCostBenefit(temp.getCostbenefit());
			o.setDescription(temp.getDescription());
			listoutcomesim.add(o);
		}
		return listoutcomesim;		
	}

	/* (non-Javadoc)
	 * @see eu.muses.sim.persistence.PersistenceManager#setOutcomes(java.util.List)
	 */
	@Override
	public void setOutcomes(List<Outcome> outcomes) {
		Iterator<Outcome> i = outcomes.iterator();
		while(i.hasNext()){
			eu.musesproject.server.rt2ae.Outcome outcome = new eu.musesproject.server.rt2ae.Outcome();
			Outcome o = i.next();
			outcome.setCostbenefit(o.getCostBenefit());
			outcome.setDescription(o.getDescription());
			outcome.persist();	
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
		List<Asset> listassetsim = new ArrayList<Asset>();
		Iterator<eu.musesproject.server.rt2ae.Asset> i = l.iterator();
		while(i.hasNext()){
			eu.musesproject.server.rt2ae.Asset asset_temp = i.next();
			Asset a = new Asset(asset_temp.getAssetName(), asset_temp.getValue());

			listassetsim.add(a);
		}
		return listassetsim;		
	}

	/* (non-Javadoc)
	 * @see eu.muses.sim.persistence.PersistenceManager#setAssets(java.util.List)
	 */
	@Override
	public void setAssets(List<Asset> assets) {
		Iterator<Asset> i = assets.iterator();
		while(i.hasNext()){
			eu.musesproject.server.rt2ae.Asset asset = new eu.musesproject.server.rt2ae.Asset();
			Asset a = i.next();
			asset.setAssetName(a.getAssetName());
			asset.setValue(a.getValue());
			asset.setConfidentialLevel("PUBLIC");
			asset.setDescription("");
			asset.setLocation("");
			asset.persist();	
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
			eu.musesproject.server.rt2ae.Threat threat_temp = i.next();
			Collection<Outcome> c = new ArrayList(threat_temp.getOutcomes());
			
		//	List list = new ArrayList(set);
			//System.out.println("okkk  "+ threat_temp.getOutcomes().size());
			//temp.getOutcomes().
			//Collection list = new ArrayList(set);

			/*Iterator<eu.musesproject.server.rt2ae.Outcome> it = threat_temp.getOutcomes().iterator();
			
			while(it.hasNext()){
				//eu.musesproject.server.rt2ae.Outcome temp = new eu.musesproject.server.rt2ae.Outcome();
				eu.musesproject.server.rt2ae.Outcome temp1 = it.next();
				Outcome o = new Outcome(temp1.getDescription(), temp1.getCostbenefit());
				c.add(o);				
				
			}*/
			
			Probability p = new Probability();
			p.setProb(threat_temp.getProbability());
			Threat t = new Threat(threat_temp.getDescription(),p, c);
			lsim.add(t);
		}
		return lsim;		
	}

	/* (non-Javadoc)
	 * @see eu.muses.sim.persistence.PersistenceManager#setThreats(java.util.List)
	 */
	@Override
	public void setThreats(List<Threat> threats) {
		Iterator<Threat> i = threats.iterator();
		while(i.hasNext()){
			eu.musesproject.server.rt2ae.Threat threat = new eu.musesproject.server.rt2ae.Threat();
			Threat t = i.next();
			threat.setDescription(t.getDescription());
			threat.setProbability(t.getProbabilityValue());
			threat.setBadOutcomeCount(t.getBadOutcomeCount());
			threat.setOccurences(t.getOccurences());
			
			Set<eu.musesproject.server.rt2ae.Outcome> listoutcome = new HashSet<eu.musesproject.server.rt2ae.Outcome>();
			Iterator<Outcome> it = t.getOutcomes().iterator();
			while(it.hasNext()){
				eu.musesproject.server.rt2ae.Outcome outcome = new eu.musesproject.server.rt2ae.Outcome();
				Outcome o = it.next();
				outcome.setCostbenefit(o.getCostBenefit());
				outcome.setDescription(o.getDescription());
				outcome.setThreatId(threat);
				listoutcome.add(outcome);
			}
			threat.setOutcomes(listoutcome);		
		    threat.persist();
		    
		}
	}

	/* (non-Javadoc)
	 * @see eu.muses.sim.persistence.PersistenceManager#getClues()
	 */
	@SuppressWarnings("static-access")
	@Override
	public List<Clue> getClues() {
		eu.musesproject.server.rt2ae.Clue clue = new eu.musesproject.server.rt2ae.Clue();
		List<eu.musesproject.server.rt2ae.Clue> l = clue.findAllClues();
		List<Clue> listcluesim = new ArrayList<Clue>();
		Iterator<eu.musesproject.server.rt2ae.Clue> i = l.iterator();
		while(i.hasNext()){
			eu.musesproject.server.rt2ae.Clue clue_temp = i.next();
			Clue c = new Clue();
			c.setId(clue_temp.getValue());

			listcluesim.add(c);
		}
		return listcluesim;
	}

	/* (non-Javadoc)
	 * @see eu.muses.sim.persistence.PersistenceManager#setClues(java.util.List)
	 */
	@Override
	public void setClues(List<Clue> clues) {
		Iterator<Clue> i = clues.iterator();
		while(i.hasNext()){
			eu.musesproject.server.rt2ae.Clue clue = new eu.musesproject.server.rt2ae.Clue();
			Clue c = i.next();
			clue.setValue(c.getId());
			//clue.setThreatId();
			clue.persist();	
		}
	}

	/* (non-Javadoc)
	 * @see eu.muses.sim.persistence.PersistenceManager#getRiskPolicies()
	 */
	@SuppressWarnings("static-access")
	@Override
	public List<RiskPolicy> getRiskPolicies() {
		eu.musesproject.server.rt2ae.RiskPolicy riskpolicy = new eu.musesproject.server.rt2ae.RiskPolicy();
		List<eu.musesproject.server.rt2ae.RiskPolicy> listriskpolicy = riskpolicy.findAllRiskPolicys();
		List<RiskPolicy> listriskpolicysim = new ArrayList<RiskPolicy>();
		Iterator<eu.musesproject.server.rt2ae.RiskPolicy> i = listriskpolicy.iterator();
		while(i.hasNext()){
			eu.musesproject.server.rt2ae.RiskPolicy riskpolicy_temp = i.next();
			RiskValue risk = new RiskValue(riskpolicy_temp.getRiskvalue(), riskpolicy_temp.getDescription());
			RiskPolicy r = new RiskPolicy(risk, null);
			
			listriskpolicysim.add(r);
		}
		return listriskpolicysim;		
	}

	/* (non-Javadoc)
	 * @see eu.muses.sim.persistence.PersistenceManager#setRiskPolicies(java.util.List)
	 */
	@Override
	public void setRiskPolicies(List<RiskPolicy> riskPolicies) {
		Iterator<RiskPolicy> i = riskPolicies.iterator();
		while(i.hasNext()){
			eu.musesproject.server.rt2ae.RiskPolicy riskpolicy = new eu.musesproject.server.rt2ae.RiskPolicy();
			RiskPolicy r = i.next();
		
			riskpolicy.setDescription(r.getRiskValue().getDescription());
			riskpolicy.setRiskvalue(r.getRiskValue().getValue());			
			riskpolicy.persist();	
		}
	}

	/* (non-Javadoc)
	 * @see eu.muses.sim.persistence.PersistenceManager#getSimUsers()
	 */
	@SuppressWarnings("static-access")
	@Override
	public List<SimUser> getSimUsers() {
		eu.musesproject.server.rt2ae.User user = new eu.musesproject.server.rt2ae.User();
		List<eu.musesproject.server.rt2ae.User> l = user.findAllUsers();
		List<SimUser> listsimusersim = new ArrayList<SimUser>();
		Iterator<eu.musesproject.server.rt2ae.User> i = l.iterator();
		while(i.hasNext()){
			eu.musesproject.server.rt2ae.User user_temp = i.next();
			UserTrustValue u = new UserTrustValue();
			u.setValue(user_temp.getTrustvalue());
			//System.out.println(user_temp.getName()+" "+user_temp.getHourlyCost()+"   "+u);
			SimUser s = new SimUser(user_temp.getName(), user_temp.getHourlyCost(), u);

			listsimusersim.add(s);
		}
		return listsimusersim;	
	}

	/* (non-Javadoc)
	 * @see eu.muses.sim.persistence.PersistenceManager#setSimUsers(java.util.List)
	 */
	@Override
	public void setSimUsers(List<SimUser> simUsers) {
		Iterator<SimUser> i = simUsers.iterator();
		while(i.hasNext()){
			eu.musesproject.server.rt2ae.User user = new eu.musesproject.server.rt2ae.User();
			SimUser s = i.next();
			user.setEmail("");
			user.setHourlyCost(s.getHourlyCost());
			user.setName(s.getNickname());
			user.setTrustvalue(s.getTrustValue().getValue());
			user.setSurname("");
			user.persist();	
		}

	}

	/* (non-Javadoc)
	 * @see eu.muses.sim.persistence.PersistenceManager#getCluesThreatTable()
	 */
	@Override
	public CluesThreatTable getCluesThreatTable() {
		CluesThreatTable cluethreattable = new CluesThreatTable();
		eu.musesproject.server.rt2ae.Threat threat = new eu.musesproject.server.rt2ae.Threat();
		List<eu.musesproject.server.rt2ae.Threat> l = threat.findAllThreats();
		List<Threat> lsim = new ArrayList<Threat>();
		Iterator<eu.musesproject.server.rt2ae.Threat> i = l.iterator();
		while(i.hasNext()){
			eu.musesproject.server.rt2ae.Threat threat_temp = i.next();
			List<Clue> c = new ArrayList(threat_temp.getClues());
			
			
			//Threat t = new Threat(threat_temp.getDescription(),p, c);
			CluesThreatEntry e = new CluesThreatEntry();
			e.setClues(c);
			Probability p = new Probability();
			p.setProb(threat_temp.getProbability());
			Collection<Outcome> c1 = new ArrayList(threat_temp.getOutcomes());

			Threat t = new Threat(threat_temp.getDescription(), p, c1);
			e.setThreat(t);
			
			//t.setBadOutcomeCount(threat_temp.getBadOutcomeCount());
			//t.setOccurences(threat_temp.getOccurences());
			
			cluethreattable.addMapping(c, t);
		}
		
		
		return cluethreattable;//lsim;
	}

	/* (non-Javadoc)
	 * @see eu.muses.sim.persistence.PersistenceManager#setCluesThreatTable(eu.muses.wp5.CluesThreatTable)
	 */
	@Override
	public void setCluesThreatTable(CluesThreatTable cluesThreatTable) {
	}

	/* (non-Javadoc)
	 * @see eu.muses.sim.persistence.PersistenceManager#getAccessRequests()
	 */
	@Override
	public List<AccessRequest> getAccessRequests() {
		eu.musesproject.server.rt2ae.Accessrequest accessrequest = new eu.musesproject.server.rt2ae.Accessrequest();
		List<eu.musesproject.server.rt2ae.Accessrequest> l = accessrequest.findAllAccessrequests();
		eu.musesproject.server.rt2ae.Asset asset= new eu.musesproject.server.rt2ae.Asset();
		
		List<AccessRequest> listaccessrequestsim = new ArrayList<AccessRequest>();
		Iterator<eu.musesproject.server.rt2ae.Accessrequest> i = l.iterator();
		while(i.hasNext()){
			eu.musesproject.server.rt2ae.Accessrequest accessrequests = i.next();
			eu.musesproject.server.rt2ae.Accessrequest accessrequest_temp = i.next();
			eu.musesproject.server.rt2ae.Asset as = accessrequests.getAssetId();
			Asset a1 = new Asset(as.getAssetName(), as.getValue());
			
			AccessRequest a = new AccessRequest(a1);
		
			
			
		}
		return listaccessrequestsim;
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
		o1.setCostBenefit(222.2);
		o1.setDescription("vvvvvvvvvv");
		
		Outcome o2 = new Outcome();
		o2.setCostBenefit(333.3);
		o2.setDescription("yyyyyyy");
		
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
		
		Clue c = new Clue("malware");
		Clue c1 = new Clue("spyware1");
		List<Clue> l2 = new ArrayList<Clue>();
		l2.add(c);
		l2.add(c1);
		//p.setClues(l2);
		
		UserTrustValue u = new UserTrustValue();
		u.setValue(0.999);
		UserTrustValue u1 = new UserTrustValue();
		u.setValue(0.888);
		SimUser s = new SimUser("jack", 100.0, u);
		SimUser s1 = new SimUser("tony", 200.0, u1);
		List<SimUser> l3 = new ArrayList<SimUser>();
		l3.add(s);
		l3.add(s1);
		//p.setSimUsers(l3);
	
		Probability p1 = new Probability();
		p1.setProb(0.7777);
		Probability p2 = new Probability();
		p2.setProb(0.66);
		Threat t3 = new Threat("oieuioeuwroe", p1, l);
		Threat t4 = new Threat("ewrewrew", p2, l);
		List<Threat> l4 = new ArrayList<Threat>();
		l4.add(t3);
		l4.add(t4);
		//p.setThreats(l4);
		
		RiskValue r = new RiskValue(444.5, "kooooooooo");
		RiskValue r1 = new RiskValue(5555.4, "okkkkkkkk");

		
		RiskPolicy  r3 = new RiskPolicy(r,null);
		RiskPolicy r4 = new RiskPolicy(r1, null);
		List<RiskPolicy> l5 = new ArrayList<RiskPolicy>();
		l5.add(r3);
		l5.add(r4);
		p.setRiskPolicies(l5);
		
		
		System.out.println("List of all users: "+p.getCluesThreatTable().getCluesThreatTable().toString());
	}

}
