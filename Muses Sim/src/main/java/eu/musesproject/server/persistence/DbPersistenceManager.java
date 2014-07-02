/**
 * 
 */
package eu.musesproject.server.persistence;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import eu.muses.sim.OpportunityDescriptor;
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
import eu.muses.sim.trustman.TrustValue;
import eu.muses.sim.trustman.UserTrustValue;
import eu.muses.sim.userman.action.AccessAction;
import eu.muses.sim.userman.action.GiveUpAction;
import eu.muses.wp5.Clue;
import eu.muses.wp5.CluesThreatEntry;
import eu.muses.wp5.CluesThreatTable;
import eu.musesproject.server.rt2ae.Accessrequest;
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
	 * this function will return the list of all Outcomes in the database
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
	 * this function will persist the list of Outcomes in the database
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
	 * this function will return the list of all Opportunities store in the database
	 */
	@Override
	public List<Opportunity> getOpportunities() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see eu.muses.sim.persistence.PersistenceManager#setOpportunities(java.util.List)
	 * this function will persist the list of Opportunities in the database 
	 */
	@Override
	public void setOpportunities(List<Opportunity> opportunities) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see eu.muses.sim.persistence.PersistenceManager#getAssets()
	 * this function will return the list of all Assets store in the database
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
	 * this function will persist the list of Assets in the database
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
			//Collection<Outcome> c = new ArrayList(threat_temp.getOutcomes());
			
			Set<Outcome> listoutcome = new HashSet<Outcome>();
			Iterator<eu.musesproject.server.rt2ae.Outcome> it = threat_temp.getOutcomes().iterator();
			while(it.hasNext()){
				Outcome outcome = new Outcome();
				eu.musesproject.server.rt2ae.Outcome o = it.next();
				outcome.setCostBenefit(o.getCostbenefit());
				outcome.setDescription(o.getDescription());
				//outcome.setThreatId(threat);
				listoutcome.add(outcome);
			}
			
			Probability p = new Probability();
			p.setProb(threat_temp.getProbability());
			Threat t = new Threat(threat_temp.getDescription(),p, listoutcome);
			t.setOccurences(threat_temp.getOccurences());
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
			List<eu.musesproject.server.rt2ae.Threat> listthreat = new ArrayList<eu.musesproject.server.rt2ae.Threat>();
						
			if (eu.musesproject.server.rt2ae.Threat.findThreatbyDescription(t.getDescription()).size()>0){
				listthreat = eu.musesproject.server.rt2ae.Threat.findThreatbyDescription(t.getDescription());
				System.out.println(listthreat.size());
				listthreat.get(0).setOccurences(t.getOccurences());
				listthreat.get(0).setProbability(t.getProbabilityValue());
				listthreat.get(0).setBadOutcomeCount(t.getBadOutcomeCount());
				listthreat.get(0).setDescription(t.getDescription());
				listthreat.get(0).merge();
			}else{
				threat.setDescription(t.getDescription());
				threat.setProbability(t.getProbabilityValue());
				threat.setBadOutcomeCount(t.getBadOutcomeCount());
				threat.setOccurences(t.getOccurences());
			    threat.persist();
				
			}		
		    
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
	@SuppressWarnings({ "static-access" })
	@Override
	public CluesThreatTable getCluesThreatTable() {
		CluesThreatTable cluethreattable = new CluesThreatTable();
		eu.musesproject.server.rt2ae.Threat threat = new eu.musesproject.server.rt2ae.Threat();
		List<eu.musesproject.server.rt2ae.Threat> l = threat.findAllThreats();
		Iterator<eu.musesproject.server.rt2ae.Threat> i = l.iterator();
		while(i.hasNext()){
			eu.musesproject.server.rt2ae.Threat threat_temp = i.next();
			
			List<Clue> list = new ArrayList<Clue>();
			Iterator<eu.musesproject.server.rt2ae.Clue> it = threat_temp.getClues().iterator();
			while(it.hasNext()){
				eu.musesproject.server.rt2ae.Clue clue = new eu.musesproject.server.rt2ae.Clue();
				clue = it.next();
				Clue c = new Clue();
				c.setId(clue.getValue());
				
				list.add(c);
			}
			CluesThreatEntry e = new CluesThreatEntry();
			e.setClues(list);
			Probability p = new Probability();
			p.setProb(threat_temp.getProbability());
			
			List<Outcome> listoutcome = new ArrayList<Outcome>();
			Iterator<eu.musesproject.server.rt2ae.Outcome> its = threat_temp.getOutcomes().iterator();
			while(its.hasNext()){
				eu.musesproject.server.rt2ae.Outcome outcome = new eu.musesproject.server.rt2ae.Outcome();
				outcome = its.next();
				Outcome o = new Outcome();
				o.setCostBenefit(outcome.getCostbenefit());
				o.setDescription(outcome.getDescription());
				listoutcome.add(o);
			}
			Threat t = new Threat(threat_temp.getDescription(), p, listoutcome);
			e.setThreat(t);
			cluethreattable.addMapping(list, t);
		}
		return cluethreattable;
	}

	/* (non-Javadoc)
	 * @see eu.muses.sim.persistence.PersistenceManager#setCluesThreatTable(eu.muses.wp5.CluesThreatTable)
	 */
	@Override
	public void setCluesThreatTable(CluesThreatTable cluesThreatTable) {
		Iterator<CluesThreatEntry> i = cluesThreatTable.getCluesThreatTable().iterator();
		while(i.hasNext()){
			eu.musesproject.server.rt2ae.Threat threat = new eu.musesproject.server.rt2ae.Threat();
			CluesThreatEntry t = i.next();
			Set<eu.musesproject.server.rt2ae.Clue> list = new HashSet<eu.musesproject.server.rt2ae.Clue>();
			Iterator<Clue> it = t.getClues().iterator();
			while(it.hasNext()){
				eu.musesproject.server.rt2ae.Clue clue = new eu.musesproject.server.rt2ae.Clue();
				Clue c = it.next();
				clue.setValue(c.getId());
				clue.setThreatId(threat);
				list.add(clue);
			}
			Set<eu.musesproject.server.rt2ae.Outcome> listoutcome = new HashSet<eu.musesproject.server.rt2ae.Outcome>();
			Iterator<Outcome> its = t.getThreat().getOutcomes().iterator();
			while(its.hasNext()){
				eu.musesproject.server.rt2ae.Outcome outcome = new eu.musesproject.server.rt2ae.Outcome();
				Outcome o = its.next();
				outcome.setCostbenefit(o.getCostBenefit());
				outcome.setDescription(o.getDescription());
				outcome.setThreatId(threat);
				listoutcome.add(outcome);
			}
			
			
			threat.setClues(list);
			threat.setOutcomes(listoutcome);		
			threat.setDescription(t.getThreat().getDescription());
			threat.setProbability(t.getThreat().getProbabilityValue());
			threat.setBadOutcomeCount(t.getThreat().getBadOutcomeCount());
			threat.setOccurences(t.getThreat().getOccurences());
			
		    threat.persist();
		    
		    Iterator<eu.musesproject.server.rt2ae.Clue> ist = list.iterator();
			while(ist.hasNext()){
				eu.musesproject.server.rt2ae.Clue clue1 = new eu.musesproject.server.rt2ae.Clue();
				clue1 = ist.next();
				clue1.persist();
			}
		    
		}
		
		
	}

	/* (non-Javadoc)
	 * @see eu.muses.sim.persistence.PersistenceManager#getAccessRequests()
	 */
	@SuppressWarnings("static-access")
	@Override
	public List<AccessRequest> getAccessRequests() {
		eu.musesproject.server.rt2ae.Accessrequest accessrequest = new eu.musesproject.server.rt2ae.Accessrequest();
		List<eu.musesproject.server.rt2ae.Accessrequest> l = accessrequest.findAllAccessrequests();
		
		List<AccessRequest> listaccessrequestsim = new ArrayList<AccessRequest>();
		Iterator<eu.musesproject.server.rt2ae.Accessrequest> i = l.iterator();
		while(i.hasNext()){
			eu.musesproject.server.rt2ae.Accessrequest accessrequests = i.next();
			List<Asset> listasset = new ArrayList<Asset>();
			Asset a = new Asset(accessrequests.getAssetId().getAssetName(), accessrequests.getAssetId().getValue());
			listasset.add(a);
			AccessRequest access = new AccessRequest();
			access.setRequestedCorporateAssets(null);
			access.setUserAccessDecision(null);
			access.setCorporateAccessRequestDecision(null);
			access.setRiskEvent(null);
			access.setTime(accessrequests.getTime());

			
			if(accessrequests.getUseractionId().getId() == 0)
				access.setUserAction(new AccessAction());
			else
				access.setUserAction(new GiveUpAction());
			
			List<Outcome> listoutcome1 = new ArrayList<Outcome>();
			Iterator<eu.musesproject.server.rt2ae.Outcome> its = accessrequests.getOpportunityId().getOutcomes().iterator();
			while(its.hasNext()){
				
				Outcome outcome = new Outcome();
				eu.musesproject.server.rt2ae.Outcome o = its.next();
				outcome.setCostBenefit(o.getCostbenefit());
				outcome.setDescription(o.getDescription());
				listoutcome1.add(outcome);
			}
			
			OpportunityDescriptor opportunityDescriptor = new OpportunityDescriptor();
			if(listoutcome1.size() !=0){
			 opportunityDescriptor = new OpportunityDescriptor(accessrequests.getOpportunityId().getDescription(),listasset,listoutcome1.get(0));
			 for (int j = 1; j < listoutcome1.size(); j++) {
				 opportunityDescriptor.addOutcome(listoutcome1.get(j));
			}
			}else{
			opportunityDescriptor = new OpportunityDescriptor(accessrequests.getOpportunityId().getDescription(),listasset,null);
	
			}
			access.setOpportunityDescriptor(opportunityDescriptor);
			if(accessrequests.getSolved()!=0){
				access.setSolved(true);;
			}else{
				access.setSolved(false);;
			}
			TrustValue trustvalue = new TrustValue();
			trustvalue.setValue(0.5);
			SimUser user = new SimUser(accessrequests.getUserId().getName(), 0, trustvalue);
			access.setUser(user);
			CluesThreatEntry cluesThreatEntry = new CluesThreatEntry();
			Probability p = new Probability();
			p.setProb(accessrequests.getThreatid().getProbability());
			Set<Outcome> listoutcome = new HashSet<Outcome>();

			Iterator<eu.musesproject.server.rt2ae.Outcome> ist = accessrequests.getThreatid().getOutcomes().iterator();
			while(ist.hasNext()){
				Outcome outcome = new Outcome();
				eu.musesproject.server.rt2ae.Outcome o = ist.next();
				
				outcome.setCostBenefit(o.getCostbenefit());
				outcome.setDescription(o.getDescription());
				listoutcome.add(outcome);
			}
			Threat ts = new Threat(accessrequests.getThreatid().getDescription(), p, listoutcome);
			ts.setOccurences(accessrequests.getThreatid().getOccurences());
			ts.setBadOutcomeCount(accessrequests.getThreatid().getBadOutcomeCount());
			
			
			List<Clue> list = new ArrayList<Clue>();
			Iterator<eu.musesproject.server.rt2ae.Clue> it = accessrequests.getThreatid().getClues().iterator();
			while(it.hasNext()){
				Clue clue = new Clue();
				eu.musesproject.server.rt2ae.Clue c = it.next();
				clue.setId(c.getValue());
				list.add(clue);
			}
			cluesThreatEntry.setClues(list);
			cluesThreatEntry.setThreat(ts);
			access.setCluesThreatEntry(cluesThreatEntry);
			access.setAccessRisk(null);
			listaccessrequestsim.add(access);	
		}
		
		return listaccessrequestsim;
	}

	/* (non-Javadoc)
	 * @see eu.muses.sim.persistence.PersistenceManager#setAccessRequests(java.util.List)
	 */
	@Override
	public void setAccessRequests(List<AccessRequest> accessRequests) {
		
		Set<eu.musesproject.server.rt2ae.Asset> listasset = new HashSet<eu.musesproject.server.rt2ae.Asset>();
		
		Iterator<AccessRequest> i = accessRequests.iterator();
		while(i.hasNext()){
			AccessRequest accessrequest = i.next();
			eu.musesproject.server.rt2ae.Accessrequest access = new eu.musesproject.server.rt2ae.Accessrequest();

			Iterator<Asset> it = accessrequest.getOpportunityDescriptor().getRequestedAssets().iterator();
			while(it.hasNext()){
				Asset asset1 = it.next();
				List <eu.musesproject.server.rt2ae.Asset> listassets = eu.musesproject.server.rt2ae.Asset.findAssetbyName(asset1.getAssetName());
				access.setAssetId(listassets.get(0));

			}
			Probability p = new Probability();
		
			p.setProb(accessrequest.getCluesThreatEntry().getThreat().getProbability().getProb());
			
			Set<eu.musesproject.server.rt2ae.Outcome> listoutcome = new HashSet<eu.musesproject.server.rt2ae.Outcome>();
			Iterator<Outcome> its = accessrequest.getCluesThreatEntry().getThreat().getOutcomes().iterator();
			eu.musesproject.server.rt2ae.Threat threat = new eu.musesproject.server.rt2ae.Threat();
			threat.setProbability(accessrequest.getCluesThreatEntry().getThreat().getProbability().getProb());
			threat.setDescription(accessrequest.getCluesThreatEntry().getThreat().getDescription());
			while(its.hasNext()){
				eu.musesproject.server.rt2ae.Outcome outcome = new eu.musesproject.server.rt2ae.Outcome();
				Outcome o = its.next();
				outcome.setCostbenefit(o.getCostBenefit());
				outcome.setDescription(o.getDescription());
				outcome.setThreatId(threat);
				listoutcome.add(outcome);
			}
			
			
			
			threat.setOutcomes(listoutcome);
			threat.setOccurences(accessrequest.getCluesThreatEntry().getThreat().getOccurences());
			threat.setBadOutcomeCount(accessrequest.getCluesThreatEntry().getThreat().getBadOutcomeCount());
			List<eu.musesproject.server.rt2ae.Threat> listthreats = eu.musesproject.server.rt2ae.Threat.findThreatbyDescription(accessrequest.getCluesThreatEntry().getThreat().getDescription());
			access.setThreatid(eu.musesproject.server.rt2ae.Threat.findThreat(listthreats.get(0).getThreatId()));
			if(accessrequest.isSolved()){
				access.setSolved((short) 1);
			}else{
				access.setSolved((short) 0);
			}
			access.setSolved((short) 0);
			User user = new User();
			user.setName(accessrequest.getUser().getNickname());
			user.setHourlyCost(accessrequest.getUser().getHourlyCost());
			user.setSurname("");
			user.setEmail("");
			user.setTrustvalue(accessrequest.getUser().getTrustValue().getValue());
			List <User> listusers = eu.musesproject.server.rt2ae.User.findOneUsers(accessrequest.getUser().getNickname());
			
			access.setUserId(eu.musesproject.server.rt2ae.User.findUser(listusers.get(0).getUserId()));
			

			
			eu.musesproject.server.rt2ae.UserAction useraction = new eu.musesproject.server.rt2ae.UserAction();
			useraction.setId(accessrequest.getUserAction().getId());
			useraction.persist();
			access.setUseractionId(useraction);
			eu.musesproject.server.rt2ae.Opportunity opportunity = new eu.musesproject.server.rt2ae.Opportunity();
			opportunity.setDescription(accessrequest.getOpportunityDescriptor().getDescription());
			opportunity.setCostbenefit(1000.0);

			Set<eu.musesproject.server.rt2ae.Outcome> listoutcome1 = new HashSet<eu.musesproject.server.rt2ae.Outcome>();

			Iterator<Outcome> is = accessrequest.getOpportunityDescriptor().getOutcomes().iterator();
			while(is.hasNext()){
				eu.musesproject.server.rt2ae.Outcome outcome = new eu.musesproject.server.rt2ae.Outcome();
				Outcome o = is.next();
				outcome.setCostbenefit(o.getCostBenefit());
				outcome.setDescription(o.getDescription());
				outcome.setOpportunityId(opportunity);
				listoutcome1.add(outcome);
			}
			opportunity.setOutcomes(listoutcome1);
			opportunity.setAssets(listasset);
			opportunity.persist();
		
			access.setOpportunityId(opportunity);
			
			Iterator<eu.musesproject.server.rt2ae.Outcome> ist2 = listoutcome1.iterator();
				while(ist2.hasNext()){
					eu.musesproject.server.rt2ae.Outcome outcome = new eu.musesproject.server.rt2ae.Outcome();
					outcome = ist2.next();
					outcome.persist();
			}
		    Calendar now = Calendar.getInstance();
		   
			access.setTime(now);
		    
			if(Accessrequest.findAccessrequestbyTimestampandThreat(accessrequest.getTime(), listthreats.get(0)).size()>0){
			List<Accessrequest> listaccessrequest = Accessrequest.findAccessrequestbyTimestampandThreat(accessrequest.getTime(), listthreats.get(0));
			listaccessrequest.get(0).setSolved((short) 1);
			listaccessrequest.get(0).merge();
			}else{
				access.persist();
			}	
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			
	}

}
