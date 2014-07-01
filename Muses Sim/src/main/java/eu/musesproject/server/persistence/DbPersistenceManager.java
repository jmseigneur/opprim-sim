/**
 * 
 */
package eu.musesproject.server.persistence;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Calendar;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import eu.muses.sim.OpportunityDescriptor;
import eu.muses.sim.Outcome;
import eu.muses.sim.persistence.PersistenceManager;
import eu.muses.sim.request.AccessRequest;
import eu.muses.sim.riskman.Probability;
import eu.muses.sim.riskman.RiskCommunication;
import eu.muses.sim.riskman.RiskPolicy;
import eu.muses.sim.riskman.RiskValue;
import eu.muses.sim.riskman.asset.Asset;
import eu.muses.sim.riskman.opportunity.Opportunity;
import eu.muses.sim.riskman.threat.Threat;
import eu.muses.sim.test.SimUser;
import eu.muses.sim.trustman.TrustValue;
import eu.muses.sim.trustman.UserTrustValue;
import eu.muses.sim.userman.action.UserAction;
import eu.muses.wp5.Clue;
import eu.muses.wp5.CluesThreatEntry;
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
			lsim.add(t);
		}
		return lsim;		
	}

	/* (non-Javadoc)
	 * @see eu.muses.sim.persistence.PersistenceManager#setThreats(java.util.List)
	 */
	@Override
	public void setThreats(List<Threat> threats) {
		eu.musesproject.server.rt2ae.Threat ts = new eu.musesproject.server.rt2ae.Threat();
		
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
			/*if (threat.findThreatbyDescription(t.getDescription())!=null){
				threat.merge();
			}else{
			    threat.persist();
				
			}*/			
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
	@SuppressWarnings({ "unchecked", "rawtypes", "static-access" })
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
			//List<Clue> c = new ArrayList(threat_temp.getClues());
		
			
			//Threat t = new Threat(threat_temp.getDescription(),p, c);
			CluesThreatEntry e = new CluesThreatEntry();
			e.setClues(list);
			Probability p = new Probability();
			p.setProb(threat_temp.getProbability());
			//Collection<Outcome> c1 = new ArrayList(threat_temp.getOutcomes());
			
			List<Outcome> listoutcome = new ArrayList<Outcome>();
			Iterator<eu.musesproject.server.rt2ae.Outcome> its = threat_temp.getOutcomes().iterator();
			while(its.hasNext()){
				eu.musesproject.server.rt2ae.Outcome outcome = new eu.musesproject.server.rt2ae.Outcome();
				outcome = its.next();
				Outcome o = new Outcome();
				o.setCostBenefit(outcome.getCostbenefit());
				o.setDescription(outcome.getDescription());
				//o.setThreatId(threat);
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
		DbPersistenceManager p = new DbPersistenceManager();
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
			Iterator<eu.musesproject.server.rt2ae.Asset> ite = accessrequests.getAssets().iterator();
			List<Asset> listasset = new ArrayList<Asset>();
			while(ite.hasNext()){
			
				eu.musesproject.server.rt2ae.Asset asset_temp = ite.next();
				Asset a = new Asset(asset_temp.getAssetName(), asset_temp.getValue());
				listasset.add(a);
			}
			

			//Asset as = new Asset(accessrequests.getAssetId().getAssetName(), accessrequests.getAssetId().getValue());
			AccessRequest access = new AccessRequest();
			access.setRequestedCorporateAssets(listasset);
			access.setUserAccessDecision(null);
			access.setCorporateAccessRequestDecision(null);
			access.setRiskEvent(null);
			UserAction u = new UserAction() {
			};
			//u.setId(accessrequests.getUseractionId().getId());
			
			//access.setUserAction(u);
			List<Outcome> listoutcome1 = new ArrayList<Outcome>();
			Iterator<eu.musesproject.server.rt2ae.Outcome> its = accessrequests.getOpportunityId().getOutcomes().iterator();
			while(its.hasNext()){
				Outcome outcome = new Outcome();
				eu.musesproject.server.rt2ae.Outcome o = its.next();
				outcome.setCostBenefit(o.getCostbenefit());
				outcome.setDescription(o.getDescription());
				listoutcome1.add(outcome);
			}
			Collection<Asset> collection = new ArrayList<Asset>(listasset);
			//collection.add(listasset.get(0));
			
			OpportunityDescriptor opportunityDescriptor = new OpportunityDescriptor();
			if(listoutcome1.size() !=0){
			 opportunityDescriptor = new OpportunityDescriptor(accessrequests.getOpportunityId().getDescription(),collection,listoutcome1.get(0));
			}else{
			opportunityDescriptor = new OpportunityDescriptor(accessrequests.getOpportunityId().getDescription(),collection,null);
	
			}
			//opportunityDescriptor.addOutcome(listoutcome1.get(1));
			access.setOpportunityDescriptor(opportunityDescriptor);
			if(accessrequests.getSolved()!=0){
				access.setSolved(false);;
			}else{
				access.setSolved(true);;
			}
			//access.setSolved(false);
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
				//outcome.setThreatId(accessrequests.getThreatid());
				listoutcome.add(outcome);
			}
			Threat ts = new Threat(accessrequests.getThreatid().getDescription(), p, listoutcome);
			
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
		eu.musesproject.server.rt2ae.Asset asset= new eu.musesproject.server.rt2ae.Asset();
		
		List<AccessRequest> listaccessrequestsim = new ArrayList<AccessRequest>();
		Set<eu.musesproject.server.rt2ae.Asset> listasset = new HashSet<eu.musesproject.server.rt2ae.Asset>();

		Iterator<AccessRequest> i = accessRequests.iterator();
		while(i.hasNext()){
			AccessRequest accessrequest = i.next();
			eu.musesproject.server.rt2ae.Accessrequest access = new eu.musesproject.server.rt2ae.Accessrequest();

			Iterator<Asset> it = accessrequest.getRequestedCorporateAsset().iterator();
			while(it.hasNext()){
				Asset asset1 = it.next();
				eu.musesproject.server.rt2ae.Asset as = new eu.musesproject.server.rt2ae.Asset();
				as.setAssetName(asset1.getAssetName());
				as.setValue(asset1.getValue());
				as.setConfidentialLevel("PUBLIC");
				as.setDescription("");
				as.setLocation("");
				as.setAccessrequestId(access);
				//as.persist();
				listasset.add(as);
			}
			access.setAssets(listasset);
			Probability p = new Probability();
		
			p.setProb(accessrequest.getCluesThreatEntry().getThreat().getProbability().getProb());
			
			Set<eu.musesproject.server.rt2ae.Outcome> listoutcome = new HashSet<eu.musesproject.server.rt2ae.Outcome>();
			Iterator<Outcome> its = accessrequest.getCluesThreatEntry().getThreat().getOutcomes().iterator();
			eu.musesproject.server.rt2ae.Threat threat = new eu.musesproject.server.rt2ae.Threat();
			threat.setProbability(0.3);
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
			Set<eu.musesproject.server.rt2ae.Clue> listclues = new HashSet<eu.musesproject.server.rt2ae.Clue>();
			/*Iterator<Clue> ist = accessrequest.getCluesThreatEntry().getClues().iterator();
			while(ist.hasNext()){
				eu.musesproject.server.rt2ae.Clue clue = new eu.musesproject.server.rt2ae.Clue();
				Clue c = ist.next();
				clue.setValue(c.getId());
				clue.setThreatId(threat);
				//clue.persist();
				listclues.add(clue);
			}*/
			//threat.setClues(listclues);
			eu.musesproject.server.rt2ae.Threat threats = new eu.musesproject.server.rt2ae.Threat();
			
			//threat.persist();
			List<eu.musesproject.server.rt2ae.Threat> listthreats = eu.musesproject.server.rt2ae.Threat.findThreatbyDescription(accessrequest.getCluesThreatEntry().getThreat().getDescription());
			access.setThreatid(threats.findThreat(listthreats.get(0).getThreatId()));
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
			eu.musesproject.server.rt2ae.User users = new eu.musesproject.server.rt2ae.User();
			//users.findUser(59);
			List <User> listusers = users.findOneUsers(accessrequest.getUser().getNickname());
			//user.persist();
			access.setUserId(users.findUser(listusers.get(0).getUserId()));
			
			
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
			opportunity.persist();
			
			
			access.setOpportunityId(opportunity);
		    Calendar now = Calendar.getInstance();
			access.setTime(now);
			access.persist();
			
			
			
			/*Iterator<eu.musesproject.server.rt2ae.Asset> ist4 = listasset.iterator();
			while(ist4.hasNext()){
				eu.musesproject.server.rt2ae.Asset asset1 = new eu.musesproject.server.rt2ae.Asset();
				asset1 = ist4.next();
				asset1.persist();
			}
			/*  Iterator<eu.musesproject.server.rt2ae.Outcome> ist3 = listoutcome.iterator();
				while(ist3.hasNext()){
					eu.musesproject.server.rt2ae.Outcome outcome1 = new eu.musesproject.server.rt2ae.Outcome();
					outcome1 = ist3.next();
					outcome1.persist();
				}
			
			  Iterator<eu.musesproject.server.rt2ae.Outcome> ist2 = listoutcome1.iterator();
				while(ist2.hasNext()){
					eu.musesproject.server.rt2ae.Outcome outcome = new eu.musesproject.server.rt2ae.Outcome();
					outcome = ist2.next();
					outcome.persist();
				}
			
			  Iterator<eu.musesproject.server.rt2ae.Clue> ist1 = listclues.iterator();
				while(ist1.hasNext()){
					eu.musesproject.server.rt2ae.Clue clue1 = new eu.musesproject.server.rt2ae.Clue();
					clue1 = ist1.next();
					clue1.persist();
				}*/
			
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			DbPersistenceManager p = new DbPersistenceManager();
			User u = new User();
			System.out.println("test " + u.findOneUsers("TestUser").size());
			/*Outcome o = new Outcome();
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
		
		Clue c = new Clue("spy");
		Clue c1 = new Clue("jailbroken");
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
		
	
		Threat t3 = new Threat("threat_spy", p1, l);
		eu.musesproject.server.rt2ae.Clue c4 = new eu.musesproject.server.rt2ae.Clue();
		c4.setValue("example");
		eu.musesproject.server.rt2ae.Threat ts = new eu.musesproject.server.rt2ae.Threat();
		List<eu.musesproject.server.rt2ae.Clue> l7 = new ArrayList<eu.musesproject.server.rt2ae.Clue>();
		l7.add(c4);
		Set<eu.musesproject.server.rt2ae.Clue> list = new HashSet<eu.musesproject.server.rt2ae.Clue>();
		ts.setDescription("threat_example");
		ts.setProbability(0.5);
		ts.setOutcomes(null);
		eu.musesproject.server.rt2ae.Threat threats = new eu.musesproject.server.rt2ae.Threat();
		//cl.setThreatId(ts);
		c4.setThreatId(ts);
		list.add(c4);
		ts.setClues(list);
		
		//ts.persist();
		//c4.persist();
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
		//p.setRiskPolicies(l5);
		//p.getCluesThreatTable().
		CluesThreatTable cluetable = new CluesThreatTable();
		CluesThreatEntry clueentrytable = new CluesThreatEntry();
		List<CluesThreatEntry> l6 = new ArrayList<CluesThreatEntry>();

		clueentrytable.setClues(l2);
		clueentrytable.setThreat(t3);
		l6.add(clueentrytable);
		Collection<CluesThreatEntry> col1 = new ArrayList<CluesThreatEntry>(l6);
		//col1.size();
		cluetable.setCluesThreatTable(col1);
		//p.setCluesThreatTable(cluetable);
		/*Iterator<CluesThreatEntry> i = p.getCluesThreatTable().getCluesThreatTable().iterator();
		while(i.hasNext()){
			CluesThreatEntry clues = i.next();
			System.out.println("List of clues: "+clues.getClues().toString() +"  threat    " + clues.getThreat().getDescription()+"  Outomce "+clues.getThreat().getOutcomes().toString() );
	
		}*/
		
		/*AccessRequest accessrequest1 = new AccessRequest(a);
		accessrequest1.setUser(s);
		accessrequest1.setCluesThreatEntry(clueentrytable);
		OpportunityDescriptor opportunityDescriptor = new OpportunityDescriptor();
		opportunityDescriptor.setDescription("opportunity_accessrequest");
		opportunityDescriptor.addOutcome(o);
		opportunityDescriptor.addOutcome(o1);
		opportunityDescriptor.addOutcome(o2);
		UserAction useraction = new UserAction() {
		};
		useraction.setId(0);
		accessrequest1.setOpportunityDescriptor(opportunityDescriptor);
		accessrequest1.setUserAction(useraction);
		List<AccessRequest> accessRequests = new ArrayList<AccessRequest>();

		accessrequest1.setRequestedCorporateAssets(l1);
		accessRequests.add(accessrequest1);
		
		p.setAccessRequests(accessRequests);
		Iterator<AccessRequest> i = p.getAccessRequests().iterator();
		while(i.hasNext()){
			AccessRequest accessrequest = i.next();
			System.out.println("List of clues: "+accessrequest.getCluesThreatEntry().getClues().toString() +"  threat    " + accessrequest.getCluesThreatEntry().getThreat().getDescription()+"  Outomce_threat "+accessrequest.getCluesThreatEntry().getThreat().getOutcomes().toString()+" Outcome_opportunity "+accessrequest.getOpportunityDescriptor().getOutcomes().toString()+ " Opportunity_text "+ accessrequest.getOpportunityDescriptor().getDescription()+ " User: "+accessrequest.getUser().getNickname()+ " Assets: "+accessrequest.getRequestedCorporateAsset().toString() );
	
		}
		
		//System.out.println("List of all users: "+ p.getAccessRequests().get(0).toString());*/
	}

}
